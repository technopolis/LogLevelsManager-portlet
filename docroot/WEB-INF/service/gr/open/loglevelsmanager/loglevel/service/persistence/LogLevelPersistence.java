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

import com.liferay.portal.service.persistence.BasePersistence;

import gr.open.loglevelsmanager.loglevel.model.LogLevel;

/**
 * The persistence interface for the log level service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jack A. Rider
 * @see LogLevelPersistenceImpl
 * @see LogLevelUtil
 * @generated
 */
public interface LogLevelPersistence extends BasePersistence<LogLevel> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LogLevelUtil} to access the log level persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the log levels where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching log levels
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<gr.open.loglevelsmanager.loglevel.model.LogLevel> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<gr.open.loglevelsmanager.loglevel.model.LogLevel> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<gr.open.loglevelsmanager.loglevel.model.LogLevel> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first log level in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching log level
	* @throws gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException if a matching log level could not be found
	* @throws SystemException if a system exception occurred
	*/
	public gr.open.loglevelsmanager.loglevel.model.LogLevel findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException;

	/**
	* Returns the first log level in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching log level, or <code>null</code> if a matching log level could not be found
	* @throws SystemException if a system exception occurred
	*/
	public gr.open.loglevelsmanager.loglevel.model.LogLevel fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last log level in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching log level
	* @throws gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException if a matching log level could not be found
	* @throws SystemException if a system exception occurred
	*/
	public gr.open.loglevelsmanager.loglevel.model.LogLevel findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException;

	/**
	* Returns the last log level in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching log level, or <code>null</code> if a matching log level could not be found
	* @throws SystemException if a system exception occurred
	*/
	public gr.open.loglevelsmanager.loglevel.model.LogLevel fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public gr.open.loglevelsmanager.loglevel.model.LogLevel[] findByGroupId_PrevAndNext(
		long LogLevelId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException;

	/**
	* Returns all the log levels that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching log levels that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<gr.open.loglevelsmanager.loglevel.model.LogLevel> filterFindByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<gr.open.loglevelsmanager.loglevel.model.LogLevel> filterFindByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<gr.open.loglevelsmanager.loglevel.model.LogLevel> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public gr.open.loglevelsmanager.loglevel.model.LogLevel[] filterFindByGroupId_PrevAndNext(
		long LogLevelId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException;

	/**
	* Removes all the log levels where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of log levels where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching log levels
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of log levels that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching log levels that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the log levels where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @return the matching log levels
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<gr.open.loglevelsmanager.loglevel.model.LogLevel> findByUserIdGroupId(
		long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<gr.open.loglevelsmanager.loglevel.model.LogLevel> findByUserIdGroupId(
		long userId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<gr.open.loglevelsmanager.loglevel.model.LogLevel> findByUserIdGroupId(
		long userId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public gr.open.loglevelsmanager.loglevel.model.LogLevel findByUserIdGroupId_First(
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException;

	/**
	* Returns the first log level in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching log level, or <code>null</code> if a matching log level could not be found
	* @throws SystemException if a system exception occurred
	*/
	public gr.open.loglevelsmanager.loglevel.model.LogLevel fetchByUserIdGroupId_First(
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public gr.open.loglevelsmanager.loglevel.model.LogLevel findByUserIdGroupId_Last(
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException;

	/**
	* Returns the last log level in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching log level, or <code>null</code> if a matching log level could not be found
	* @throws SystemException if a system exception occurred
	*/
	public gr.open.loglevelsmanager.loglevel.model.LogLevel fetchByUserIdGroupId_Last(
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public gr.open.loglevelsmanager.loglevel.model.LogLevel[] findByUserIdGroupId_PrevAndNext(
		long LogLevelId, long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException;

	/**
	* Returns all the log levels that the user has permission to view where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @return the matching log levels that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<gr.open.loglevelsmanager.loglevel.model.LogLevel> filterFindByUserIdGroupId(
		long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<gr.open.loglevelsmanager.loglevel.model.LogLevel> filterFindByUserIdGroupId(
		long userId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<gr.open.loglevelsmanager.loglevel.model.LogLevel> filterFindByUserIdGroupId(
		long userId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public gr.open.loglevelsmanager.loglevel.model.LogLevel[] filterFindByUserIdGroupId_PrevAndNext(
		long LogLevelId, long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException;

	/**
	* Removes all the log levels where userId = &#63; and groupId = &#63; from the database.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserIdGroupId(long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of log levels where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @return the number of matching log levels
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserIdGroupId(long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of log levels that the user has permission to view where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @return the number of matching log levels that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByUserIdGroupId(long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the log levels where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching log levels
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<gr.open.loglevelsmanager.loglevel.model.LogLevel> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<gr.open.loglevelsmanager.loglevel.model.LogLevel> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<gr.open.loglevelsmanager.loglevel.model.LogLevel> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first log level in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching log level
	* @throws gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException if a matching log level could not be found
	* @throws SystemException if a system exception occurred
	*/
	public gr.open.loglevelsmanager.loglevel.model.LogLevel findByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException;

	/**
	* Returns the first log level in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching log level, or <code>null</code> if a matching log level could not be found
	* @throws SystemException if a system exception occurred
	*/
	public gr.open.loglevelsmanager.loglevel.model.LogLevel fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last log level in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching log level
	* @throws gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException if a matching log level could not be found
	* @throws SystemException if a system exception occurred
	*/
	public gr.open.loglevelsmanager.loglevel.model.LogLevel findByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException;

	/**
	* Returns the last log level in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching log level, or <code>null</code> if a matching log level could not be found
	* @throws SystemException if a system exception occurred
	*/
	public gr.open.loglevelsmanager.loglevel.model.LogLevel fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public gr.open.loglevelsmanager.loglevel.model.LogLevel[] findByUserId_PrevAndNext(
		long LogLevelId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException;

	/**
	* Removes all the log levels where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of log levels where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching log levels
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the log levels where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching log levels
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<gr.open.loglevelsmanager.loglevel.model.LogLevel> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<gr.open.loglevelsmanager.loglevel.model.LogLevel> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<gr.open.loglevelsmanager.loglevel.model.LogLevel> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first log level in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching log level
	* @throws gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException if a matching log level could not be found
	* @throws SystemException if a system exception occurred
	*/
	public gr.open.loglevelsmanager.loglevel.model.LogLevel findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException;

	/**
	* Returns the first log level in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching log level, or <code>null</code> if a matching log level could not be found
	* @throws SystemException if a system exception occurred
	*/
	public gr.open.loglevelsmanager.loglevel.model.LogLevel fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last log level in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching log level
	* @throws gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException if a matching log level could not be found
	* @throws SystemException if a system exception occurred
	*/
	public gr.open.loglevelsmanager.loglevel.model.LogLevel findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException;

	/**
	* Returns the last log level in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching log level, or <code>null</code> if a matching log level could not be found
	* @throws SystemException if a system exception occurred
	*/
	public gr.open.loglevelsmanager.loglevel.model.LogLevel fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public gr.open.loglevelsmanager.loglevel.model.LogLevel[] findByCompanyId_PrevAndNext(
		long LogLevelId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException;

	/**
	* Removes all the log levels where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of log levels where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching log levels
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the log levels where activateOnStartup = &#63;.
	*
	* @param activateOnStartup the activate on startup
	* @return the matching log levels
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<gr.open.loglevelsmanager.loglevel.model.LogLevel> findByActivateOnStartup(
		boolean activateOnStartup)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<gr.open.loglevelsmanager.loglevel.model.LogLevel> findByActivateOnStartup(
		boolean activateOnStartup, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<gr.open.loglevelsmanager.loglevel.model.LogLevel> findByActivateOnStartup(
		boolean activateOnStartup, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first log level in the ordered set where activateOnStartup = &#63;.
	*
	* @param activateOnStartup the activate on startup
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching log level
	* @throws gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException if a matching log level could not be found
	* @throws SystemException if a system exception occurred
	*/
	public gr.open.loglevelsmanager.loglevel.model.LogLevel findByActivateOnStartup_First(
		boolean activateOnStartup,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException;

	/**
	* Returns the first log level in the ordered set where activateOnStartup = &#63;.
	*
	* @param activateOnStartup the activate on startup
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching log level, or <code>null</code> if a matching log level could not be found
	* @throws SystemException if a system exception occurred
	*/
	public gr.open.loglevelsmanager.loglevel.model.LogLevel fetchByActivateOnStartup_First(
		boolean activateOnStartup,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last log level in the ordered set where activateOnStartup = &#63;.
	*
	* @param activateOnStartup the activate on startup
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching log level
	* @throws gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException if a matching log level could not be found
	* @throws SystemException if a system exception occurred
	*/
	public gr.open.loglevelsmanager.loglevel.model.LogLevel findByActivateOnStartup_Last(
		boolean activateOnStartup,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException;

	/**
	* Returns the last log level in the ordered set where activateOnStartup = &#63;.
	*
	* @param activateOnStartup the activate on startup
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching log level, or <code>null</code> if a matching log level could not be found
	* @throws SystemException if a system exception occurred
	*/
	public gr.open.loglevelsmanager.loglevel.model.LogLevel fetchByActivateOnStartup_Last(
		boolean activateOnStartup,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public gr.open.loglevelsmanager.loglevel.model.LogLevel[] findByActivateOnStartup_PrevAndNext(
		long LogLevelId, boolean activateOnStartup,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException;

	/**
	* Removes all the log levels where activateOnStartup = &#63; from the database.
	*
	* @param activateOnStartup the activate on startup
	* @throws SystemException if a system exception occurred
	*/
	public void removeByActivateOnStartup(boolean activateOnStartup)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of log levels where activateOnStartup = &#63;.
	*
	* @param activateOnStartup the activate on startup
	* @return the number of matching log levels
	* @throws SystemException if a system exception occurred
	*/
	public int countByActivateOnStartup(boolean activateOnStartup)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the log levels where logLevelScheduled = &#63;.
	*
	* @param logLevelScheduled the log level scheduled
	* @return the matching log levels
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<gr.open.loglevelsmanager.loglevel.model.LogLevel> findByScheduled(
		boolean logLevelScheduled)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<gr.open.loglevelsmanager.loglevel.model.LogLevel> findByScheduled(
		boolean logLevelScheduled, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<gr.open.loglevelsmanager.loglevel.model.LogLevel> findByScheduled(
		boolean logLevelScheduled, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first log level in the ordered set where logLevelScheduled = &#63;.
	*
	* @param logLevelScheduled the log level scheduled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching log level
	* @throws gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException if a matching log level could not be found
	* @throws SystemException if a system exception occurred
	*/
	public gr.open.loglevelsmanager.loglevel.model.LogLevel findByScheduled_First(
		boolean logLevelScheduled,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException;

	/**
	* Returns the first log level in the ordered set where logLevelScheduled = &#63;.
	*
	* @param logLevelScheduled the log level scheduled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching log level, or <code>null</code> if a matching log level could not be found
	* @throws SystemException if a system exception occurred
	*/
	public gr.open.loglevelsmanager.loglevel.model.LogLevel fetchByScheduled_First(
		boolean logLevelScheduled,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last log level in the ordered set where logLevelScheduled = &#63;.
	*
	* @param logLevelScheduled the log level scheduled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching log level
	* @throws gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException if a matching log level could not be found
	* @throws SystemException if a system exception occurred
	*/
	public gr.open.loglevelsmanager.loglevel.model.LogLevel findByScheduled_Last(
		boolean logLevelScheduled,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException;

	/**
	* Returns the last log level in the ordered set where logLevelScheduled = &#63;.
	*
	* @param logLevelScheduled the log level scheduled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching log level, or <code>null</code> if a matching log level could not be found
	* @throws SystemException if a system exception occurred
	*/
	public gr.open.loglevelsmanager.loglevel.model.LogLevel fetchByScheduled_Last(
		boolean logLevelScheduled,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public gr.open.loglevelsmanager.loglevel.model.LogLevel[] findByScheduled_PrevAndNext(
		long LogLevelId, boolean logLevelScheduled,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException;

	/**
	* Removes all the log levels where logLevelScheduled = &#63; from the database.
	*
	* @param logLevelScheduled the log level scheduled
	* @throws SystemException if a system exception occurred
	*/
	public void removeByScheduled(boolean logLevelScheduled)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of log levels where logLevelScheduled = &#63;.
	*
	* @param logLevelScheduled the log level scheduled
	* @return the number of matching log levels
	* @throws SystemException if a system exception occurred
	*/
	public int countByScheduled(boolean logLevelScheduled)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the log level in the entity cache if it is enabled.
	*
	* @param logLevel the log level
	*/
	public void cacheResult(
		gr.open.loglevelsmanager.loglevel.model.LogLevel logLevel);

	/**
	* Caches the log levels in the entity cache if it is enabled.
	*
	* @param logLevels the log levels
	*/
	public void cacheResult(
		java.util.List<gr.open.loglevelsmanager.loglevel.model.LogLevel> logLevels);

	/**
	* Creates a new log level with the primary key. Does not add the log level to the database.
	*
	* @param LogLevelId the primary key for the new log level
	* @return the new log level
	*/
	public gr.open.loglevelsmanager.loglevel.model.LogLevel create(
		long LogLevelId);

	/**
	* Removes the log level with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param LogLevelId the primary key of the log level
	* @return the log level that was removed
	* @throws gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException if a log level with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public gr.open.loglevelsmanager.loglevel.model.LogLevel remove(
		long LogLevelId)
		throws com.liferay.portal.kernel.exception.SystemException,
			gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException;

	public gr.open.loglevelsmanager.loglevel.model.LogLevel updateImpl(
		gr.open.loglevelsmanager.loglevel.model.LogLevel logLevel)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the log level with the primary key or throws a {@link gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException} if it could not be found.
	*
	* @param LogLevelId the primary key of the log level
	* @return the log level
	* @throws gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException if a log level with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public gr.open.loglevelsmanager.loglevel.model.LogLevel findByPrimaryKey(
		long LogLevelId)
		throws com.liferay.portal.kernel.exception.SystemException,
			gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException;

	/**
	* Returns the log level with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param LogLevelId the primary key of the log level
	* @return the log level, or <code>null</code> if a log level with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public gr.open.loglevelsmanager.loglevel.model.LogLevel fetchByPrimaryKey(
		long LogLevelId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the log levels.
	*
	* @return the log levels
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<gr.open.loglevelsmanager.loglevel.model.LogLevel> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<gr.open.loglevelsmanager.loglevel.model.LogLevel> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<gr.open.loglevelsmanager.loglevel.model.LogLevel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the log levels from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of log levels.
	*
	* @return the number of log levels
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}