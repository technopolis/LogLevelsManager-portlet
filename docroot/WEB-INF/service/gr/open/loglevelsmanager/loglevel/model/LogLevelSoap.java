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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Jack A. Rider
 * @generated
 */
public class LogLevelSoap implements Serializable {
	public static LogLevelSoap toSoapModel(LogLevel model) {
		LogLevelSoap soapModel = new LogLevelSoap();

		soapModel.setLogLevelId(model.getLogLevelId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setLogLevelDescription(model.getLogLevelDescription());
		soapModel.setLogLevelPriority(model.getLogLevelPriority());
		soapModel.setLogLevelCategory(model.getLogLevelCategory());
		soapModel.setLogLevelScheduled(model.getLogLevelScheduled());
		soapModel.setLogLevelStartDate(model.getLogLevelStartDate());
		soapModel.setLogLevelEndDate(model.getLogLevelEndDate());
		soapModel.setActivateOnStartup(model.getActivateOnStartup());

		return soapModel;
	}

	public static LogLevelSoap[] toSoapModels(LogLevel[] models) {
		LogLevelSoap[] soapModels = new LogLevelSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LogLevelSoap[][] toSoapModels(LogLevel[][] models) {
		LogLevelSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LogLevelSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LogLevelSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LogLevelSoap[] toSoapModels(List<LogLevel> models) {
		List<LogLevelSoap> soapModels = new ArrayList<LogLevelSoap>(models.size());

		for (LogLevel model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LogLevelSoap[soapModels.size()]);
	}

	public LogLevelSoap() {
	}

	public long getPrimaryKey() {
		return _LogLevelId;
	}

	public void setPrimaryKey(long pk) {
		setLogLevelId(pk);
	}

	public long getLogLevelId() {
		return _LogLevelId;
	}

	public void setLogLevelId(long LogLevelId) {
		_LogLevelId = LogLevelId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getLogLevelDescription() {
		return _logLevelDescription;
	}

	public void setLogLevelDescription(String logLevelDescription) {
		_logLevelDescription = logLevelDescription;
	}

	public String getLogLevelPriority() {
		return _logLevelPriority;
	}

	public void setLogLevelPriority(String logLevelPriority) {
		_logLevelPriority = logLevelPriority;
	}

	public String getLogLevelCategory() {
		return _logLevelCategory;
	}

	public void setLogLevelCategory(String logLevelCategory) {
		_logLevelCategory = logLevelCategory;
	}

	public boolean getLogLevelScheduled() {
		return _logLevelScheduled;
	}

	public boolean isLogLevelScheduled() {
		return _logLevelScheduled;
	}

	public void setLogLevelScheduled(boolean logLevelScheduled) {
		_logLevelScheduled = logLevelScheduled;
	}

	public Date getLogLevelStartDate() {
		return _logLevelStartDate;
	}

	public void setLogLevelStartDate(Date logLevelStartDate) {
		_logLevelStartDate = logLevelStartDate;
	}

	public Date getLogLevelEndDate() {
		return _logLevelEndDate;
	}

	public void setLogLevelEndDate(Date logLevelEndDate) {
		_logLevelEndDate = logLevelEndDate;
	}

	public boolean getActivateOnStartup() {
		return _activateOnStartup;
	}

	public boolean isActivateOnStartup() {
		return _activateOnStartup;
	}

	public void setActivateOnStartup(boolean activateOnStartup) {
		_activateOnStartup = activateOnStartup;
	}

	private long _LogLevelId;
	private long _companyId;
	private long _groupId;
	private long _userId;
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
}