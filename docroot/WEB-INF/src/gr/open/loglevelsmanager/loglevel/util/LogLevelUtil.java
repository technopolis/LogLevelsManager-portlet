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

package gr.open.loglevelsmanager.loglevel.util;

import com.liferay.portal.NoSuchLayoutException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.LayoutConstants;
import com.liferay.portal.model.LayoutTypePortlet;
import com.liferay.portal.model.PortletConstants;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

import javax.portlet.ActionResponse;

/**
 * @author Jack A. Rider
 * @author Juan Gonzalez P.
 */
public class LogLevelUtil {

	public static void addParametersForAdd(ActionResponse response) {

		response.setRenderParameter("view", "editLogLevel");
		response.setRenderParameter("editType", "add");

	}

	public static void addParametersForAddWithErrors(ActionResponse response) {

		addParametersForAdd(response);

		response.setRenderParameter("addErrors", "true");

	}

	public static void addParametersForDefaultView(ActionResponse response) {

		response.setRenderParameter("view", "");

	}

	public static void addParametersForEdit(ActionResponse response, long entryId) {

		addParametersForEdit(response, Long.toString(entryId));
	}

	public static void addParametersForEdit(ActionResponse response, String entryId) {

		response.setRenderParameter("view", "editLogLevel");
		response.setRenderParameter("editType", "edit");
		if (Validator.isNotNull(entryId)) {
			response.setRenderParameter("LogLevelId", entryId);
		}
	}

	public static void addParametersForViewEntry(ActionResponse response, long entryId) {

		addParametersForViewEntry(response, Long.toString(entryId));
	}

	public static void addParametersForViewEntry(ActionResponse response, String entryId) {

		response.setRenderParameter("view", "editLogLevel");
		response.setRenderParameter("editType", "view");
		if (Validator.isNotNull(entryId)) {
			response.setRenderParameter("LogLevelId", entryId);
		}
	}

	public static long getPlid(long groupId)
		throws Exception {

		String portletId = "LogLevel_WAR_LogLevelportlet";

		long plid = PortalUtil.getPlidFromPortletId(groupId, portletId);

		if (plid != LayoutConstants.DEFAULT_PLID) {
			Layout layout = LayoutLocalServiceUtil.getLayout(plid);

			LayoutTypePortlet layoutTypePortlet = (LayoutTypePortlet) layout.getLayoutType();

			for (String curPortletId : layoutTypePortlet.getPortletIds()) {
				String curRootPortletId = PortletConstants.getRootPortletId(curPortletId);

				if (portletId.equals(curRootPortletId)) {
					portletId = curPortletId;

					break;
				}
			}

			return plid;
		}

		throw new NoSuchLayoutException();
	}

}
