/**
 *     Copyright (C) 2009-2014  Jack A. Rider All rights reserved.
 * 
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 * 
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 */

package gr.open.loglevelsmanager.loglevel;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortalPreferences;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import gr.open.loglevelsmanager.loglevel.model.LogLevel;
import gr.open.loglevelsmanager.loglevel.model.impl.LogLevelImpl;
import gr.open.loglevelsmanager.loglevel.service.LogLevelLocalServiceUtil;
import gr.open.loglevelsmanager.loglevel.service.permission.LogLevelEntryPermission;
import gr.open.loglevelsmanager.loglevel.service.permission.LogLevelPermission;
import gr.open.loglevelsmanager.loglevel.util.LogLevelUtil;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletURL;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * Portlet implementation class LogLevel
 */
public class LogLevelsManager extends MVCPortlet {

	private static final Log logger = LogFactoryUtil.getLog(LogLevelsManager.class);

	protected String editLogLevelJSP;

	protected String editJSP;

	protected String helpJSP;

	protected String viewJSP;

	protected String viewLogLevelJSP;

	private static Log _log = LogFactoryUtil.getLog(LogLevelsManager.class);

	@ProcessAction(name = "addLogLevel")
	public void addLogLevel(ActionRequest request, ActionResponse response)
		throws Exception {

		LogLevel logLevel = getLogLevelFromRequest(request);
		logLevel.setActivateOnStartup(true);
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();

		if (!LogLevelPermission.contains(permissionChecker, themeDisplay.getScopeGroupId(), "ADD_LOGLEVEL")) {
			LogLevelUtil.addParametersForDefaultView(response);
			SessionErrors.add(request, "permission-error");
			return;
		}
		ArrayList<String> errors = LogLevelValidator.validateLogLevel(logLevel, request);

		if (errors.isEmpty()) {
			try {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(LogLevel.class.getName(), request);
				LogLevelLocalServiceUtil.addLogLevel(logLevel, serviceContext);

				LogLevelUtil.addParametersForDefaultView(response);
				SessionMessages.add(request, "loglevel-added-successfully");

			}
			catch (Exception cvex) {
				SessionErrors.add(request, "please-enter-a-unique-code");
				PortalUtil.copyRequestParameters(request, response);
				LogLevelUtil.addParametersForAddWithErrors(response);
			}
		}
		else {
			for (String error : errors) {
				SessionErrors.add(request, error);
			}
			PortalUtil.copyRequestParameters(request, response);
			LogLevelUtil.addParametersForAddWithErrors(response);
		}
	}

	@ProcessAction(name = "copyLogLevel")
	public void copyLogLevel(ActionRequest request, ActionResponse response) {

		try {
			long logLevelId = ParamUtil.getLong(request, "resourcePrimKey");
			LogLevel logLevel = LogLevelLocalServiceUtil.getLogLevel(logLevelId);
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();

			if (!LogLevelEntryPermission.contains(permissionChecker, logLevel.getLogLevelId(), "COPY")) {
				LogLevelUtil.addParametersForDefaultView(response);
				SessionErrors.add(request, "permission-error");
				return;
			}

			LogLevel newLogLevel = new LogLevelImpl();
			BeanUtils.copyProperties(newLogLevel, logLevel);

			newLogLevel.setLogLevelId(0);
			newLogLevel.setCreateDate(new Date());
			newLogLevel.setModifiedDate(new Date());
			newLogLevel.setLogLevelDescription("Copy of " + logLevel.getLogLevelDescription());

			ServiceContext serviceContext = ServiceContextFactory.getInstance(LogLevel.class.getName(), request);
			LogLevelLocalServiceUtil.addLogLevel(newLogLevel, serviceContext);

			LogLevelUtil.addParametersForDefaultView(response);
			SessionMessages.add(request, "loglevel-added-successfully");
		}
		catch (PortalException e) {
			logger.error(e.getMessage(), e);
		}
		catch (SystemException e) {
			logger.error(e.getMessage(), e);
		}
		catch (IllegalAccessException e) {
			logger.error(e.getMessage(), e);
		}
		catch (InvocationTargetException e) {
			logger.error(e.getMessage(), e);
		}
	}

