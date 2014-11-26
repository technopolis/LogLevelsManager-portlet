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

package gr.open.loglevelsmanager.loglevel.service.impl;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;

import gr.open.loglevelsmanager.loglevel.model.LogLevel;
import gr.open.loglevelsmanager.loglevel.service.base.LogLevelLocalServiceBaseImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Jack A. Rider
 * @author Juan Gonzalez P.
 */
public class LogLevelLocalServiceImpl extends LogLevelLocalServiceBaseImpl {

	private static final Log logger = LogFactoryUtil.getLog(LogLevelLocalServiceImpl.class);

	private LogLevel _addLogLevel(LogLevel validLogLevel, ServiceContext serviceContext)
		throws PortalException, SystemException {

		LogLevel fileobj = logLevelPersistence.create(counterLocalService.increment(LogLevel.class.getName()));

		User user = userPersistence.findByPrimaryKey(validLogLevel.getUserId());

		Date now = new Date();
		fileobj.setCompanyId(validLogLevel.getCompanyId());
		fileobj.setGroupId(validLogLevel.getGroupId());
		fileobj.setUserId(user.getUserId());
		fileobj.setUserName(user.getFullName());
		fileobj.setCreateDate(now);
		fileobj.setModifiedDate(now);

		fileobj.setLogLevelDescription(validLogLevel.getLogLevelDescription());
		fileobj.setLogLevelPriority(validLogLevel.getLogLevelPriority());
		fileobj.setActivateOnStartup(validLogLevel.getActivateOnStartup());
		fileobj.setLogLevelScheduled(validLogLevel.getLogLevelScheduled());
		fileobj.setLogLevelCategory(validLogLevel.getLogLevelCategory());
		fileobj.setLogLevelStartDate(validLogLevel.getLogLevelStartDate());
		fileobj.setLogLevelEndDate(validLogLevel.getLogLevelEndDate());

		LogLevel updatedLogLevel = logLevelPersistence.update(fileobj);
		logger.debug("CREATED " + updatedLogLevel);
		return updatedLogLevel;
	}

	@Override
	public void addEntryResources(LogLevel entry, boolean addGroupPermissions, boolean addGuestPermissions)
		throws PortalException, SystemException {

		resourceLocalService.addResources(
			entry.getCompanyId(), entry.getGroupId(), entry.getUserId(), LogLevel.class.getName(),
			entry.getPrimaryKey(), false, addGroupPermissions, addGuestPermissions);
	}

	@Override
	public void addEntryResources(LogLevel entry, String[] groupPermissions, String[] guestPermissions)
		throws PortalException, SystemException {

		resourceLocalService.addModelResources(
			entry.getCompanyId(), entry.getGroupId(), entry.getUserId(), LogLevel.class.getName(),
			entry.getPrimaryKey(), groupPermissions, guestPermissions);
	}

	@Override
	public void addEntryResources(long entryId, boolean addGroupPermissions, boolean addGuestPermissions)
		throws PortalException, SystemException {

		LogLevel entry = logLevelPersistence.findByPrimaryKey(entryId);

		addEntryResources(entry, addGroupPermissions, addGuestPermissions);
	}

	@Override
	public void addEntryResources(long entryId, String[] groupPermissions, String[] guestPermissions)
		throws PortalException, SystemException {

		LogLevel entry = logLevelPersistence.findByPrimaryKey(entryId);

		addEntryResources(entry, groupPermissions, guestPermissions);
	}

