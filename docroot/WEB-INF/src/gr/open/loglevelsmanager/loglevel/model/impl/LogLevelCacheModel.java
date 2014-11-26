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

package gr.open.loglevelsmanager.loglevel.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import gr.open.loglevelsmanager.loglevel.model.LogLevel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LogLevel in entity cache.
 *
 * @author Jack A. Rider
 * @see LogLevel
 * @generated
 */
public class LogLevelCacheModel implements CacheModel<LogLevel>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{LogLevelId=");
		sb.append(LogLevelId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", logLevelDescription=");
		sb.append(logLevelDescription);
		sb.append(", logLevelPriority=");
		sb.append(logLevelPriority);
		sb.append(", logLevelCategory=");
		sb.append(logLevelCategory);
		sb.append(", logLevelScheduled=");
		sb.append(logLevelScheduled);
		sb.append(", logLevelStartDate=");
		sb.append(logLevelStartDate);
		sb.append(", logLevelEndDate=");
		sb.append(logLevelEndDate);
		sb.append(", activateOnStartup=");
		sb.append(activateOnStartup);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LogLevel toEntityModel() {
		LogLevelImpl logLevelImpl = new LogLevelImpl();

		logLevelImpl.setLogLevelId(LogLevelId);
		logLevelImpl.setCompanyId(companyId);
		logLevelImpl.setGroupId(groupId);
		logLevelImpl.setUserId(userId);

		if (userName == null) {
			logLevelImpl.setUserName(StringPool.BLANK);
		}
		else {
			logLevelImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			logLevelImpl.setCreateDate(null);
		}
		else {
			logLevelImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			logLevelImpl.setModifiedDate(null);
		}
		else {
			logLevelImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (logLevelDescription == null) {
			logLevelImpl.setLogLevelDescription(StringPool.BLANK);
		}
		else {
			logLevelImpl.setLogLevelDescription(logLevelDescription);
		}

		if (logLevelPriority == null) {
			logLevelImpl.setLogLevelPriority(StringPool.BLANK);
		}
		else {
			logLevelImpl.setLogLevelPriority(logLevelPriority);
		}

		if (logLevelCategory == null) {
			logLevelImpl.setLogLevelCategory(StringPool.BLANK);
		}
		else {
			logLevelImpl.setLogLevelCategory(logLevelCategory);
		}

		logLevelImpl.setLogLevelScheduled(logLevelScheduled);

		if (logLevelStartDate == Long.MIN_VALUE) {
			logLevelImpl.setLogLevelStartDate(null);
		}
		else {
			logLevelImpl.setLogLevelStartDate(new Date(logLevelStartDate));
		}

		if (logLevelEndDate == Long.MIN_VALUE) {
			logLevelImpl.setLogLevelEndDate(null);
		}
		else {
			logLevelImpl.setLogLevelEndDate(new Date(logLevelEndDate));
		}

		logLevelImpl.setActivateOnStartup(activateOnStartup);

		logLevelImpl.resetOriginalValues();

		return logLevelImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		LogLevelId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		logLevelDescription = objectInput.readUTF();
		logLevelPriority = objectInput.readUTF();
		logLevelCategory = objectInput.readUTF();
		logLevelScheduled = objectInput.readBoolean();
		logLevelStartDate = objectInput.readLong();
		logLevelEndDate = objectInput.readLong();
		activateOnStartup = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(LogLevelId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (logLevelDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(logLevelDescription);
		}

		if (logLevelPriority == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(logLevelPriority);
		}

		if (logLevelCategory == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(logLevelCategory);
		}

		objectOutput.writeBoolean(logLevelScheduled);
		objectOutput.writeLong(logLevelStartDate);
		objectOutput.writeLong(logLevelEndDate);
		objectOutput.writeBoolean(activateOnStartup);
	}

	public long LogLevelId;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String logLevelDescription;
	public String logLevelPriority;
	public String logLevelCategory;
	public boolean logLevelScheduled;
	public long logLevelStartDate;
	public long logLevelEndDate;
	public boolean activateOnStartup;
}