	private String dateTimeToJsp(Date date) {

		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		String stringDate = format.format(date);
		return stringDate;
	}

	private String dateToJsp(ActionRequest request, Date date) {

		PortletPreferences prefs = request.getPreferences();
		return dateToJsp(prefs, date);
	}

	private String dateToJsp(PortletPreferences prefs, Date date) {

		SimpleDateFormat format = new SimpleDateFormat(prefs.getValue("date-format", "yyyy/MM/dd"));
		String stringDate = format.format(date);
		return stringDate;
	}

	private String dateToJsp(RenderRequest request, Date date) {

		PortletPreferences prefs = request.getPreferences();
		return dateToJsp(prefs, date);
	}

	@ProcessAction(name = "deleteLogLevel")
	public void deleteLogLevel(ActionRequest request, ActionResponse response)
		throws Exception {

		long id = ParamUtil.getLong(request, "resourcePrimKey");

		if (Validator.isNotNull(id)) {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();

			if (!LogLevelEntryPermission.contains(permissionChecker, id, ActionKeys.DELETE)) {
				LogLevelUtil.addParametersForDefaultView(response);
				SessionErrors.add(request, "permission-error");
				return;
			}

			LogLevel logLevel = LogLevelLocalServiceUtil.getLogLevel(id);
			LogLevelLocalServiceUtil.deleteLogLevelEntry(logLevel);
			SessionMessages.add(request, "loglevel-deleted-successfully");
			response.setRenderParameter("LogLevelId", "0");
		}
		else {
			SessionErrors.add(request, "loglevel-error-deleting");
		}
	}

	/* Portlet Actions */

