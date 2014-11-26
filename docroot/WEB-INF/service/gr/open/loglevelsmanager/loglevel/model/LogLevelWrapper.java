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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LogLevel}.
 * </p>
 *
 * @author Jack A. Rider
 * @see LogLevel
 * @generated
 */
public class LogLevelWrapper implements LogLevel, ModelWrapper<LogLevel> {
	public LogLevelWrapper(LogLevel logLevel) {
		_logLevel = logLevel;
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

	/**
	* Returns the primary key of this log level.
	*
	* @return the primary key of this log level
	*/
	@Override
	public long getPrimaryKey() {
		return _logLevel.getPrimaryKey();
	}

	/**
	* Sets the primary key of this log level.
	*
	* @param primaryKey the primary key of this log level
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_logLevel.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the log level ID of this log level.
	*
	* @return the log level ID of this log level
	*/
	@Override
	public long getLogLevelId() {
		return _logLevel.getLogLevelId();
	}

	/**
	* Sets the log level ID of this log level.
	*
	* @param LogLevelId the log level ID of this log level
	*/
	@Override
	public void setLogLevelId(long LogLevelId) {
		_logLevel.setLogLevelId(LogLevelId);
	}

	/**
	* Returns the company ID of this log level.
	*
	* @return the company ID of this log level
	*/
	@Override
	public long getCompanyId() {
		return _logLevel.getCompanyId();
	}

	/**
	* Sets the company ID of this log level.
	*
	* @param companyId the company ID of this log level
	*/
	@Override
	public void setCompanyId(long companyId) {
		_logLevel.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this log level.
	*
	* @return the group ID of this log level
	*/
	@Override
	public long getGroupId() {
		return _logLevel.getGroupId();
	}

	/**
	* Sets the group ID of this log level.
	*
	* @param groupId the group ID of this log level
	*/
	@Override
	public void setGroupId(long groupId) {
		_logLevel.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this log level.
	*
	* @return the user ID of this log level
	*/
	@Override
	public long getUserId() {
		return _logLevel.getUserId();
	}

	/**
	* Sets the user ID of this log level.
	*
	* @param userId the user ID of this log level
	*/
	@Override
	public void setUserId(long userId) {
		_logLevel.setUserId(userId);
	}

	/**
	* Returns the user uuid of this log level.
	*
	* @return the user uuid of this log level
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _logLevel.getUserUuid();
	}

	/**
	* Sets the user uuid of this log level.
	*
	* @param userUuid the user uuid of this log level
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_logLevel.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this log level.
	*
	* @return the user name of this log level
	*/
	@Override
	public java.lang.String getUserName() {
		return _logLevel.getUserName();
	}

	/**
	* Sets the user name of this log level.
	*
	* @param userName the user name of this log level
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_logLevel.setUserName(userName);
	}

	/**
	* Returns the create date of this log level.
	*
	* @return the create date of this log level
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _logLevel.getCreateDate();
	}

	/**
	* Sets the create date of this log level.
	*
	* @param createDate the create date of this log level
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_logLevel.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this log level.
	*
	* @return the modified date of this log level
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _logLevel.getModifiedDate();
	}

	/**
	* Sets the modified date of this log level.
	*
	* @param modifiedDate the modified date of this log level
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_logLevel.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the log level description of this log level.
	*
	* @return the log level description of this log level
	*/
	@Override
	public java.lang.String getLogLevelDescription() {
		return _logLevel.getLogLevelDescription();
	}

	/**
	* Sets the log level description of this log level.
	*
	* @param logLevelDescription the log level description of this log level
	*/
	@Override
	public void setLogLevelDescription(java.lang.String logLevelDescription) {
		_logLevel.setLogLevelDescription(logLevelDescription);
	}

	/**
	* Returns the log level priority of this log level.
	*
	* @return the log level priority of this log level
	*/
	@Override
	public java.lang.String getLogLevelPriority() {
		return _logLevel.getLogLevelPriority();
	}

	/**
	* Sets the log level priority of this log level.
	*
	* @param logLevelPriority the log level priority of this log level
	*/
	@Override
	public void setLogLevelPriority(java.lang.String logLevelPriority) {
		_logLevel.setLogLevelPriority(logLevelPriority);
	}

	/**
	* Returns the log level category of this log level.
	*
	* @return the log level category of this log level
	*/
	@Override
	public java.lang.String getLogLevelCategory() {
		return _logLevel.getLogLevelCategory();
	}

	/**
	* Sets the log level category of this log level.
	*
	* @param logLevelCategory the log level category of this log level
	*/
	@Override
	public void setLogLevelCategory(java.lang.String logLevelCategory) {
		_logLevel.setLogLevelCategory(logLevelCategory);
	}

	/**
	* Returns the log level scheduled of this log level.
	*
	* @return the log level scheduled of this log level
	*/
	@Override
	public boolean getLogLevelScheduled() {
		return _logLevel.getLogLevelScheduled();
	}

	/**
	* Returns <code>true</code> if this log level is log level scheduled.
	*
	* @return <code>true</code> if this log level is log level scheduled; <code>false</code> otherwise
	*/
	@Override
	public boolean isLogLevelScheduled() {
		return _logLevel.isLogLevelScheduled();
	}

	/**
	* Sets whether this log level is log level scheduled.
	*
	* @param logLevelScheduled the log level scheduled of this log level
	*/
	@Override
	public void setLogLevelScheduled(boolean logLevelScheduled) {
		_logLevel.setLogLevelScheduled(logLevelScheduled);
	}

	/**
	* Returns the log level start date of this log level.
	*
	* @return the log level start date of this log level
	*/
	@Override
	public java.util.Date getLogLevelStartDate() {
		return _logLevel.getLogLevelStartDate();
	}

	/**
	* Sets the log level start date of this log level.
	*
	* @param logLevelStartDate the log level start date of this log level
	*/
	@Override
	public void setLogLevelStartDate(java.util.Date logLevelStartDate) {
		_logLevel.setLogLevelStartDate(logLevelStartDate);
	}

	/**
	* Returns the log level end date of this log level.
	*
	* @return the log level end date of this log level
	*/
	@Override
	public java.util.Date getLogLevelEndDate() {
		return _logLevel.getLogLevelEndDate();
	}

	/**
	* Sets the log level end date of this log level.
	*
	* @param logLevelEndDate the log level end date of this log level
	*/
	@Override
	public void setLogLevelEndDate(java.util.Date logLevelEndDate) {
		_logLevel.setLogLevelEndDate(logLevelEndDate);
	}

	/**
	* Returns the activate on startup of this log level.
	*
	* @return the activate on startup of this log level
	*/
	@Override
	public boolean getActivateOnStartup() {
		return _logLevel.getActivateOnStartup();
	}

	/**
	* Returns <code>true</code> if this log level is activate on startup.
	*
	* @return <code>true</code> if this log level is activate on startup; <code>false</code> otherwise
	*/
	@Override
	public boolean isActivateOnStartup() {
		return _logLevel.isActivateOnStartup();
	}

	/**
	* Sets whether this log level is activate on startup.
	*
	* @param activateOnStartup the activate on startup of this log level
	*/
	@Override
	public void setActivateOnStartup(boolean activateOnStartup) {
		_logLevel.setActivateOnStartup(activateOnStartup);
	}

	@Override
	public boolean isNew() {
		return _logLevel.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_logLevel.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _logLevel.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_logLevel.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _logLevel.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _logLevel.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_logLevel.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _logLevel.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_logLevel.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_logLevel.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_logLevel.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LogLevelWrapper((LogLevel)_logLevel.clone());
	}

	@Override
	public int compareTo(
		gr.open.loglevelsmanager.loglevel.model.LogLevel logLevel) {
		return _logLevel.compareTo(logLevel);
	}

	@Override
	public int hashCode() {
		return _logLevel.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<gr.open.loglevelsmanager.loglevel.model.LogLevel> toCacheModel() {
		return _logLevel.toCacheModel();
	}

	@Override
	public gr.open.loglevelsmanager.loglevel.model.LogLevel toEscapedModel() {
		return new LogLevelWrapper(_logLevel.toEscapedModel());
	}

	@Override
	public gr.open.loglevelsmanager.loglevel.model.LogLevel toUnescapedModel() {
		return new LogLevelWrapper(_logLevel.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _logLevel.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _logLevel.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_logLevel.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LogLevelWrapper)) {
			return false;
		}

		LogLevelWrapper logLevelWrapper = (LogLevelWrapper)obj;

		if (Validator.equals(_logLevel, logLevelWrapper._logLevel)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public LogLevel getWrappedLogLevel() {
		return _logLevel;
	}

	@Override
	public LogLevel getWrappedModel() {
		return _logLevel;
	}

	@Override
	public void resetOriginalValues() {
		_logLevel.resetOriginalValues();
	}

	private LogLevel _logLevel;
}