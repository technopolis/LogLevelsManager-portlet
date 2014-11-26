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

package gr.open.loglevelsmanager.loglevel.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import gr.open.loglevelsmanager.loglevel.service.ClpSerializer;
import gr.open.loglevelsmanager.loglevel.service.LogLevelLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jack A. Rider
 */
public class LogLevelClp extends BaseModelImpl<LogLevel> implements LogLevel {
	public LogLevelClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return LogLevel.class;
	}

	@Override
	public String getModelClassName() {
		return LogLevel.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _LogLevelId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setLogLevelId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _LogLevelId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("LogLevelId", getLogLevelId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("logLevelDescription", getLogLevelDescription());
		attributes.put("logLevelPriority", getLogLevelPriority());
		attributes.put("logLevelCategory", getLogLevelCategory());
		attributes.put("logLevelScheduled", getLogLevelScheduled());
		attributes.put("logLevelStartDate", getLogLevelStartDate());
		attributes.put("logLevelEndDate", getLogLevelEndDate());
		attributes.put("activateOnStartup", getActivateOnStartup());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long LogLevelId = (Long)attributes.get("LogLevelId");

		if (LogLevelId != null) {
			setLogLevelId(LogLevelId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String logLevelDescription = (String)attributes.get(
				"logLevelDescription");

		if (logLevelDescription != null) {
			setLogLevelDescription(logLevelDescription);
		}

		String logLevelPriority = (String)attributes.get("logLevelPriority");

		if (logLevelPriority != null) {
			setLogLevelPriority(logLevelPriority);
		}

		String logLevelCategory = (String)attributes.get("logLevelCategory");

		if (logLevelCategory != null) {
			setLogLevelCategory(logLevelCategory);
		}

		Boolean logLevelScheduled = (Boolean)attributes.get("logLevelScheduled");

		if (logLevelScheduled != null) {
			setLogLevelScheduled(logLevelScheduled);
		}

		Date logLevelStartDate = (Date)attributes.get("logLevelStartDate");

		if (logLevelStartDate != null) {
			setLogLevelStartDate(logLevelStartDate);
		}

		Date logLevelEndDate = (Date)attributes.get("logLevelEndDate");

		if (logLevelEndDate != null) {
			setLogLevelEndDate(logLevelEndDate);
		}

		Boolean activateOnStartup = (Boolean)attributes.get("activateOnStartup");

		if (activateOnStartup != null) {
			setActivateOnStartup(activateOnStartup);
		}
	}

	@Override
	public long getLogLevelId() {
		return _LogLevelId;
	}

	@Override
	public void setLogLevelId(long LogLevelId) {
		_LogLevelId = LogLevelId;

		if (_logLevelRemoteModel != null) {
			try {
				Class<?> clazz = _logLevelRemoteModel.getClass();

				Method method = clazz.getMethod("setLogLevelId", long.class);

				method.invoke(_logLevelRemoteModel, LogLevelId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_logLevelRemoteModel != null) {
			try {
				Class<?> clazz = _logLevelRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_logLevelRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_logLevelRemoteModel != null) {
			try {
				Class<?> clazz = _logLevelRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_logLevelRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_logLevelRemoteModel != null) {
			try {
				Class<?> clazz = _logLevelRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_logLevelRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_logLevelRemoteModel != null) {
			try {
				Class<?> clazz = _logLevelRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_logLevelRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_logLevelRemoteModel != null) {
			try {
				Class<?> clazz = _logLevelRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_logLevelRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_logLevelRemoteModel != null) {
			try {
				Class<?> clazz = _logLevelRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_logLevelRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLogLevelDescription() {
		return _logLevelDescription;
	}

	@Override
	public void setLogLevelDescription(String logLevelDescription) {
		_logLevelDescription = logLevelDescription;

		if (_logLevelRemoteModel != null) {
			try {
				Class<?> clazz = _logLevelRemoteModel.getClass();

				Method method = clazz.getMethod("setLogLevelDescription",
						String.class);

				method.invoke(_logLevelRemoteModel, logLevelDescription);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLogLevelPriority() {
		return _logLevelPriority;
	}

	@Override
	public void setLogLevelPriority(String logLevelPriority) {
		_logLevelPriority = logLevelPriority;

		if (_logLevelRemoteModel != null) {
			try {
				Class<?> clazz = _logLevelRemoteModel.getClass();

				Method method = clazz.getMethod("setLogLevelPriority",
						String.class);

				method.invoke(_logLevelRemoteModel, logLevelPriority);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLogLevelCategory() {
		return _logLevelCategory;
	}

	@Override
	public void setLogLevelCategory(String logLevelCategory) {
		_logLevelCategory = logLevelCategory;

		if (_logLevelRemoteModel != null) {
			try {
				Class<?> clazz = _logLevelRemoteModel.getClass();

				Method method = clazz.getMethod("setLogLevelCategory",
						String.class);

				method.invoke(_logLevelRemoteModel, logLevelCategory);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getLogLevelScheduled() {
		return _logLevelScheduled;
	}

	@Override
	public boolean isLogLevelScheduled() {
		return _logLevelScheduled;
	}

	@Override
	public void setLogLevelScheduled(boolean logLevelScheduled) {
		_logLevelScheduled = logLevelScheduled;

		if (_logLevelRemoteModel != null) {
			try {
				Class<?> clazz = _logLevelRemoteModel.getClass();

				Method method = clazz.getMethod("setLogLevelScheduled",
						boolean.class);

				method.invoke(_logLevelRemoteModel, logLevelScheduled);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getLogLevelStartDate() {
		return _logLevelStartDate;
	}

	@Override
	public void setLogLevelStartDate(Date logLevelStartDate) {
		_logLevelStartDate = logLevelStartDate;

		if (_logLevelRemoteModel != null) {
			try {
				Class<?> clazz = _logLevelRemoteModel.getClass();

				Method method = clazz.getMethod("setLogLevelStartDate",
						Date.class);

				method.invoke(_logLevelRemoteModel, logLevelStartDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getLogLevelEndDate() {
		return _logLevelEndDate;
	}

	@Override
	public void setLogLevelEndDate(Date logLevelEndDate) {
		_logLevelEndDate = logLevelEndDate;

		if (_logLevelRemoteModel != null) {
			try {
				Class<?> clazz = _logLevelRemoteModel.getClass();

				Method method = clazz.getMethod("setLogLevelEndDate", Date.class);

				method.invoke(_logLevelRemoteModel, logLevelEndDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getActivateOnStartup() {
		return _activateOnStartup;
	}

	@Override
	public boolean isActivateOnStartup() {
		return _activateOnStartup;
	}

	@Override
	public void setActivateOnStartup(boolean activateOnStartup) {
		_activateOnStartup = activateOnStartup;

		if (_logLevelRemoteModel != null) {
			try {
				Class<?> clazz = _logLevelRemoteModel.getClass();

				Method method = clazz.getMethod("setActivateOnStartup",
						boolean.class);

				method.invoke(_logLevelRemoteModel, activateOnStartup);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLogLevelRemoteModel() {
		return _logLevelRemoteModel;
	}

	public void setLogLevelRemoteModel(BaseModel<?> logLevelRemoteModel) {
		_logLevelRemoteModel = logLevelRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _logLevelRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_logLevelRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LogLevelLocalServiceUtil.addLogLevel(this);
		}
		else {
			LogLevelLocalServiceUtil.updateLogLevel(this);
		}
	}

	@Override
	public LogLevel toEscapedModel() {
		return (LogLevel)ProxyUtil.newProxyInstance(LogLevel.class.getClassLoader(),
			new Class[] { LogLevel.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LogLevelClp clone = new LogLevelClp();

		clone.setLogLevelId(getLogLevelId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setLogLevelDescription(getLogLevelDescription());
		clone.setLogLevelPriority(getLogLevelPriority());
		clone.setLogLevelCategory(getLogLevelCategory());
		clone.setLogLevelScheduled(getLogLevelScheduled());
		clone.setLogLevelStartDate(getLogLevelStartDate());
		clone.setLogLevelEndDate(getLogLevelEndDate());
		clone.setActivateOnStartup(getActivateOnStartup());

		return clone;
	}

	@Override
	public int compareTo(LogLevel logLevel) {
		long primaryKey = logLevel.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LogLevelClp)) {
			return false;
		}

		LogLevelClp logLevel = (LogLevelClp)obj;

		long primaryKey = logLevel.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{LogLevelId=");
		sb.append(getLogLevelId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", logLevelDescription=");
		sb.append(getLogLevelDescription());
		sb.append(", logLevelPriority=");
		sb.append(getLogLevelPriority());
		sb.append(", logLevelCategory=");
		sb.append(getLogLevelCategory());
		sb.append(", logLevelScheduled=");
		sb.append(getLogLevelScheduled());
		sb.append(", logLevelStartDate=");
		sb.append(getLogLevelStartDate());
		sb.append(", logLevelEndDate=");
		sb.append(getLogLevelEndDate());
		sb.append(", activateOnStartup=");
		sb.append(getActivateOnStartup());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("gr.open.loglevelsmanager.loglevel.model.LogLevel");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>LogLevelId</column-name><column-value><![CDATA[");
		sb.append(getLogLevelId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>logLevelDescription</column-name><column-value><![CDATA[");
		sb.append(getLogLevelDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>logLevelPriority</column-name><column-value><![CDATA[");
		sb.append(getLogLevelPriority());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>logLevelCategory</column-name><column-value><![CDATA[");
		sb.append(getLogLevelCategory());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>logLevelScheduled</column-name><column-value><![CDATA[");
		sb.append(getLogLevelScheduled());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>logLevelStartDate</column-name><column-value><![CDATA[");
		sb.append(getLogLevelStartDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>logLevelEndDate</column-name><column-value><![CDATA[");
		sb.append(getLogLevelEndDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>activateOnStartup</column-name><column-value><![CDATA[");
		sb.append(getActivateOnStartup());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _LogLevelId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _logLevelDescription;
	private String _logLevelPriority;
	private String _logLevelCategory;
	private boolean _logLevelScheduled;
	private Date _logLevelStartDate;
	private Date _logLevelEndDate;
	private boolean _activateOnStartup;
	private BaseModel<?> _logLevelRemoteModel;
}