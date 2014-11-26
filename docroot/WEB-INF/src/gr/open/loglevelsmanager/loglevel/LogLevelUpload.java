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
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Repository;
import com.liferay.portal.portletfilerepository.PortletFileRepositoryUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.documentlibrary.model.DLFolderConstants;

import gr.open.loglevelsmanager.loglevel.model.LogLevel;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.portlet.ActionRequest;

import org.apache.commons.fileupload.FileItem;

/**
 * Upload implementation class LogLevel
 */
public class LogLevelUpload {

	public static String HIDDEN = "HIDDEN";
	public static String SEPARATOR = "_";

	public static String DOCUMENT_DELETE = "DELETEDOCUMENT";
	public static String DOCUMENTFILE = "DOCUMENTFILE";
	public static String DOCUMENTLIBRARY_REQUESTFOLDER = HIDDEN + SEPARATOR + "folderDLId";
	public static String DOCUMENTLIBRARY_PORTLETFOLDER = "LogLevel";

	private long dlFolderId = 0L;

	private List<FileItem> files = null;
	private HashMap hiddens = null;
	private HashMap deleteds = null;

	public LogLevelUpload() {

		init();
	}

	public void add(FileItem item) {

		if (files == null)
			files = new ArrayList<FileItem>();
		files.add(item);
	}

	public void addDeleted(String formField) {

		if (deleteds == null)
			deleteds = new HashMap();
		deleteds.put(formField, new Boolean("true"));
	}

	public void addHidden(String formField, Long value) {

		if (hiddens == null)
			hiddens = new HashMap();
		// Check if Hidden folders
		if (formField.equalsIgnoreCase(DOCUMENTLIBRARY_REQUESTFOLDER)) {
			if ((value != null) && (value != 0L))
				dlFolderId = value;
		}
		else {
			hiddens.put(formField, value);
		}
	}

	private void callSetMethod(String formField, LogLevel logLevel, Long value)
		throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException,
		InvocationTargetException {

		String strMethod = "set" + StringUtil.upperCaseFirstLetter(formField);
		Method methodSet = logLevel.getClass().getMethod(strMethod, long.class);
		methodSet.invoke(logLevel, value);
	}

	/**
	 * Create folders for upload documents from our portlet to DocumentLibrary portlet
	 * 
	 * @param request
	 * @param userId
	 * @param groupId
	 * @param portletName
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	private long createFolders(ActionRequest request, Long userId, Long groupId, String portletName)
		throws PortalException, SystemException {

		// Search for folder in Document Library
		if (dlFolderId != DLFolderConstants.DEFAULT_PARENT_FOLDER_ID) {

			return dlFolderId;
		}

		ServiceContext serviceContext = new ServiceContext();

		serviceContext.setAddGroupPermissions(true);
		serviceContext.setAddGuestPermissions(true);

		Repository repository = PortletFileRepositoryUtil.addPortletRepository(groupId, portletName, serviceContext);

		Folder folder =
			PortletFileRepositoryUtil.addPortletFolder(
				userId, repository.getRepositoryId(), DLFolderConstants.DEFAULT_PARENT_FOLDER_ID,
				DOCUMENTLIBRARY_PORTLETFOLDER, serviceContext);

		dlFolderId = folder.getFolderId();

		return dlFolderId;
	}

	/**
	 * Extract a given prefix and sufix from a String This method looks for prefix and sufix, and erases them from
	 * itemName
	 * 
	 * @param prefix
	 * @param sufix
	 * @param itemName
	 * @return
	 */
	private String extractPrefixAndSufix(String prefix, String sufix, String itemName) {

		String result = itemName;
		if (itemName != null && sufix != null && prefix != null) {
			result = result.replaceAll(prefix, "");
			result = result.replaceAll(sufix, "");
		}
		return result;
	}

	private void init() {

		files = new ArrayList<FileItem>();
		hiddens = new HashMap();
		deleteds = new HashMap();
		dlFolderId = 0L;
	}

	public LogLevel uploadFiles(ActionRequest request, LogLevel logLevel)
		throws PortalException, SystemException, IOException, SecurityException, IllegalArgumentException,
		NoSuchMethodException, IllegalAccessException, InvocationTargetException {

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		long groupId = UserLocalServiceUtil.getUser(userId).getGroupId();

		for (FileItem item : files) {
			String formField = item.getFieldName();
			String strType = formField.substring(formField.lastIndexOf(SEPARATOR) + 1);
			if (strType.equalsIgnoreCase(DOCUMENTFILE)) {
				String portletName = "_" + request.getAttribute(WebKeys.PORTLET_ID) + "_";
				formField = extractPrefixAndSufix(portletName, SEPARATOR + DOCUMENTFILE, formField);
				if (deleteds.get(formField) != null) {
					Long prevDocument = (Long) hiddens.get(HIDDEN + SEPARATOR + formField);
					if ((prevDocument != null) && (prevDocument != 0L)) {
						PortletFileRepositoryUtil.deletePortletFileEntry(prevDocument);
					}
				}
				else if (!item.getName().equals("")) {

					long folderId = createFolders(request, userId, groupId, portletName);

					String sourceFileName = item.getName();
					InputStream inputStream = item.getInputStream();

					FileEntry fileEntry =
						PortletFileRepositoryUtil.addPortletFileEntry(
							groupId, userId, LogLevel.class.getName(), logLevel.getPrimaryKey(), portletName, folderId,
							inputStream, sourceFileName, StringPool.BLANK, true);

					callSetMethod(formField, logLevel, fileEntry.getFileEntryId());

					// Check possible previous values
					if (hiddens != null) {
						Long prevDocument = (Long) hiddens.get(HIDDEN + SEPARATOR + formField);
						if ((prevDocument != null) && (prevDocument != 0L)) {
							// Delete previous document
							PortletFileRepositoryUtil.deletePortletFileEntry(prevDocument);
						}
					}
				}
				else {
					// See hidden value, possible edit
					if (hiddens != null) {
						Long prevDocument = (Long) hiddens.get(HIDDEN + SEPARATOR + formField);
						if ((prevDocument != null) && (prevDocument != 0L)) {
							callSetMethod(formField, logLevel, (Long) hiddens.get(HIDDEN + SEPARATOR + formField));
						}
					}
				}
			}
		}
		return logLevel;
	}
}