	@Override
	public LogLevel addLogLevel(LogLevel validLogLevel, ServiceContext serviceContext)
		throws PortalException, SystemException {

		LogLevel retVal = _addLogLevel(validLogLevel, serviceContext);

		// Resources
		if (serviceContext.isAddGroupPermissions() || serviceContext.isAddGuestPermissions()) {

			addEntryResources(retVal, serviceContext.isAddGroupPermissions(), serviceContext.isAddGuestPermissions());
		}
		else {
			addEntryResources(retVal, serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
		}

		// Indexer
		Indexer indexer = IndexerRegistryUtil.getIndexer(LogLevel.class);

		indexer.reindex(retVal);
		return retVal;
	}

	@Override
	@SuppressWarnings("unchecked")
	public int countAllInGroup(long groupId)
		throws SystemException {

		int count = logLevelPersistence.countByGroupId(groupId);
		return count;
	}

	@Override
	@SuppressWarnings("unchecked")
	public int countAllInUser(long userId)
		throws SystemException {

		int count = logLevelPersistence.countByUserId(userId);
		return count;
	}

	@Override
	@SuppressWarnings("unchecked")
	public int countAllInUserAndGroup(long userId, long groupId)
		throws SystemException {

		int count = logLevelPersistence.countByUserIdGroupId(userId, groupId);
		return count;
	}

	@Override
	public void deleteLogLevelEntry(LogLevel fileobj)
		throws PortalException, SystemException {

		logLevelPersistence.remove(fileobj.getPrimaryKey());

		// Resources

		resourceLocalService.deleteResource(
			fileobj.getCompanyId(), LogLevel.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
			fileobj.getPrimaryKey());

		// Indexer

		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(LogLevel.class);

		indexer.delete(fileobj);

	}

	@Override
	@SuppressWarnings("unchecked")
	public List findAllInGroup(long groupId)
		throws SystemException {

		List<LogLevel> list = (List<LogLevel>) logLevelPersistence.findByGroupId(groupId);
		return list;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List findAllInGroup(long groupId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {

		List<LogLevel> list =
			(List<LogLevel>) logLevelPersistence.findByGroupId(groupId, start, end, orderByComparator);
		return list;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List findAllInGroup(long groupId, OrderByComparator orderByComparator)
		throws SystemException {

		List<LogLevel> list =
			(List<LogLevel>) findAllInGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, orderByComparator);
		return list;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List findAllInUser(long userId)
		throws SystemException {

		List<LogLevel> list = (List<LogLevel>) logLevelPersistence.findByUserId(userId);
		return list;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List findAllInUser(long userId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {

		List<LogLevel> list = (List<LogLevel>) logLevelPersistence.findByUserId(userId, start, end, orderByComparator);
		return list;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List findAllInUser(long userId, OrderByComparator orderByComparator)
		throws SystemException {

		List<LogLevel> list =
			(List<LogLevel>) findAllInUser(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, orderByComparator);
		return list;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List findAllInUserAndGroup(long userId, long groupId)
		throws SystemException {

		List<LogLevel> list = (List<LogLevel>) logLevelPersistence.findByUserIdGroupId(userId, groupId);
		return list;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List findAllInUserAndGroup(long userId, long groupId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {

		List<LogLevel> list =
			(List<LogLevel>) logLevelPersistence.findByUserIdGroupId(userId, groupId, start, end, orderByComparator);
		return list;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List findAllInUserAndGroup(long userId, long groupId, OrderByComparator orderByComparator)
		throws SystemException {

		List<LogLevel> list =
			(List<LogLevel>) findAllInUserAndGroup(
				groupId, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, orderByComparator);
		return list;
	}

	@Override
	public List<LogLevel> getByActivateOnStartup(boolean activateOnStartup) {

		try {
			return logLevelPersistence.findByActivateOnStartup(activateOnStartup);
		}
		catch (SystemException e) {
			logger.error(e.getMessage(), e);
		}

		return new ArrayList<LogLevel>();
	}

	@Override
	public List<LogLevel> getByScheduled(boolean scheduled) {

		try {
			return logLevelPersistence.findByScheduled(scheduled);
		}
		catch (SystemException e) {
			logger.error(e.getMessage(), e);
		}

		return new ArrayList<LogLevel>();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<LogLevel> getCompanyEntries(long companyId, int start, int end)
		throws SystemException {

		return logLevelPersistence.findByCompanyId(companyId, start, end);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<LogLevel> getCompanyEntries(long companyId, int start, int end, OrderByComparator obc)
		throws SystemException {

		return logLevelPersistence.findByCompanyId(companyId, start, end, obc);
	}

	@Override
	@SuppressWarnings("unchecked")
	public int getCompanyEntriesCount(long companyId)
		throws SystemException {

		return logLevelPersistence.countByCompanyId(companyId);
	}

	@Override
	public void updateEntryResources(LogLevel entry, String[] groupPermissions, String[] guestPermissions)
		throws PortalException, SystemException {

		resourceLocalService.updateResources(
			entry.getCompanyId(), entry.getGroupId(), LogLevel.class.getName(), entry.getPrimaryKey(),
			groupPermissions, guestPermissions);
	}

	@Override
	public LogLevel updateLogLevel(LogLevel validLogLevel, ServiceContext serviceContext)
		throws PortalException, SystemException {

		LogLevel entry = logLevelPersistence.findByPrimaryKey(validLogLevel.getPrimaryKey());
		validLogLevel.setCreateDate(entry.getCreateDate());
		User user = userPersistence.findByPrimaryKey(validLogLevel.getUserId());
		validLogLevel.setUserName(user.getFullName());

		validLogLevel.setModifiedDate(serviceContext.getModifiedDate(null));

		LogLevel retVal = logLevelPersistence.update(validLogLevel);

		// Resources

		if ((serviceContext.getGroupPermissions() != null) || (serviceContext.getGuestPermissions() != null)) {

			updateEntryResources(retVal, serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
		}

		// Indexer
		Indexer indexer = IndexerRegistryUtil.getIndexer(LogLevel.class);

		indexer.reindex(retVal);

		return retVal;
	}
}
