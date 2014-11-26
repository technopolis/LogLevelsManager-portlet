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

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException;
import gr.open.loglevelsmanager.loglevel.model.LogLevel;
import gr.open.loglevelsmanager.loglevel.model.impl.LogLevelImpl;
import gr.open.loglevelsmanager.loglevel.model.impl.LogLevelModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the log level service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jack A. Rider
 * @see LogLevelPersistence
 * @see LogLevelUtil
 * @generated
 */
public class LogLevelPersistenceImpl extends BasePersistenceImpl<LogLevel>
	implements LogLevelPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LogLevelUtil} to access the log level persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LogLevelImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LogLevelModelImpl.ENTITY_CACHE_ENABLED,
			LogLevelModelImpl.FINDER_CACHE_ENABLED, LogLevelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LogLevelModelImpl.ENTITY_CACHE_ENABLED,
			LogLevelModelImpl.FINDER_CACHE_ENABLED, LogLevelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LogLevelModelImpl.ENTITY_CACHE_ENABLED,
			LogLevelModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(LogLevelModelImpl.ENTITY_CACHE_ENABLED,
			LogLevelModelImpl.FINDER_CACHE_ENABLED, LogLevelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(LogLevelModelImpl.ENTITY_CACHE_ENABLED,
			LogLevelModelImpl.FINDER_CACHE_ENABLED, LogLevelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			LogLevelModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(LogLevelModelImpl.ENTITY_CACHE_ENABLED,
			LogLevelModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the log levels where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching log levels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LogLevel> findByGroupId(long groupId) throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<LogLevel> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
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
	@Override
	public List<LogLevel> findByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<LogLevel> list = (List<LogLevel>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LogLevel logLevel : list) {
				if ((groupId != logLevel.getGroupId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_LOGLEVEL_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LogLevelModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<LogLevel>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LogLevel>(list);
				}
				else {
					list = (List<LogLevel>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public LogLevel findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLogLevelException, SystemException {
		LogLevel logLevel = fetchByGroupId_First(groupId, orderByComparator);

		if (logLevel != null) {
			return logLevel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLogLevelException(msg.toString());
	}

	/**
	 * Returns the first log level in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching log level, or <code>null</code> if a matching log level could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LogLevel fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<LogLevel> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public LogLevel findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLogLevelException, SystemException {
		LogLevel logLevel = fetchByGroupId_Last(groupId, orderByComparator);

		if (logLevel != null) {
			return logLevel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLogLevelException(msg.toString());
	}

	/**
	 * Returns the last log level in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching log level, or <code>null</code> if a matching log level could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LogLevel fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<LogLevel> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public LogLevel[] findByGroupId_PrevAndNext(long LogLevelId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLogLevelException, SystemException {
		LogLevel logLevel = findByPrimaryKey(LogLevelId);

		Session session = null;

		try {
			session = openSession();

			LogLevel[] array = new LogLevelImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, logLevel, groupId,
					orderByComparator, true);

			array[1] = logLevel;

			array[2] = getByGroupId_PrevAndNext(session, logLevel, groupId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LogLevel getByGroupId_PrevAndNext(Session session,
		LogLevel logLevel, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LOGLEVEL_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(LogLevelModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(logLevel);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LogLevel> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the log levels that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching log levels that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LogLevel> filterFindByGroupId(long groupId)
		throws SystemException {
		return filterFindByGroupId(groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<LogLevel> filterFindByGroupId(long groupId, int start, int end)
		throws SystemException {
		return filterFindByGroupId(groupId, start, end, null);
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
	@Override
	public List<LogLevel> filterFindByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId(groupId, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(3 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_LOGLEVEL_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_LOGLEVEL_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_LOGLEVEL_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator, true);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(LogLevelModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(LogLevelModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				LogLevel.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, LogLevelImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, LogLevelImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<LogLevel>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
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
	@Override
	public LogLevel[] filterFindByGroupId_PrevAndNext(long LogLevelId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchLogLevelException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId_PrevAndNext(LogLevelId, groupId,
				orderByComparator);
		}

		LogLevel logLevel = findByPrimaryKey(LogLevelId);

		Session session = null;

		try {
			session = openSession();

			LogLevel[] array = new LogLevelImpl[3];

			array[0] = filterGetByGroupId_PrevAndNext(session, logLevel,
					groupId, orderByComparator, true);

			array[1] = logLevel;

			array[2] = filterGetByGroupId_PrevAndNext(session, logLevel,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LogLevel filterGetByGroupId_PrevAndNext(Session session,
		LogLevel logLevel, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_LOGLEVEL_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_LOGLEVEL_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_LOGLEVEL_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(LogLevelModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(LogLevelModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				LogLevel.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, LogLevelImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, LogLevelImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(logLevel);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LogLevel> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the log levels where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (LogLevel logLevel : findByGroupId(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(logLevel);
		}
	}

	/**
	 * Returns the number of log levels where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching log levels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupId(long groupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LOGLEVEL_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of log levels that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching log levels that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByGroupId(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_LOGLEVEL_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				LogLevel.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "logLevel.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDGROUPID =
		new FinderPath(LogLevelModelImpl.ENTITY_CACHE_ENABLED,
			LogLevelModelImpl.FINDER_CACHE_ENABLED, LogLevelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserIdGroupId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDGROUPID =
		new FinderPath(LogLevelModelImpl.ENTITY_CACHE_ENABLED,
			LogLevelModelImpl.FINDER_CACHE_ENABLED, LogLevelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserIdGroupId",
			new String[] { Long.class.getName(), Long.class.getName() },
			LogLevelModelImpl.USERID_COLUMN_BITMASK |
			LogLevelModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERIDGROUPID = new FinderPath(LogLevelModelImpl.ENTITY_CACHE_ENABLED,
			LogLevelModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserIdGroupId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the log levels where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the matching log levels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LogLevel> findByUserIdGroupId(long userId, long groupId)
		throws SystemException {
		return findByUserIdGroupId(userId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<LogLevel> findByUserIdGroupId(long userId, long groupId,
		int start, int end) throws SystemException {
		return findByUserIdGroupId(userId, groupId, start, end, null);
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
	@Override
	public List<LogLevel> findByUserIdGroupId(long userId, long groupId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDGROUPID;
			finderArgs = new Object[] { userId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDGROUPID;
			finderArgs = new Object[] {
					userId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<LogLevel> list = (List<LogLevel>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LogLevel logLevel : list) {
				if ((userId != logLevel.getUserId()) ||
						(groupId != logLevel.getGroupId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_LOGLEVEL_WHERE);

			query.append(_FINDER_COLUMN_USERIDGROUPID_USERID_2);

			query.append(_FINDER_COLUMN_USERIDGROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LogLevelModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<LogLevel>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LogLevel>(list);
				}
				else {
					list = (List<LogLevel>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public LogLevel findByUserIdGroupId_First(long userId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLogLevelException, SystemException {
		LogLevel logLevel = fetchByUserIdGroupId_First(userId, groupId,
				orderByComparator);

		if (logLevel != null) {
			return logLevel;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLogLevelException(msg.toString());
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
	@Override
	public LogLevel fetchByUserIdGroupId_First(long userId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<LogLevel> list = findByUserIdGroupId(userId, groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public LogLevel findByUserIdGroupId_Last(long userId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLogLevelException, SystemException {
		LogLevel logLevel = fetchByUserIdGroupId_Last(userId, groupId,
				orderByComparator);

		if (logLevel != null) {
			return logLevel;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLogLevelException(msg.toString());
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
	@Override
	public LogLevel fetchByUserIdGroupId_Last(long userId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserIdGroupId(userId, groupId);

		if (count == 0) {
			return null;
		}

		List<LogLevel> list = findByUserIdGroupId(userId, groupId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public LogLevel[] findByUserIdGroupId_PrevAndNext(long LogLevelId,
		long userId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchLogLevelException, SystemException {
		LogLevel logLevel = findByPrimaryKey(LogLevelId);

		Session session = null;

		try {
			session = openSession();

			LogLevel[] array = new LogLevelImpl[3];

			array[0] = getByUserIdGroupId_PrevAndNext(session, logLevel,
					userId, groupId, orderByComparator, true);

			array[1] = logLevel;

			array[2] = getByUserIdGroupId_PrevAndNext(session, logLevel,
					userId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LogLevel getByUserIdGroupId_PrevAndNext(Session session,
		LogLevel logLevel, long userId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LOGLEVEL_WHERE);

		query.append(_FINDER_COLUMN_USERIDGROUPID_USERID_2);

		query.append(_FINDER_COLUMN_USERIDGROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(LogLevelModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(logLevel);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LogLevel> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the log levels that the user has permission to view where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the matching log levels that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LogLevel> filterFindByUserIdGroupId(long userId, long groupId)
		throws SystemException {
		return filterFindByUserIdGroupId(userId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<LogLevel> filterFindByUserIdGroupId(long userId, long groupId,
		int start, int end) throws SystemException {
		return filterFindByUserIdGroupId(userId, groupId, start, end, null);
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
	@Override
	public List<LogLevel> filterFindByUserIdGroupId(long userId, long groupId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByUserIdGroupId(userId, groupId, start, end,
				orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_LOGLEVEL_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_LOGLEVEL_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_USERIDGROUPID_USERID_2);

		query.append(_FINDER_COLUMN_USERIDGROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_LOGLEVEL_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator, true);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(LogLevelModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(LogLevelModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				LogLevel.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, LogLevelImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, LogLevelImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(userId);

			qPos.add(groupId);

			return (List<LogLevel>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
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
	@Override
	public LogLevel[] filterFindByUserIdGroupId_PrevAndNext(long LogLevelId,
		long userId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchLogLevelException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByUserIdGroupId_PrevAndNext(LogLevelId, userId, groupId,
				orderByComparator);
		}

		LogLevel logLevel = findByPrimaryKey(LogLevelId);

		Session session = null;

		try {
			session = openSession();

			LogLevel[] array = new LogLevelImpl[3];

			array[0] = filterGetByUserIdGroupId_PrevAndNext(session, logLevel,
					userId, groupId, orderByComparator, true);

			array[1] = logLevel;

			array[2] = filterGetByUserIdGroupId_PrevAndNext(session, logLevel,
					userId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LogLevel filterGetByUserIdGroupId_PrevAndNext(Session session,
		LogLevel logLevel, long userId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_LOGLEVEL_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_LOGLEVEL_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_USERIDGROUPID_USERID_2);

		query.append(_FINDER_COLUMN_USERIDGROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_LOGLEVEL_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(LogLevelModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(LogLevelModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				LogLevel.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, LogLevelImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, LogLevelImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(logLevel);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LogLevel> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the log levels where userId = &#63; and groupId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserIdGroupId(long userId, long groupId)
		throws SystemException {
		for (LogLevel logLevel : findByUserIdGroupId(userId, groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(logLevel);
		}
	}

	/**
	 * Returns the number of log levels where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the number of matching log levels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserIdGroupId(long userId, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERIDGROUPID;

		Object[] finderArgs = new Object[] { userId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LOGLEVEL_WHERE);

			query.append(_FINDER_COLUMN_USERIDGROUPID_USERID_2);

			query.append(_FINDER_COLUMN_USERIDGROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of log levels that the user has permission to view where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the number of matching log levels that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByUserIdGroupId(long userId, long groupId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByUserIdGroupId(userId, groupId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_LOGLEVEL_WHERE);

		query.append(_FINDER_COLUMN_USERIDGROUPID_USERID_2);

		query.append(_FINDER_COLUMN_USERIDGROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				LogLevel.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(userId);

			qPos.add(groupId);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_USERIDGROUPID_USERID_2 = "logLevel.userId = ? AND ";
	private static final String _FINDER_COLUMN_USERIDGROUPID_GROUPID_2 = "logLevel.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(LogLevelModelImpl.ENTITY_CACHE_ENABLED,
			LogLevelModelImpl.FINDER_CACHE_ENABLED, LogLevelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(LogLevelModelImpl.ENTITY_CACHE_ENABLED,
			LogLevelModelImpl.FINDER_CACHE_ENABLED, LogLevelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] { Long.class.getName() },
			LogLevelModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(LogLevelModelImpl.ENTITY_CACHE_ENABLED,
			LogLevelModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the log levels where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching log levels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LogLevel> findByUserId(long userId) throws SystemException {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<LogLevel> findByUserId(long userId, int start, int end)
		throws SystemException {
		return findByUserId(userId, start, end, null);
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
	@Override
	public List<LogLevel> findByUserId(long userId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<LogLevel> list = (List<LogLevel>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LogLevel logLevel : list) {
				if ((userId != logLevel.getUserId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_LOGLEVEL_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LogLevelModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<LogLevel>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LogLevel>(list);
				}
				else {
					list = (List<LogLevel>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public LogLevel findByUserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchLogLevelException, SystemException {
		LogLevel logLevel = fetchByUserId_First(userId, orderByComparator);

		if (logLevel != null) {
			return logLevel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLogLevelException(msg.toString());
	}

	/**
	 * Returns the first log level in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching log level, or <code>null</code> if a matching log level could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LogLevel fetchByUserId_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<LogLevel> list = findByUserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public LogLevel findByUserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchLogLevelException, SystemException {
		LogLevel logLevel = fetchByUserId_Last(userId, orderByComparator);

		if (logLevel != null) {
			return logLevel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLogLevelException(msg.toString());
	}

	/**
	 * Returns the last log level in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching log level, or <code>null</code> if a matching log level could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LogLevel fetchByUserId_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<LogLevel> list = findByUserId(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public LogLevel[] findByUserId_PrevAndNext(long LogLevelId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchLogLevelException, SystemException {
		LogLevel logLevel = findByPrimaryKey(LogLevelId);

		Session session = null;

		try {
			session = openSession();

			LogLevel[] array = new LogLevelImpl[3];

			array[0] = getByUserId_PrevAndNext(session, logLevel, userId,
					orderByComparator, true);

			array[1] = logLevel;

			array[2] = getByUserId_PrevAndNext(session, logLevel, userId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LogLevel getByUserId_PrevAndNext(Session session,
		LogLevel logLevel, long userId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LOGLEVEL_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(LogLevelModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(logLevel);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LogLevel> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the log levels where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserId(long userId) throws SystemException {
		for (LogLevel logLevel : findByUserId(userId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(logLevel);
		}
	}

	/**
	 * Returns the number of log levels where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching log levels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserId(long userId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LOGLEVEL_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "logLevel.userId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(LogLevelModelImpl.ENTITY_CACHE_ENABLED,
			LogLevelModelImpl.FINDER_CACHE_ENABLED, LogLevelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(LogLevelModelImpl.ENTITY_CACHE_ENABLED,
			LogLevelModelImpl.FINDER_CACHE_ENABLED, LogLevelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
			new String[] { Long.class.getName() },
			LogLevelModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(LogLevelModelImpl.ENTITY_CACHE_ENABLED,
			LogLevelModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the log levels where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching log levels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LogLevel> findByCompanyId(long companyId)
		throws SystemException {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<LogLevel> findByCompanyId(long companyId, int start, int end)
		throws SystemException {
		return findByCompanyId(companyId, start, end, null);
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
	@Override
	public List<LogLevel> findByCompanyId(long companyId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID;
			finderArgs = new Object[] { companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID;
			finderArgs = new Object[] { companyId, start, end, orderByComparator };
		}

		List<LogLevel> list = (List<LogLevel>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LogLevel logLevel : list) {
				if ((companyId != logLevel.getCompanyId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_LOGLEVEL_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LogLevelModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<LogLevel>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LogLevel>(list);
				}
				else {
					list = (List<LogLevel>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public LogLevel findByCompanyId_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchLogLevelException, SystemException {
		LogLevel logLevel = fetchByCompanyId_First(companyId, orderByComparator);

		if (logLevel != null) {
			return logLevel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLogLevelException(msg.toString());
	}

	/**
	 * Returns the first log level in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching log level, or <code>null</code> if a matching log level could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LogLevel fetchByCompanyId_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<LogLevel> list = findByCompanyId(companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public LogLevel findByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchLogLevelException, SystemException {
		LogLevel logLevel = fetchByCompanyId_Last(companyId, orderByComparator);

		if (logLevel != null) {
			return logLevel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLogLevelException(msg.toString());
	}

	/**
	 * Returns the last log level in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching log level, or <code>null</code> if a matching log level could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LogLevel fetchByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompanyId(companyId);

		if (count == 0) {
			return null;
		}

		List<LogLevel> list = findByCompanyId(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public LogLevel[] findByCompanyId_PrevAndNext(long LogLevelId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchLogLevelException, SystemException {
		LogLevel logLevel = findByPrimaryKey(LogLevelId);

		Session session = null;

		try {
			session = openSession();

			LogLevel[] array = new LogLevelImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session, logLevel, companyId,
					orderByComparator, true);

			array[1] = logLevel;

			array[2] = getByCompanyId_PrevAndNext(session, logLevel, companyId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LogLevel getByCompanyId_PrevAndNext(Session session,
		LogLevel logLevel, long companyId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LOGLEVEL_WHERE);

		query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(LogLevelModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(logLevel);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LogLevel> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the log levels where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompanyId(long companyId) throws SystemException {
		for (LogLevel logLevel : findByCompanyId(companyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(logLevel);
		}
	}

	/**
	 * Returns the number of log levels where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching log levels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCompanyId(long companyId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPANYID;

		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LOGLEVEL_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "logLevel.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ACTIVATEONSTARTUP =
		new FinderPath(LogLevelModelImpl.ENTITY_CACHE_ENABLED,
			LogLevelModelImpl.FINDER_CACHE_ENABLED, LogLevelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByActivateOnStartup",
			new String[] {
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVATEONSTARTUP =
		new FinderPath(LogLevelModelImpl.ENTITY_CACHE_ENABLED,
			LogLevelModelImpl.FINDER_CACHE_ENABLED, LogLevelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByActivateOnStartup",
			new String[] { Boolean.class.getName() },
			LogLevelModelImpl.ACTIVATEONSTARTUP_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ACTIVATEONSTARTUP = new FinderPath(LogLevelModelImpl.ENTITY_CACHE_ENABLED,
			LogLevelModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByActivateOnStartup", new String[] { Boolean.class.getName() });

	/**
	 * Returns all the log levels where activateOnStartup = &#63;.
	 *
	 * @param activateOnStartup the activate on startup
	 * @return the matching log levels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LogLevel> findByActivateOnStartup(boolean activateOnStartup)
		throws SystemException {
		return findByActivateOnStartup(activateOnStartup, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<LogLevel> findByActivateOnStartup(boolean activateOnStartup,
		int start, int end) throws SystemException {
		return findByActivateOnStartup(activateOnStartup, start, end, null);
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
	@Override
	public List<LogLevel> findByActivateOnStartup(boolean activateOnStartup,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVATEONSTARTUP;
			finderArgs = new Object[] { activateOnStartup };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ACTIVATEONSTARTUP;
			finderArgs = new Object[] {
					activateOnStartup,
					
					start, end, orderByComparator
				};
		}

		List<LogLevel> list = (List<LogLevel>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LogLevel logLevel : list) {
				if ((activateOnStartup != logLevel.getActivateOnStartup())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_LOGLEVEL_WHERE);

			query.append(_FINDER_COLUMN_ACTIVATEONSTARTUP_ACTIVATEONSTARTUP_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LogLevelModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(activateOnStartup);

				if (!pagination) {
					list = (List<LogLevel>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LogLevel>(list);
				}
				else {
					list = (List<LogLevel>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public LogLevel findByActivateOnStartup_First(boolean activateOnStartup,
		OrderByComparator orderByComparator)
		throws NoSuchLogLevelException, SystemException {
		LogLevel logLevel = fetchByActivateOnStartup_First(activateOnStartup,
				orderByComparator);

		if (logLevel != null) {
			return logLevel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("activateOnStartup=");
		msg.append(activateOnStartup);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLogLevelException(msg.toString());
	}

	/**
	 * Returns the first log level in the ordered set where activateOnStartup = &#63;.
	 *
	 * @param activateOnStartup the activate on startup
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching log level, or <code>null</code> if a matching log level could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LogLevel fetchByActivateOnStartup_First(boolean activateOnStartup,
		OrderByComparator orderByComparator) throws SystemException {
		List<LogLevel> list = findByActivateOnStartup(activateOnStartup, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public LogLevel findByActivateOnStartup_Last(boolean activateOnStartup,
		OrderByComparator orderByComparator)
		throws NoSuchLogLevelException, SystemException {
		LogLevel logLevel = fetchByActivateOnStartup_Last(activateOnStartup,
				orderByComparator);

		if (logLevel != null) {
			return logLevel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("activateOnStartup=");
		msg.append(activateOnStartup);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLogLevelException(msg.toString());
	}

	/**
	 * Returns the last log level in the ordered set where activateOnStartup = &#63;.
	 *
	 * @param activateOnStartup the activate on startup
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching log level, or <code>null</code> if a matching log level could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LogLevel fetchByActivateOnStartup_Last(boolean activateOnStartup,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByActivateOnStartup(activateOnStartup);

		if (count == 0) {
			return null;
		}

		List<LogLevel> list = findByActivateOnStartup(activateOnStartup,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public LogLevel[] findByActivateOnStartup_PrevAndNext(long LogLevelId,
		boolean activateOnStartup, OrderByComparator orderByComparator)
		throws NoSuchLogLevelException, SystemException {
		LogLevel logLevel = findByPrimaryKey(LogLevelId);

		Session session = null;

		try {
			session = openSession();

			LogLevel[] array = new LogLevelImpl[3];

			array[0] = getByActivateOnStartup_PrevAndNext(session, logLevel,
					activateOnStartup, orderByComparator, true);

			array[1] = logLevel;

			array[2] = getByActivateOnStartup_PrevAndNext(session, logLevel,
					activateOnStartup, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LogLevel getByActivateOnStartup_PrevAndNext(Session session,
		LogLevel logLevel, boolean activateOnStartup,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LOGLEVEL_WHERE);

		query.append(_FINDER_COLUMN_ACTIVATEONSTARTUP_ACTIVATEONSTARTUP_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(LogLevelModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(activateOnStartup);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(logLevel);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LogLevel> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the log levels where activateOnStartup = &#63; from the database.
	 *
	 * @param activateOnStartup the activate on startup
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByActivateOnStartup(boolean activateOnStartup)
		throws SystemException {
		for (LogLevel logLevel : findByActivateOnStartup(activateOnStartup,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(logLevel);
		}
	}

	/**
	 * Returns the number of log levels where activateOnStartup = &#63;.
	 *
	 * @param activateOnStartup the activate on startup
	 * @return the number of matching log levels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByActivateOnStartup(boolean activateOnStartup)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ACTIVATEONSTARTUP;

		Object[] finderArgs = new Object[] { activateOnStartup };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LOGLEVEL_WHERE);

			query.append(_FINDER_COLUMN_ACTIVATEONSTARTUP_ACTIVATEONSTARTUP_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(activateOnStartup);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ACTIVATEONSTARTUP_ACTIVATEONSTARTUP_2 =
		"logLevel.activateOnStartup = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SCHEDULED =
		new FinderPath(LogLevelModelImpl.ENTITY_CACHE_ENABLED,
			LogLevelModelImpl.FINDER_CACHE_ENABLED, LogLevelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByScheduled",
			new String[] {
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCHEDULED =
		new FinderPath(LogLevelModelImpl.ENTITY_CACHE_ENABLED,
			LogLevelModelImpl.FINDER_CACHE_ENABLED, LogLevelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByScheduled",
			new String[] { Boolean.class.getName() },
			LogLevelModelImpl.LOGLEVELSCHEDULED_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SCHEDULED = new FinderPath(LogLevelModelImpl.ENTITY_CACHE_ENABLED,
			LogLevelModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByScheduled",
			new String[] { Boolean.class.getName() });

	/**
	 * Returns all the log levels where logLevelScheduled = &#63;.
	 *
	 * @param logLevelScheduled the log level scheduled
	 * @return the matching log levels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LogLevel> findByScheduled(boolean logLevelScheduled)
		throws SystemException {
		return findByScheduled(logLevelScheduled, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<LogLevel> findByScheduled(boolean logLevelScheduled, int start,
		int end) throws SystemException {
		return findByScheduled(logLevelScheduled, start, end, null);
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
	@Override
	public List<LogLevel> findByScheduled(boolean logLevelScheduled, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCHEDULED;
			finderArgs = new Object[] { logLevelScheduled };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SCHEDULED;
			finderArgs = new Object[] {
					logLevelScheduled,
					
					start, end, orderByComparator
				};
		}

		List<LogLevel> list = (List<LogLevel>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LogLevel logLevel : list) {
				if ((logLevelScheduled != logLevel.getLogLevelScheduled())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_LOGLEVEL_WHERE);

			query.append(_FINDER_COLUMN_SCHEDULED_LOGLEVELSCHEDULED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LogLevelModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(logLevelScheduled);

				if (!pagination) {
					list = (List<LogLevel>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LogLevel>(list);
				}
				else {
					list = (List<LogLevel>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public LogLevel findByScheduled_First(boolean logLevelScheduled,
		OrderByComparator orderByComparator)
		throws NoSuchLogLevelException, SystemException {
		LogLevel logLevel = fetchByScheduled_First(logLevelScheduled,
				orderByComparator);

		if (logLevel != null) {
			return logLevel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("logLevelScheduled=");
		msg.append(logLevelScheduled);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLogLevelException(msg.toString());
	}

	/**
	 * Returns the first log level in the ordered set where logLevelScheduled = &#63;.
	 *
	 * @param logLevelScheduled the log level scheduled
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching log level, or <code>null</code> if a matching log level could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LogLevel fetchByScheduled_First(boolean logLevelScheduled,
		OrderByComparator orderByComparator) throws SystemException {
		List<LogLevel> list = findByScheduled(logLevelScheduled, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public LogLevel findByScheduled_Last(boolean logLevelScheduled,
		OrderByComparator orderByComparator)
		throws NoSuchLogLevelException, SystemException {
		LogLevel logLevel = fetchByScheduled_Last(logLevelScheduled,
				orderByComparator);

		if (logLevel != null) {
			return logLevel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("logLevelScheduled=");
		msg.append(logLevelScheduled);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLogLevelException(msg.toString());
	}

	/**
	 * Returns the last log level in the ordered set where logLevelScheduled = &#63;.
	 *
	 * @param logLevelScheduled the log level scheduled
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching log level, or <code>null</code> if a matching log level could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LogLevel fetchByScheduled_Last(boolean logLevelScheduled,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByScheduled(logLevelScheduled);

		if (count == 0) {
			return null;
		}

		List<LogLevel> list = findByScheduled(logLevelScheduled, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public LogLevel[] findByScheduled_PrevAndNext(long LogLevelId,
		boolean logLevelScheduled, OrderByComparator orderByComparator)
		throws NoSuchLogLevelException, SystemException {
		LogLevel logLevel = findByPrimaryKey(LogLevelId);

		Session session = null;

		try {
			session = openSession();

			LogLevel[] array = new LogLevelImpl[3];

			array[0] = getByScheduled_PrevAndNext(session, logLevel,
					logLevelScheduled, orderByComparator, true);

			array[1] = logLevel;

			array[2] = getByScheduled_PrevAndNext(session, logLevel,
					logLevelScheduled, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LogLevel getByScheduled_PrevAndNext(Session session,
		LogLevel logLevel, boolean logLevelScheduled,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LOGLEVEL_WHERE);

		query.append(_FINDER_COLUMN_SCHEDULED_LOGLEVELSCHEDULED_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(LogLevelModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(logLevelScheduled);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(logLevel);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LogLevel> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the log levels where logLevelScheduled = &#63; from the database.
	 *
	 * @param logLevelScheduled the log level scheduled
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByScheduled(boolean logLevelScheduled)
		throws SystemException {
		for (LogLevel logLevel : findByScheduled(logLevelScheduled,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(logLevel);
		}
	}

	/**
	 * Returns the number of log levels where logLevelScheduled = &#63;.
	 *
	 * @param logLevelScheduled the log level scheduled
	 * @return the number of matching log levels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByScheduled(boolean logLevelScheduled)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SCHEDULED;

		Object[] finderArgs = new Object[] { logLevelScheduled };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LOGLEVEL_WHERE);

			query.append(_FINDER_COLUMN_SCHEDULED_LOGLEVELSCHEDULED_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(logLevelScheduled);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_SCHEDULED_LOGLEVELSCHEDULED_2 = "logLevel.logLevelScheduled = ?";

	public LogLevelPersistenceImpl() {
		setModelClass(LogLevel.class);
	}

	/**
	 * Caches the log level in the entity cache if it is enabled.
	 *
	 * @param logLevel the log level
	 */
	@Override
	public void cacheResult(LogLevel logLevel) {
		EntityCacheUtil.putResult(LogLevelModelImpl.ENTITY_CACHE_ENABLED,
			LogLevelImpl.class, logLevel.getPrimaryKey(), logLevel);

		logLevel.resetOriginalValues();
	}

	/**
	 * Caches the log levels in the entity cache if it is enabled.
	 *
	 * @param logLevels the log levels
	 */
	@Override
	public void cacheResult(List<LogLevel> logLevels) {
		for (LogLevel logLevel : logLevels) {
			if (EntityCacheUtil.getResult(
						LogLevelModelImpl.ENTITY_CACHE_ENABLED,
						LogLevelImpl.class, logLevel.getPrimaryKey()) == null) {
				cacheResult(logLevel);
			}
			else {
				logLevel.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all log levels.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LogLevelImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LogLevelImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the log level.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LogLevel logLevel) {
		EntityCacheUtil.removeResult(LogLevelModelImpl.ENTITY_CACHE_ENABLED,
			LogLevelImpl.class, logLevel.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LogLevel> logLevels) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LogLevel logLevel : logLevels) {
			EntityCacheUtil.removeResult(LogLevelModelImpl.ENTITY_CACHE_ENABLED,
				LogLevelImpl.class, logLevel.getPrimaryKey());
		}
	}

	/**
	 * Creates a new log level with the primary key. Does not add the log level to the database.
	 *
	 * @param LogLevelId the primary key for the new log level
	 * @return the new log level
	 */
	@Override
	public LogLevel create(long LogLevelId) {
		LogLevel logLevel = new LogLevelImpl();

		logLevel.setNew(true);
		logLevel.setPrimaryKey(LogLevelId);

		return logLevel;
	}

	/**
	 * Removes the log level with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param LogLevelId the primary key of the log level
	 * @return the log level that was removed
	 * @throws gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException if a log level with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LogLevel remove(long LogLevelId)
		throws NoSuchLogLevelException, SystemException {
		return remove((Serializable)LogLevelId);
	}

	/**
	 * Removes the log level with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the log level
	 * @return the log level that was removed
	 * @throws gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException if a log level with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LogLevel remove(Serializable primaryKey)
		throws NoSuchLogLevelException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LogLevel logLevel = (LogLevel)session.get(LogLevelImpl.class,
					primaryKey);

			if (logLevel == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLogLevelException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(logLevel);
		}
		catch (NoSuchLogLevelException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected LogLevel removeImpl(LogLevel logLevel) throws SystemException {
		logLevel = toUnwrappedModel(logLevel);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(logLevel)) {
				logLevel = (LogLevel)session.get(LogLevelImpl.class,
						logLevel.getPrimaryKeyObj());
			}

			if (logLevel != null) {
				session.delete(logLevel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (logLevel != null) {
			clearCache(logLevel);
		}

		return logLevel;
	}

	@Override
	public LogLevel updateImpl(
		gr.open.loglevelsmanager.loglevel.model.LogLevel logLevel)
		throws SystemException {
		logLevel = toUnwrappedModel(logLevel);

		boolean isNew = logLevel.isNew();

		LogLevelModelImpl logLevelModelImpl = (LogLevelModelImpl)logLevel;

		Session session = null;

		try {
			session = openSession();

			if (logLevel.isNew()) {
				session.save(logLevel);

				logLevel.setNew(false);
			}
			else {
				session.merge(logLevel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LogLevelModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((logLevelModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						logLevelModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { logLevelModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((logLevelModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDGROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						logLevelModelImpl.getOriginalUserId(),
						logLevelModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDGROUPID,
					args);

				args = new Object[] {
						logLevelModelImpl.getUserId(),
						logLevelModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDGROUPID,
					args);
			}

			if ((logLevelModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						logLevelModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { logLevelModelImpl.getUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}

			if ((logLevelModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						logLevelModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);

				args = new Object[] { logLevelModelImpl.getCompanyId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);
			}

			if ((logLevelModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVATEONSTARTUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						logLevelModelImpl.getOriginalActivateOnStartup()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACTIVATEONSTARTUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVATEONSTARTUP,
					args);

				args = new Object[] { logLevelModelImpl.getActivateOnStartup() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACTIVATEONSTARTUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVATEONSTARTUP,
					args);
			}

			if ((logLevelModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCHEDULED.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						logLevelModelImpl.getOriginalLogLevelScheduled()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SCHEDULED,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCHEDULED,
					args);

				args = new Object[] { logLevelModelImpl.getLogLevelScheduled() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SCHEDULED,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCHEDULED,
					args);
			}
		}

		EntityCacheUtil.putResult(LogLevelModelImpl.ENTITY_CACHE_ENABLED,
			LogLevelImpl.class, logLevel.getPrimaryKey(), logLevel);

		return logLevel;
	}

	protected LogLevel toUnwrappedModel(LogLevel logLevel) {
		if (logLevel instanceof LogLevelImpl) {
			return logLevel;
		}

		LogLevelImpl logLevelImpl = new LogLevelImpl();

		logLevelImpl.setNew(logLevel.isNew());
		logLevelImpl.setPrimaryKey(logLevel.getPrimaryKey());

		logLevelImpl.setLogLevelId(logLevel.getLogLevelId());
		logLevelImpl.setCompanyId(logLevel.getCompanyId());
		logLevelImpl.setGroupId(logLevel.getGroupId());
		logLevelImpl.setUserId(logLevel.getUserId());
		logLevelImpl.setUserName(logLevel.getUserName());
		logLevelImpl.setCreateDate(logLevel.getCreateDate());
		logLevelImpl.setModifiedDate(logLevel.getModifiedDate());
		logLevelImpl.setLogLevelDescription(logLevel.getLogLevelDescription());
		logLevelImpl.setLogLevelPriority(logLevel.getLogLevelPriority());
		logLevelImpl.setLogLevelCategory(logLevel.getLogLevelCategory());
		logLevelImpl.setLogLevelScheduled(logLevel.isLogLevelScheduled());
		logLevelImpl.setLogLevelStartDate(logLevel.getLogLevelStartDate());
		logLevelImpl.setLogLevelEndDate(logLevel.getLogLevelEndDate());
		logLevelImpl.setActivateOnStartup(logLevel.isActivateOnStartup());

		return logLevelImpl;
	}

	/**
	 * Returns the log level with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the log level
	 * @return the log level
	 * @throws gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException if a log level with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LogLevel findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLogLevelException, SystemException {
		LogLevel logLevel = fetchByPrimaryKey(primaryKey);

		if (logLevel == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLogLevelException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return logLevel;
	}

	/**
	 * Returns the log level with the primary key or throws a {@link gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException} if it could not be found.
	 *
	 * @param LogLevelId the primary key of the log level
	 * @return the log level
	 * @throws gr.open.loglevelsmanager.loglevel.NoSuchLogLevelException if a log level with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LogLevel findByPrimaryKey(long LogLevelId)
		throws NoSuchLogLevelException, SystemException {
		return findByPrimaryKey((Serializable)LogLevelId);
	}

	/**
	 * Returns the log level with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the log level
	 * @return the log level, or <code>null</code> if a log level with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LogLevel fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		LogLevel logLevel = (LogLevel)EntityCacheUtil.getResult(LogLevelModelImpl.ENTITY_CACHE_ENABLED,
				LogLevelImpl.class, primaryKey);

		if (logLevel == _nullLogLevel) {
			return null;
		}

		if (logLevel == null) {
			Session session = null;

			try {
				session = openSession();

				logLevel = (LogLevel)session.get(LogLevelImpl.class, primaryKey);

				if (logLevel != null) {
					cacheResult(logLevel);
				}
				else {
					EntityCacheUtil.putResult(LogLevelModelImpl.ENTITY_CACHE_ENABLED,
						LogLevelImpl.class, primaryKey, _nullLogLevel);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LogLevelModelImpl.ENTITY_CACHE_ENABLED,
					LogLevelImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return logLevel;
	}

	/**
	 * Returns the log level with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param LogLevelId the primary key of the log level
	 * @return the log level, or <code>null</code> if a log level with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LogLevel fetchByPrimaryKey(long LogLevelId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)LogLevelId);
	}

	/**
	 * Returns all the log levels.
	 *
	 * @return the log levels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LogLevel> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<LogLevel> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<LogLevel> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<LogLevel> list = (List<LogLevel>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LOGLEVEL);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LOGLEVEL;

				if (pagination) {
					sql = sql.concat(LogLevelModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LogLevel>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LogLevel>(list);
				}
				else {
					list = (List<LogLevel>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the log levels from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (LogLevel logLevel : findAll()) {
			remove(logLevel);
		}
	}

	/**
	 * Returns the number of log levels.
	 *
	 * @return the number of log levels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LOGLEVEL);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the log level persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.gr.open.loglevelsmanager.loglevel.model.LogLevel")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LogLevel>> listenersList = new ArrayList<ModelListener<LogLevel>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LogLevel>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(LogLevelImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LOGLEVEL = "SELECT logLevel FROM LogLevel logLevel";
	private static final String _SQL_SELECT_LOGLEVEL_WHERE = "SELECT logLevel FROM LogLevel logLevel WHERE ";
	private static final String _SQL_COUNT_LOGLEVEL = "SELECT COUNT(logLevel) FROM LogLevel logLevel";
	private static final String _SQL_COUNT_LOGLEVEL_WHERE = "SELECT COUNT(logLevel) FROM LogLevel logLevel WHERE ";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "logLevel.LogLevelId";
	private static final String _FILTER_SQL_SELECT_LOGLEVEL_WHERE = "SELECT DISTINCT {logLevel.*} FROM loglevel_LogLevel logLevel WHERE ";
	private static final String _FILTER_SQL_SELECT_LOGLEVEL_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {loglevel_LogLevel.*} FROM (SELECT DISTINCT logLevel.LogLevelId FROM loglevel_LogLevel logLevel WHERE ";
	private static final String _FILTER_SQL_SELECT_LOGLEVEL_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN loglevel_LogLevel ON TEMP_TABLE.LogLevelId = loglevel_LogLevel.LogLevelId";
	private static final String _FILTER_SQL_COUNT_LOGLEVEL_WHERE = "SELECT COUNT(DISTINCT logLevel.LogLevelId) AS COUNT_VALUE FROM loglevel_LogLevel logLevel WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "logLevel";
	private static final String _FILTER_ENTITY_TABLE = "loglevel_LogLevel";
	private static final String _ORDER_BY_ENTITY_ALIAS = "logLevel.";
	private static final String _ORDER_BY_ENTITY_TABLE = "loglevel_LogLevel.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LogLevel exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LogLevel exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LogLevelPersistenceImpl.class);
	private static LogLevel _nullLogLevel = new LogLevelImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LogLevel> toCacheModel() {
				return _nullLogLevelCacheModel;
			}
		};

	private static CacheModel<LogLevel> _nullLogLevelCacheModel = new CacheModel<LogLevel>() {
			@Override
			public LogLevel toEntityModel() {
				return _nullLogLevel;
			}
		};
}