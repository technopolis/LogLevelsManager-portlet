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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import gr.open.loglevelsmanager.loglevel.model.LogLevel;

import java.util.List;

/**
 * The persistence utility for the log level service. This utility wraps {@link LogLevelPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jack A. Rider
 * @see LogLevelPersistence
 * @see LogLevelPersistenceImpl
 * @generated
 */
public class LogLevelUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(LogLevel logLevel) {
		getPersistence().clearCache(logLevel);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<LogLevel> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LogLevel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LogLevel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static LogLevel update(LogLevel logLevel) throws SystemException {
		return getPersistence().update(logLevel);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static LogLevel update(LogLevel logLevel,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(logLevel, serviceContext);
	}

	/**
	* Returns all the log levels where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching log levels
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<gr.open.loglevelsmanager.loglevel.model.LogLevel> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the log levels where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link gr.open.loglevelsmanager.loglevel.model.impl.LogLevelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of log levels
	* @param end the upper bound of the range of log levels (not inclusive)
	* @return the range of matching log levels
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<gr.open.loglevelsmanager.loglevel.model.LogLevel> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the log levels where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link gr.open.loglevelsmanager.loglevel.model.impl.LogLevelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of log levels
	* @param end the upper bound of the range of log levels (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching log levels
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<gr.open.loglevelsmanager.loglevel.model.LogLevel> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first log level in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching log level
	* @throws gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException if a matching log level could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static gr.open.loglevelsmanager.loglevel.model.LogLevel findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first log level in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching log level, or <code>null</code> if a matching log level could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static gr.open.loglevelsmanager.loglevel.model.LogLevel fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last log level in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching log level
	* @throws gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException if a matching log level could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static gr.open.loglevelsmanager.loglevel.model.LogLevel findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last log level in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching log level, or <code>null</code> if a matching log level could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static gr.open.loglevelsmanager.loglevel.model.LogLevel fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the log levels before and after the current log level in the ordered set where groupId = &#63;.
	*
	* @param LogLevelId the primary key of the current log level
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next log level
	* @throws gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException if a log level with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static gr.open.loglevelsmanager.loglevel.model.LogLevel[] findByGroupId_PrevAndNext(
		long LogLevelId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(LogLevelId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the log levels that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching log levels that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<gr.open.loglevelsmanager.loglevel.model.LogLevel> filterFindByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroupId(groupId);
	}

	/**
	* Returns a range of all the log levels that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link gr.open.loglevelsmanager.loglevel.model.impl.LogLevelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of log levels
	* @param end the upper bound of the range of log levels (not inclusive)
	* @return the range of matching log levels that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<gr.open.loglevelsmanager.loglevel.model.LogLevel> filterFindByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the log levels that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link gr.open.loglevelsmanager.loglevel.model.impl.LogLevelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of log levels
	* @param end the upper bound of the range of log levels (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching log levels that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<gr.open.loglevelsmanager.loglevel.model.LogLevel> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the log levels before and after the current log level in the ordered set of log levels that the user has permission to view where groupId = &#63;.
	*
	* @param LogLevelId the primary key of the current log level
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next log level
	* @throws gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException if a log level with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static gr.open.loglevelsmanager.loglevel.model.LogLevel[] filterFindByGroupId_PrevAndNext(
		long LogLevelId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException {
		return getPersistence()
				   .filterFindByGroupId_PrevAndNext(LogLevelId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the log levels where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of log levels where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching log levels
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns the number of log levels that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching log levels that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroupId(groupId);
	}

	/**
	* Returns all the log levels where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @return the matching log levels
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<gr.open.loglevelsmanager.loglevel.model.LogLevel> findByUserIdGroupId(
		long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserIdGroupId(userId, groupId);
	}

	/**
	* Returns a range of all the log levels where userId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link gr.open.loglevelsmanager.loglevel.model.impl.LogLevelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param start the lower bound of the range of log levels
	* @param end the upper bound of the range of log levels (not inclusive)
	* @return the range of matching log levels
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<gr.open.loglevelsmanager.loglevel.model.LogLevel> findByUserIdGroupId(
		long userId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserIdGroupId(userId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the log levels where userId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link gr.open.loglevelsmanager.loglevel.model.impl.LogLevelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param start the lower bound of the range of log levels
	* @param end the upper bound of the range of log levels (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching log levels
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<gr.open.loglevelsmanager.loglevel.model.LogLevel> findByUserIdGroupId(
		long userId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserIdGroupId(userId, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first log level in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching log level
	* @throws gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException if a matching log level could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static gr.open.loglevelsmanager.loglevel.model.LogLevel findByUserIdGroupId_First(
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException {
		return getPersistence()
				   .findByUserIdGroupId_First(userId, groupId, orderByComparator);
	}

	/**
	* Returns the first log level in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching log level, or <code>null</code> if a matching log level could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static gr.open.loglevelsmanager.loglevel.model.LogLevel fetchByUserIdGroupId_First(
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserIdGroupId_First(userId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last log level in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching log level
	* @throws gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException if a matching log level could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static gr.open.loglevelsmanager.loglevel.model.LogLevel findByUserIdGroupId_Last(
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException {
		return getPersistence()
				   .findByUserIdGroupId_Last(userId, groupId, orderByComparator);
	}

	/**
	* Returns the last log level in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching log level, or <code>null</code> if a matching log level could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static gr.open.loglevelsmanager.loglevel.model.LogLevel fetchByUserIdGroupId_Last(
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserIdGroupId_Last(userId, groupId, orderByComparator);
	}

	/**
	* Returns the log levels before and after the current log level in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param LogLevelId the primary key of the current log level
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next log level
	* @throws gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException if a log level with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static gr.open.loglevelsmanager.loglevel.model.LogLevel[] findByUserIdGroupId_PrevAndNext(
		long LogLevelId, long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException {
		return getPersistence()
				   .findByUserIdGroupId_PrevAndNext(LogLevelId, userId,
			groupId, orderByComparator);
	}

	/**
	* Returns all the log levels that the user has permission to view where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @return the matching log levels that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<gr.open.loglevelsmanager.loglevel.model.LogLevel> filterFindByUserIdGroupId(
		long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByUserIdGroupId(userId, groupId);
	}

	/**
	* Returns a range of all the log levels that the user has permission to view where userId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link gr.open.loglevelsmanager.loglevel.model.impl.LogLevelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param start the lower bound of the range of log levels
	* @param end the upper bound of the range of log levels (not inclusive)
	* @return the range of matching log levels that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<gr.open.loglevelsmanager.loglevel.model.LogLevel> filterFindByUserIdGroupId(
		long userId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByUserIdGroupId(userId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the log levels that the user has permissions to view where userId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link gr.open.loglevelsmanager.loglevel.model.impl.LogLevelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param start the lower bound of the range of log levels
	* @param end the upper bound of the range of log levels (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching log levels that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<gr.open.loglevelsmanager.loglevel.model.LogLevel> filterFindByUserIdGroupId(
		long userId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByUserIdGroupId(userId, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the log levels before and after the current log level in the ordered set of log levels that the user has permission to view where userId = &#63; and groupId = &#63;.
	*
	* @param LogLevelId the primary key of the current log level
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next log level
	* @throws gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException if a log level with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static gr.open.loglevelsmanager.loglevel.model.LogLevel[] filterFindByUserIdGroupId_PrevAndNext(
		long LogLevelId, long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException {
		return getPersistence()
				   .filterFindByUserIdGroupId_PrevAndNext(LogLevelId, userId,
			groupId, orderByComparator);
	}

	/**
	* Removes all the log levels where userId = &#63; and groupId = &#63; from the database.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserIdGroupId(long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserIdGroupId(userId, groupId);
	}

	/**
	* Returns the number of log levels where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @return the number of matching log levels
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserIdGroupId(long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserIdGroupId(userId, groupId);
	}

	/**
	* Returns the number of log levels that the user has permission to view where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @return the number of matching log levels that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByUserIdGroupId(long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByUserIdGroupId(userId, groupId);
	}

	/**
	* Returns all the log levels where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching log levels
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<gr.open.loglevelsmanager.loglevel.model.LogLevel> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId);
	}

	/**
	* Returns a range of all the log levels where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link gr.open.loglevelsmanager.loglevel.model.impl.LogLevelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of log levels
	* @param end the upper bound of the range of log levels (not inclusive)
	* @return the range of matching log levels
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<gr.open.loglevelsmanager.loglevel.model.LogLevel> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	* Returns an ordered range of all the log levels where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link gr.open.loglevelsmanager.loglevel.model.impl.LogLevelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of log levels
	* @param end the upper bound of the range of log levels (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching log levels
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<gr.open.loglevelsmanager.loglevel.model.LogLevel> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserId(userId, start, end, orderByComparator);
	}

	/**
	* Returns the first log level in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching log level
	* @throws gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException if a matching log level could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static gr.open.loglevelsmanager.loglevel.model.LogLevel findByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException {
		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the first log level in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching log level, or <code>null</code> if a matching log level could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static gr.open.loglevelsmanager.loglevel.model.LogLevel fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the last log level in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching log level
	* @throws gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException if a matching log level could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static gr.open.loglevelsmanager.loglevel.model.LogLevel findByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException {
		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the last log level in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching log level, or <code>null</code> if a matching log level could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static gr.open.loglevelsmanager.loglevel.model.LogLevel fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the log levels before and after the current log level in the ordered set where userId = &#63;.
	*
	* @param LogLevelId the primary key of the current log level
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next log level
	* @throws gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException if a log level with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static gr.open.loglevelsmanager.loglevel.model.LogLevel[] findByUserId_PrevAndNext(
		long LogLevelId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException {
		return getPersistence()
				   .findByUserId_PrevAndNext(LogLevelId, userId,
			orderByComparator);
	}

	/**
	* Removes all the log levels where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserId(userId);
	}

	/**
	* Returns the number of log levels where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching log levels
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserId(userId);
	}

	/**
	* Returns all the log levels where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching log levels
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<gr.open.loglevelsmanager.loglevel.model.LogLevel> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId);
	}

	/**
	* Returns a range of all the log levels where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link gr.open.loglevelsmanager.loglevel.model.impl.LogLevelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of log levels
	* @param end the upper bound of the range of log levels (not inclusive)
	* @return the range of matching log levels
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<gr.open.loglevelsmanager.loglevel.model.LogLevel> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId, start, end);
	}

	/**
	* Returns an ordered range of all the log levels where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link gr.open.loglevelsmanager.loglevel.model.impl.LogLevelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of log levels
	* @param end the upper bound of the range of log levels (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching log levels
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<gr.open.loglevelsmanager.loglevel.model.LogLevel> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first log level in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching log level
	* @throws gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException if a matching log level could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static gr.open.loglevelsmanager.loglevel.model.LogLevel findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException {
		return getPersistence()
				   .findByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the first log level in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching log level, or <code>null</code> if a matching log level could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static gr.open.loglevelsmanager.loglevel.model.LogLevel fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the last log level in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching log level
	* @throws gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException if a matching log level could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static gr.open.loglevelsmanager.loglevel.model.LogLevel findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException {
		return getPersistence()
				   .findByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last log level in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching log level, or <code>null</code> if a matching log level could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static gr.open.loglevelsmanager.loglevel.model.LogLevel fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the log levels before and after the current log level in the ordered set where companyId = &#63;.
	*
	* @param LogLevelId the primary key of the current log level
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next log level
	* @throws gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException if a log level with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static gr.open.loglevelsmanager.loglevel.model.LogLevel[] findByCompanyId_PrevAndNext(
		long LogLevelId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException {
		return getPersistence()
				   .findByCompanyId_PrevAndNext(LogLevelId, companyId,
			orderByComparator);
	}

	/**
	* Removes all the log levels where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompanyId(companyId);
	}

	/**
	* Returns the number of log levels where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching log levels
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompanyId(companyId);
	}

	/**
	* Returns all the log levels where activateOnStartup = &#63;.
	*
	* @param activateOnStartup the activate on startup
	* @return the matching log levels
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<gr.open.loglevelsmanager.loglevel.model.LogLevel> findByActivateOnStartup(
		boolean activateOnStartup)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByActivateOnStartup(activateOnStartup);
	}

	/**
	* Returns a range of all the log levels where activateOnStartup = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link gr.open.loglevelsmanager.loglevel.model.impl.LogLevelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param activateOnStartup the activate on startup
	* @param start the lower bound of the range of log levels
	* @param end the upper bound of the range of log levels (not inclusive)
	* @return the range of matching log levels
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<gr.open.loglevelsmanager.loglevel.model.LogLevel> findByActivateOnStartup(
		boolean activateOnStartup, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByActivateOnStartup(activateOnStartup, start, end);
	}

	/**
	* Returns an ordered range of all the log levels where activateOnStartup = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link gr.open.loglevelsmanager.loglevel.model.impl.LogLevelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param activateOnStartup the activate on startup
	* @param start the lower bound of the range of log levels
	* @param end the upper bound of the range of log levels (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching log levels
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<gr.open.loglevelsmanager.loglevel.model.LogLevel> findByActivateOnStartup(
		boolean activateOnStartup, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByActivateOnStartup(activateOnStartup, start, end,
			orderByComparator);
	}

	/**
	* Returns the first log level in the ordered set where activateOnStartup = &#63;.
	*
	* @param activateOnStartup the activate on startup
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching log level
	* @throws gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException if a matching log level could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static gr.open.loglevelsmanager.loglevel.model.LogLevel findByActivateOnStartup_First(
		boolean activateOnStartup,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException {
		return getPersistence()
				   .findByActivateOnStartup_First(activateOnStartup,
			orderByComparator);
	}

	/**
	* Returns the first log level in the ordered set where activateOnStartup = &#63;.
	*
	* @param activateOnStartup the activate on startup
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching log level, or <code>null</code> if a matching log level could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static gr.open.loglevelsmanager.loglevel.model.LogLevel fetchByActivateOnStartup_First(
		boolean activateOnStartup,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByActivateOnStartup_First(activateOnStartup,
			orderByComparator);
	}

	/**
	* Returns the last log level in the ordered set where activateOnStartup = &#63;.
	*
	* @param activateOnStartup the activate on startup
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching log level
	* @throws gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException if a matching log level could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static gr.open.loglevelsmanager.loglevel.model.LogLevel findByActivateOnStartup_Last(
		boolean activateOnStartup,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException {
		return getPersistence()
				   .findByActivateOnStartup_Last(activateOnStartup,
			orderByComparator);
	}

	/**
	* Returns the last log level in the ordered set where activateOnStartup = &#63;.
	*
	* @param activateOnStartup the activate on startup
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching log level, or <code>null</code> if a matching log level could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static gr.open.loglevelsmanager.loglevel.model.LogLevel fetchByActivateOnStartup_Last(
		boolean activateOnStartup,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByActivateOnStartup_Last(activateOnStartup,
			orderByComparator);
	}

	/**
	* Returns the log levels before and after the current log level in the ordered set where activateOnStartup = &#63;.
	*
	* @param LogLevelId the primary key of the current log level
	* @param activateOnStartup the activate on startup
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next log level
	* @throws gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException if a log level with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static gr.open.loglevelsmanager.loglevel.model.LogLevel[] findByActivateOnStartup_PrevAndNext(
		long LogLevelId, boolean activateOnStartup,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException {
		return getPersistence()
				   .findByActivateOnStartup_PrevAndNext(LogLevelId,
			activateOnStartup, orderByComparator);
	}

	/**
	* Removes all the log levels where activateOnStartup = &#63; from the database.
	*
	* @param activateOnStartup the activate on startup
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByActivateOnStartup(boolean activateOnStartup)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByActivateOnStartup(activateOnStartup);
	}

	/**
	* Returns the number of log levels where activateOnStartup = &#63;.
	*
	* @param activateOnStartup the activate on startup
	* @return the number of matching log levels
	* @throws SystemException if a system exception occurred
	*/
	public static int countByActivateOnStartup(boolean activateOnStartup)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByActivateOnStartup(activateOnStartup);
	}

