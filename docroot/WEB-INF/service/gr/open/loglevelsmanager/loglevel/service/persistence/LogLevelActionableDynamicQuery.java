/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package gr.open.loglevelsmanager.loglevel.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import gr.open.loglevelsmanager.loglevel.model.LogLevel;
import gr.open.loglevelsmanager.loglevel.service.LogLevelLocalServiceUtil;

/**
 * @author Jack A. Rider
 * @generated
 */
public abstract class LogLevelActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public LogLevelActionableDynamicQuery() throws SystemException {
		setBaseLocalService(LogLevelLocalServiceUtil.getService());
		setClass(LogLevel.class);

		setClassLoader(gr.open.loglevelsmanager.loglevel.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("LogLevelId");
	}
}