	@Override
	public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		showEditDefault(renderRequest, renderResponse);
	}

	@Override
	public void doHelp(RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		include(helpJSP, renderRequest, renderResponse);
	}

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		String jsp = (String) renderRequest.getParameter("view");
		if (jsp == null || jsp.equals("")) {
			showViewDefault(renderRequest, renderResponse);
		}
		else if (jsp.equalsIgnoreCase("editLogLevel")) {
			try {
				showViewEditLogLevel(renderRequest, renderResponse);
			}
			catch (Exception ex) {
				_log.debug(ex);
				try {
					showViewDefault(renderRequest, renderResponse);
				}
				catch (Exception ex1) {
					_log.debug(ex1);
				}
			}
		}
	}

	@ProcessAction(name = "editLogLevel")
	public void editLogLevel(ActionRequest request, ActionResponse response)
		throws Exception {

		long key = ParamUtil.getLong(request, "resourcePrimKey");
		if (Validator.isNotNull(key)) {
			LogLevelUtil.addParametersForEdit(response, key);

		}
	}

	@ProcessAction(name = "eventLogLevel")
	public void eventLogLevel(ActionRequest request, ActionResponse response)
		throws Exception {

		long key = ParamUtil.getLong(request, "resourcePrimKey");
		int containerStart = ParamUtil.getInteger(request, "containerStart");
		int containerEnd = ParamUtil.getInteger(request, "containerEnd");
		int cur = ParamUtil.getInteger(request, "cur");
		String orderByType = ParamUtil.getString(request, "orderByType");
		String orderByCol = ParamUtil.getString(request, "orderByCol");
		String loglevelFilter = ParamUtil.getString(request, "LogLevelFilter");
		if (Validator.isNotNull(key)) {
			response.setRenderParameter("highlightRowWithKey", Long.toString(key));
			response.setRenderParameter("containerStart", Integer.toString(containerStart));
			response.setRenderParameter("containerEnd", Integer.toString(containerEnd));
			response.setRenderParameter("cur", Integer.toString(cur));
			response.setRenderParameter("orderByType", orderByType);
			response.setRenderParameter("orderByCol", orderByCol);
			response.setRenderParameter("LogLevelFilter", loglevelFilter);
		}
	}

	private LogLevel getLogLevelFromRequest(PortletRequest request) {

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		LogLevelImpl logLevel = new LogLevelImpl();
		try {
			logLevel.setLogLevelId(ParamUtil.getLong(request, "LogLevelId"));
		}
		catch (Exception nfe) {
			// Controled en Validator
		}
		logLevel.setLogLevelDescription(ParamUtil.getString(request, "logLevelDescription"));
		logLevel.setLogLevelPriority(ParamUtil.getString(request, "logLevelPriority"));

		logLevel.setActivateOnStartup(ParamUtil.getBoolean(request, "activateOnStartup"));
		logLevel.setLogLevelScheduled(ParamUtil.getBoolean(request, "logLevelScheduled"));
		logLevel.setLogLevelCategory(ParamUtil.getString(request, "logLevelCategory"));
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		logLevel.setLogLevelEndDate(ParamUtil.getDate(request, "logLevelEndDate", sdf));

		int LogLevelStartDateTimeAno = ParamUtil.getInteger(request, "logLevelStartDateYear");
		int LogLevelStartDateTimeMes = ParamUtil.getInteger(request, "logLevelStartDateMonth") + 1;
		int LogLevelStartDateTimeDia = ParamUtil.getInteger(request, "logLevelStartDateDay");
		int LogLevelStartDateTimeHora = ParamUtil.getInteger(request, "logLevelStartDateHour");
		int LogLevelStartDateTimeMinuto = ParamUtil.getInteger(request, "logLevelStartDateMinute");
		int LogLevelStartDateTimeAmPm = ParamUtil.getInteger(request, "logLevelStartDateAmPm");

		if (LogLevelStartDateTimeAmPm == Calendar.PM) {
			LogLevelStartDateTimeHora += 12;
		}
		try {
			SimpleDateFormat formatterDateTime = new SimpleDateFormat("yyyy/MM/dd HH:mm");
			logLevel.setLogLevelStartDate(formatterDateTime.parse(LogLevelStartDateTimeAno + "/" +
				LogLevelStartDateTimeMes + "/" + LogLevelStartDateTimeDia + " " + LogLevelStartDateTimeHora + ":" +
				LogLevelStartDateTimeMinuto));
		}
		catch (ParseException e) {
			logLevel.setLogLevelStartDate(new Date());
		}

		int LogLevelEndDateTimeAno = ParamUtil.getInteger(request, "logLevelEndDateYear");
		int LogLevelEndDateTimeMes = ParamUtil.getInteger(request, "logLevelEndDateMonth") + 1;
		int LogLevelEndDateTimeDia = ParamUtil.getInteger(request, "logLevelEndDateDay");
		int LogLevelEndDateTimeHora = ParamUtil.getInteger(request, "logLevelEndDateHour");
		int LogLevelEndDateTimeMinuto = ParamUtil.getInteger(request, "logLevelEndDateMinute");
		int LogLevelEndDateTimeAmPm = ParamUtil.getInteger(request, "logLevelEndDateAmPm");

		if (LogLevelEndDateTimeAmPm == Calendar.PM) {
			LogLevelEndDateTimeHora += 12;
		}
		try {
			SimpleDateFormat formatterDateTime = new SimpleDateFormat("yyyy/MM/dd HH:mm");
			logLevel.setLogLevelEndDate(formatterDateTime.parse(LogLevelEndDateTimeAno + "/" + LogLevelEndDateTimeMes +
				"/" + LogLevelEndDateTimeDia + " " + LogLevelEndDateTimeHora + ":" + LogLevelEndDateTimeMinuto));
		}
		catch (ParseException e) {
			logLevel.setLogLevelEndDate(new Date());
		}

		try {
			logLevel.setPrimaryKey(ParamUtil.getLong(request, "resourcePrimKey"));
		}
		catch (NumberFormatException nfe) {
			// Controled en Validator
		}

		logLevel.setCompanyId(themeDisplay.getCompanyId());
		logLevel.setGroupId(themeDisplay.getScopeGroupId());
		logLevel.setUserId(themeDisplay.getUserId());

		logger.debug("GOT FROM REQUEST:" + logLevel);

		return logLevel;
	}

	@Override
	protected void include(String path, RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		PortletRequestDispatcher portletRequestDispatcher = getPortletContext().getRequestDispatcher(path);

		if (portletRequestDispatcher == null) {
			// do nothing
			// _log.error(path + " is not a valid include");
		}
		else {
			portletRequestDispatcher.include(renderRequest, renderResponse);
		}
	}

	@Override
	public void init()
		throws PortletException {

		// Edit Mode Pages
		editJSP = getInitParameter("edit-jsp");

		// Help Mode Pages
		helpJSP = getInitParameter("help-jsp");

		// View Mode Pages
		viewJSP = getInitParameter("view-jsp");

		// View Mode Edit LogLevel
		editLogLevelJSP = getInitParameter("edit-LogLevel-jsp");

		// View Mode Entry LogLevel
		viewLogLevelJSP = getInitParameter("view-LogLevel-jsp");
	}

	@ProcessAction(name = "newLogLevel")
	public void newLogLevel(ActionRequest request, ActionResponse response)
		throws Exception {

		LogLevelUtil.addParametersForAdd(response);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws PortletException, IOException {

		resourceResponse.setContentType("text/javascript");
		String resourceId = resourceRequest.getResourceID();

		if (Validator.isNotNull(resourceId) && resourceId.length() != 0) {

			if (resourceId.equalsIgnoreCase("exportFullLogLevelResourceURL")) {

				ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
				Locale locale = themeDisplay.getLocale();
				PortletConfig portletConfig =
					(PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);

				resourceResponse.setContentType("application/vnd.ms-excel");
				resourceResponse.setProperty("expires", "-1d");
				resourceResponse.setProperty("Pragma", "no-cache");
				resourceResponse.setProperty("Cache-control", "no-cache");
				resourceResponse.addProperty(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\" LogLevel\"");

				try {
					Workbook book =
						LogLevelExporter.generateFullExcel(themeDisplay.getScopeGroupId(), portletConfig, locale);
					OutputStream out = resourceResponse.getPortletOutputStream();
					book.write(out);
					out.flush();
					out.close();
				}
				catch (SystemException e) {
					e.printStackTrace();
					throw new PortletException("Export Excel Error", e);
				}
			}

		}
	}

	@ProcessAction(name = "setLogLevelPref")
	public void setLogLevelPref(ActionRequest request, ActionResponse response)
		throws Exception {

		String rowsPerPage = ParamUtil.getString(request, "rows-per-page");
		String viewType = ParamUtil.getString(request, "view-type");
		String dateFormat = ParamUtil.getString(request, "date-format");
		String datetimeFormat = ParamUtil.getString(request, "datetime-format");

		ArrayList<String> errors = new ArrayList();
		if (LogLevelValidator.validateEditLogLevel(rowsPerPage, dateFormat, datetimeFormat, errors)) {
			response.setRenderParameter("rows-per-page", "");
			response.setRenderParameter("date-format", "");
			response.setRenderParameter("datetime-format", "");
			response.setRenderParameter("view-type", "");

			PortletPreferences prefs = request.getPreferences();

			prefs.setValue("rows-per-page", rowsPerPage);
			prefs.setValue("view-type", viewType);
			prefs.setValue("date-format", dateFormat);
			prefs.setValue("datetime-format", datetimeFormat);
			prefs.store();

			SessionMessages.add(request, "prefs-success");
		}
	}

	public void showEditDefault(RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException, IOException {

		include(editJSP, renderRequest, renderResponse);
	}

	@SuppressWarnings("unchecked")
	public void showViewDefault(RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long groupId = themeDisplay.getScopeGroupId();

		PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();

		boolean hasAddPermission = LogLevelPermission.contains(permissionChecker, groupId, "ADD_LOGLEVEL");

		boolean hasModelPermissions = LogLevelPermission.contains(permissionChecker, groupId, ActionKeys.PERMISSIONS);

		List<LogLevel> tempResults = Collections.EMPTY_LIST;

		PortletPreferences prefs = renderRequest.getPreferences();

		String LogLevelFilter = ParamUtil.getString(renderRequest, "LogLevelFilter");

		String rowsPerPage = prefs.getValue("rows-per-page", "5");
		String viewType = prefs.getValue("view-type", "0");

		Integer cur = 1;
		int containerStart = 0;
		int containerEnd = 0;
		String orderByType = renderRequest.getParameter("orderByType");
		String orderByCol = renderRequest.getParameter("orderByCol");
		try {
			cur = ParamUtil.getInteger(renderRequest, "cur");

		}
		catch (Exception e) {
			cur = 1;
		}

		if (cur < 1) {
			cur = 1;
		}

		if (Validator.isNotNull(LogLevelFilter) || !LogLevelFilter.equalsIgnoreCase("")) {
			rowsPerPage = "100";
			cur = 1;
		}

		containerStart = (cur - 1) * Integer.parseInt(rowsPerPage);
		containerEnd = containerStart + Integer.parseInt(rowsPerPage);

		int total = 0;
		try {
			PortalPreferences portalPrefs = PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

			if (Validator.isNull(orderByCol) && Validator.isNull(orderByType)) {
				orderByCol = portalPrefs.getValue("LogLevel_order", "LogLevel-order-by-col", "LogLevelId");
				orderByType = portalPrefs.getValue("LogLevel_order", "LogLevel-order-by-type", "asc");
			}
			OrderByComparator comparator = LogLevelComparator.getLogLevelOrderByComparator(orderByCol, orderByType);

			if (viewType.equals("0")) {
				tempResults =
					LogLevelLocalServiceUtil.findAllInGroup(groupId, containerStart, containerEnd, comparator);
				total = LogLevelLocalServiceUtil.countAllInGroup(groupId);
			}
			else if (viewType.equals("1")) {
				tempResults =
					LogLevelLocalServiceUtil.findAllInUser(
						themeDisplay.getUserId(), containerStart, containerEnd, comparator);
				total = LogLevelLocalServiceUtil.countAllInUser(themeDisplay.getUserId());
			}
			else {
				tempResults =
					LogLevelLocalServiceUtil.findAllInUserAndGroup(
						themeDisplay.getUserId(), groupId, containerStart, containerEnd, comparator);
				total = LogLevelLocalServiceUtil.countAllInUserAndGroup(themeDisplay.getUserId(), groupId);
			}

		}
		catch (Exception e) {
			_log.debug(e);
		}
		renderRequest.setAttribute("highlightRowWithKey", renderRequest.getParameter("highlightRowWithKey"));
		renderRequest.setAttribute("containerStart", containerStart);
		renderRequest.setAttribute("containerEnd", containerEnd);
		renderRequest.setAttribute("cur", cur);
		renderRequest.setAttribute("tempResults", tempResults);
		renderRequest.setAttribute("totalCount", total);
		renderRequest.setAttribute("rowsPerPage", rowsPerPage);
		renderRequest.setAttribute("hasAddPermission", hasAddPermission);
		renderRequest.setAttribute("hasModelPermissions", hasModelPermissions);
		renderRequest.setAttribute("orderByType", orderByType);
		renderRequest.setAttribute("orderByCol", orderByCol);
		renderRequest.setAttribute("LogLevelFilter", LogLevelFilter);

		PortletURL addLogLevelURL = renderResponse.createActionURL();
		addLogLevelURL.setParameter("javax.portlet.action", "newLogLevel");
		renderRequest.setAttribute("addLogLevelURL", addLogLevelURL.toString());

		PortletURL LogLevelFilterURL = renderResponse.createRenderURL();
		LogLevelFilterURL.setParameter("javax.portlet.action", "doView");
		renderRequest.setAttribute("LogLevelFilterURL", LogLevelFilterURL.toString());

		include(viewJSP, renderRequest, renderResponse);
	}

	public void showViewEditLogLevel(RenderRequest renderRequest, RenderResponse renderResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();

		PortletURL editLogLevelURL = renderResponse.createActionURL();
		String editType = (String) renderRequest.getParameter("editType");

		LogLevel logLevel = null;
		boolean viewEntryMode = false;
		if (editType.equalsIgnoreCase("edit")) {

			editLogLevelURL.setParameter("javax.portlet.action", "updateLogLevel");

			long $fname = Long.parseLong(renderRequest.getParameter("LogLevelId"));
			logLevel = LogLevelLocalServiceUtil.getLogLevel($fname);

			if (!LogLevelEntryPermission.contains(permissionChecker, logLevel, ActionKeys.UPDATE)) {
				SessionErrors.add(renderRequest, "permission-error");
				return;
			}

			renderRequest.setAttribute("logLevel", logLevel);
		}
		else if (editType.equalsIgnoreCase("view")) {

			viewEntryMode = true;

			long $fname = Long.parseLong(renderRequest.getParameter("LogLevelId"));
			logLevel = LogLevelLocalServiceUtil.getLogLevel($fname);

			if (!LogLevelEntryPermission.contains(permissionChecker, logLevel, ActionKeys.VIEW)) {
				SessionErrors.add(renderRequest, "permission-error");
				return;
			}

			renderRequest.setAttribute("logLevel", logLevel);
		}
		else {

			if (!LogLevelPermission.contains(permissionChecker, themeDisplay.getScopeGroupId(), "ADD_LOGLEVEL")) {
				SessionErrors.add(renderRequest, "permission-error");
				return;
			}

			editLogLevelURL.setParameter("javax.portlet.action", "addLogLevel");
			LogLevel errorLogLevel = (LogLevel) renderRequest.getAttribute("errorLogLevel");
			if (errorLogLevel != null) {
				if (editType.equalsIgnoreCase("update")) {
					editLogLevelURL.setParameter("javax.portlet.action", "updateLogLevel");
				}
				renderRequest.setAttribute("logLevel", errorLogLevel);

			}
			else {

				LogLevel addLogLevel = null;

				if (Validator.isNull(renderRequest.getParameter("addErrors"))) {

					addLogLevel = new LogLevelImpl();
					addLogLevel.setLogLevelId(0);
					addLogLevel.setLogLevelDescription("");
					addLogLevel.setLogLevelPriority("");
				}
				else {
					addLogLevel = getLogLevelFromRequest(renderRequest);
				}
				renderRequest.setAttribute("logLevel", addLogLevel);
			}

		}

		renderRequest.setAttribute("editType", editType);

		if (!viewEntryMode) {
			renderRequest.setAttribute("editLogLevelURL", editLogLevelURL.toString());
			include(editLogLevelJSP, renderRequest, renderResponse);
		}
		else {
			include(viewLogLevelJSP, renderRequest, renderResponse);
		}
	}

	@ProcessAction(name = "updateLogLevel")
	public void updateLogLevel(ActionRequest request, ActionResponse response)
		throws Exception {

		LogLevel logLevel = getLogLevelFromRequest(request);
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();

		if (!LogLevelEntryPermission.contains(permissionChecker, logLevel, ActionKeys.UPDATE)) {
			LogLevelUtil.addParametersForDefaultView(response);
			SessionErrors.add(request, "permission-error");
			return;
		}

		ArrayList<String> errors = LogLevelValidator.validateLogLevel(logLevel, request);

		if (errors.isEmpty()) {
			try {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(LogLevel.class.getName(), request);
				LogLevelLocalServiceUtil.updateLogLevel(logLevel, serviceContext);

				LogLevelUtil.addParametersForDefaultView(response);
				SessionMessages.add(request, "loglevel-updated-successfully");

			}
			catch (Exception cvex) {
				SessionErrors.add(request, "please-enter-a-unique-code");
				LogLevelUtil.addParametersForEdit(response, null);
				request.setAttribute("logLevel", logLevel);
			}
		}
		else {
			for (String error : errors) {
				SessionErrors.add(request, error);
			}
			LogLevelUtil.addParametersForEdit(response, Long.toString(logLevel.getPrimaryKey()));
			request.setAttribute("logLevel", logLevel);
		}
	}

}