	/**
	* Returns all the log levels where logLevelScheduled = &#63;.
	*
	* @param logLevelScheduled the log level scheduled
	* @return the matching log levels
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<gr.open.loglevelsmanager.loglevel.model.LogLevel> findByScheduled(
		boolean logLevelScheduled)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByScheduled(logLevelScheduled);
	}

	/**
	* Returns a range of all the log levels where logLevelScheduled = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link gr.open.loglevelsmanager.loglevel.model.impl.LogLevelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param logLevelScheduled the log level scheduled
	* @param start the lower bound of the range of log levels
	* @param end the upper bound of the range of log levels (not inclusive)
	* @return the range of matching log levels
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<gr.open.loglevelsmanager.loglevel.model.LogLevel> findByScheduled(
		boolean logLevelScheduled, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByScheduled(logLevelScheduled, start, end);
	}

	/**
	* Returns an ordered range of all the log levels where logLevelScheduled = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link gr.open.loglevelsmanager.loglevel.model.impl.LogLevelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param logLevelScheduled the log level scheduled
	* @param start the lower bound of the range of log levels
	* @param end the upper bound of the range of log levels (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching log levels
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<gr.open.loglevelsmanager.loglevel.model.LogLevel> findByScheduled(
		boolean logLevelScheduled, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByScheduled(logLevelScheduled, start, end,
			orderByComparator);
	}

	/**
	* Returns the first log level in the ordered set where logLevelScheduled = &#63;.
	*
	* @param logLevelScheduled the log level scheduled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching log level
	* @throws gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException if a matching log level could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static gr.open.loglevelsmanager.loglevel.model.LogLevel findByScheduled_First(
		boolean logLevelScheduled,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException {
		return getPersistence()
				   .findByScheduled_First(logLevelScheduled, orderByComparator);
	}

	/**
	* Returns the first log level in the ordered set where logLevelScheduled = &#63;.
	*
	* @param logLevelScheduled the log level scheduled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching log level, or <code>null</code> if a matching log level could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static gr.open.loglevelsmanager.loglevel.model.LogLevel fetchByScheduled_First(
		boolean logLevelScheduled,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByScheduled_First(logLevelScheduled, orderByComparator);
	}

	/**
	* Returns the last log level in the ordered set where logLevelScheduled = &#63;.
	*
	* @param logLevelScheduled the log level scheduled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching log level
	* @throws gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException if a matching log level could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static gr.open.loglevelsmanager.loglevel.model.LogLevel findByScheduled_Last(
		boolean logLevelScheduled,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException {
		return getPersistence()
				   .findByScheduled_Last(logLevelScheduled, orderByComparator);
	}

	/**
	* Returns the last log level in the ordered set where logLevelScheduled = &#63;.
	*
	* @param logLevelScheduled the log level scheduled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching log level, or <code>null</code> if a matching log level could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static gr.open.loglevelsmanager.loglevel.model.LogLevel fetchByScheduled_Last(
		boolean logLevelScheduled,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByScheduled_Last(logLevelScheduled, orderByComparator);
	}

	/**
	* Returns the log levels before and after the current log level in the ordered set where logLevelScheduled = &#63;.
	*
	* @param LogLevelId the primary key of the current log level
	* @param logLevelScheduled the log level scheduled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next log level
	* @throws gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException if a log level with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static gr.open.loglevelsmanager.loglevel.model.LogLevel[] findByScheduled_PrevAndNext(
		long LogLevelId, boolean logLevelScheduled,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException {
		return getPersistence()
				   .findByScheduled_PrevAndNext(LogLevelId, logLevelScheduled,
			orderByComparator);
	}

	/**
	* Removes all the log levels where logLevelScheduled = &#63; from the database.
	*
	* @param logLevelScheduled the log level scheduled
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByScheduled(boolean logLevelScheduled)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByScheduled(logLevelScheduled);
	}

	/**
	* Returns the number of log levels where logLevelScheduled = &#63;.
	*
	* @param logLevelScheduled the log level scheduled
	* @return the number of matching log levels
	* @throws SystemException if a system exception occurred
	*/
	public static int countByScheduled(boolean logLevelScheduled)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByScheduled(logLevelScheduled);
	}

	/**
	* Caches the log level in the entity cache if it is enabled.
	*
	* @param logLevel the log level
	*/
	public static void cacheResult(
		gr.open.loglevelsmanager.loglevel.model.LogLevel logLevel) {
		getPersistence().cacheResult(logLevel);
	}

	/**
	* Caches the log levels in the entity cache if it is enabled.
	*
	* @param logLevels the log levels
	*/
	public static void cacheResult(
		java.util.List<gr.open.loglevelsmanager.loglevel.model.LogLevel> logLevels) {
		getPersistence().cacheResult(logLevels);
	}

	/**
	* Creates a new log level with the primary key. Does not add the log level to the database.
	*
	* @param LogLevelId the primary key for the new log level
	* @return the new log level
	*/
	public static gr.open.loglevelsmanager.loglevel.model.LogLevel create(
		long LogLevelId) {
		return getPersistence().create(LogLevelId);
	}

	/**
	* Removes the log level with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param LogLevelId the primary key of the log level
	* @return the log level that was removed
	* @throws gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException if a log level with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static gr.open.loglevelsmanager.loglevel.model.LogLevel remove(
		long LogLevelId)
		throws com.liferay.portal.kernel.exception.SystemException,
			gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException {
		return getPersistence().remove(LogLevelId);
	}

	public static gr.open.loglevelsmanager.loglevel.model.LogLevel updateImpl(
		gr.open.loglevelsmanager.loglevel.model.LogLevel logLevel)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(logLevel);
	}

	/**
	* Returns the log level with the primary key or throws a {@link gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException} if it could not be found.
	*
	* @param LogLevelId the primary key of the log level
	* @return the log level
	* @throws gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException if a log level with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static gr.open.loglevelsmanager.loglevel.model.LogLevel findByPrimaryKey(
		long LogLevelId)
		throws com.liferay.portal.kernel.exception.SystemException,
			gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException {
		return getPersistence().findByPrimaryKey(LogLevelId);
	}

	/**
	* Returns the log level with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param LogLevelId the primary key of the log level
	* @return the log level, or <code>null</code> if a log level with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static gr.open.loglevelsmanager.loglevel.model.LogLevel fetchByPrimaryKey(
		long LogLevelId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(LogLevelId);
	}

	/**
	* Returns all the log levels.
	*
	* @return the log levels
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<gr.open.loglevelsmanager.loglevel.model.LogLevel> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<gr.open.loglevelsmanager.loglevel.model.LogLevel> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the log levels.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link gr.open.loglevelsmanager.loglevel.model.impl.LogLevelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of log levels
	* @param end the upper bound of the range of log levels (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of log levels
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<gr.open.loglevelsmanager.loglevel.model.LogLevel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the log levels from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of log levels.
	*
	* @return the number of log levels
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static LogLevelPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (LogLevelPersistence)PortletBeanLocatorUtil.locate(gr.open.loglevelsmanager.loglevel.service.ClpSerializer.getServletContextName(),
					LogLevelPersistence.class.getName());

			ReferenceRegistry.registerReference(LogLevelUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(LogLevelPersistence persistence) {
	}

	private static LogLevelPersistence _persistence;
}