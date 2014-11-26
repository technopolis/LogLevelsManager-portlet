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

package gr.open.loglevelsmanager.loglevel.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * Provides the local service interface for LogLevel. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Jack A. Rider
 * @see LogLevelLocalServiceUtil
 * @see gr.open.loglevelsmanager.loglevel.service.base.LogLevelLocalServiceBaseImpl
 * @see gr.open.loglevelsmanager.loglevel.service.impl.LogLevelLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface LogLevelLocalService extends BaseLocalService,
	InvokableLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LogLevelLocalServiceUtil} to access the log level local service. Add custom service methods to {@link gr.open.loglevelsmanager.loglevel.service.impl.LogLevelLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the log level to the database. Also notifies the appropriate model listeners.
	*
	* @param logLevel the log level
	* @return the log level that was added
	* @throws SystemException if a system exception occurred
	*/
	public gr.open.loglevelsmanager.loglevel.model.LogLevel addLogLevel(
		gr.open.loglevelsmanager.loglevel.model.LogLevel logLevel)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new log level with the primary key. Does not add the log level to the database.
	*
	* @param LogLevelId the primary key for the new log level
	* @return the new log level
	*/
	public gr.open.loglevelsmanager.loglevel.model.LogLevel createLogLevel(
		long LogLevelId);

	/**
	* Deletes the log level with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param LogLevelId the primary key of the log level
	* @return the log level that was removed
	* @throws PortalException if a log level with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public gr.open.loglevelsmanager.loglevel.model.LogLevel deleteLogLevel(
		long LogLevelId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the log level from the database. Also notifies the appropriate model listeners.
	*
	* @param logLevel the log level
	* @return the log level that was removed
	* @throws SystemException if a system exception occurred
	*/
	public gr.open.loglevelsmanager.loglevel.model.LogLevel deleteLogLevel(
		gr.open.loglevelsmanager.loglevel.model.LogLevel logLevel)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link gr.open.loglevelsmanager.loglevel.model.impl.LogLevelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link gr.open.loglevelsmanager.loglevel.model.impl.LogLevelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public gr.open.loglevelsmanager.loglevel.model.LogLevel fetchLogLevel(
		long LogLevelId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the log level with the primary key.
	*
	* @param LogLevelId the primary key of the log level
	* @return the log level
	* @throws PortalException if a log level with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public gr.open.loglevelsmanager.loglevel.model.LogLevel getLogLevel(
		long LogLevelId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the log levels.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link gr.open.loglevelsmanager.loglevel.model.impl.LogLevelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of log levels
	* @param end the upper bound of the range of log levels (not inclusive)
	* @return the range of log levels
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<gr.open.loglevelsmanager.loglevel.model.LogLevel> getLogLevels(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of log levels.
	*
	* @return the number of log levels
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getLogLevelsCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the log level in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param logLevel the log level
	* @return the log level that was updated
	* @throws SystemException if a system exception occurred
	*/
	public gr.open.loglevelsmanager.loglevel.model.LogLevel updateLogLevel(
		gr.open.loglevelsmanager.loglevel.model.LogLevel logLevel)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	public void addEntryResources(
		gr.open.loglevelsmanager.loglevel.model.LogLevel entry,
		boolean addGroupPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public void addEntryResources(
		gr.open.loglevelsmanager.loglevel.model.LogLevel entry,
		java.lang.String[] groupPermissions, java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public void addEntryResources(long entryId, boolean addGroupPermissions,
		boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public void addEntryResources(long entryId,
		java.lang.String[] groupPermissions, java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public gr.open.loglevelsmanager.loglevel.model.LogLevel addLogLevel(
		gr.open.loglevelsmanager.loglevel.model.LogLevel validLogLevel,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public int countAllInGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countAllInUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countAllInUserAndGroup(long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void deleteLogLevelEntry(
		gr.open.loglevelsmanager.loglevel.model.LogLevel fileobj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public java.util.List findAllInGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List findAllInGroup(long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List findAllInGroup(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List findAllInUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List findAllInUser(long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List findAllInUser(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List findAllInUserAndGroup(long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List findAllInUserAndGroup(long userId, long groupId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List findAllInUserAndGroup(long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<gr.open.loglevelsmanager.loglevel.model.LogLevel> getByActivateOnStartup(
		boolean activateOnStartup);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<gr.open.loglevelsmanager.loglevel.model.LogLevel> getByScheduled(
		boolean scheduled);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<gr.open.loglevelsmanager.loglevel.model.LogLevel> getCompanyEntries(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<gr.open.loglevelsmanager.loglevel.model.LogLevel> getCompanyEntries(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCompanyEntriesCount(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void updateEntryResources(
		gr.open.loglevelsmanager.loglevel.model.LogLevel entry,
		java.lang.String[] groupPermissions, java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public gr.open.loglevelsmanager.loglevel.model.LogLevel updateLogLevel(
		gr.open.loglevelsmanager.loglevel.model.LogLevel validLogLevel,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;
}