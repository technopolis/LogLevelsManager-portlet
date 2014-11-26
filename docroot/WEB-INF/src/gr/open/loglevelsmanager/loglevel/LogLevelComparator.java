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

package gr.open.loglevelsmanager.loglevel;

import com.liferay.portal.kernel.util.OrderByComparator;

public class LogLevelComparator {

	public static String ORDER_BY_ASC = " ASC";
	public static String ORDER_BY_DESC = " DESC";

	public static OrderByComparator getLogLevelOrderByComparator(String orderByCol, String orderByType) {

		boolean orderByAsc = false;
		if (orderByType == null) {
			orderByAsc = true;
		}
		else if (orderByType.trim().equalsIgnoreCase(ORDER_BY_ASC.trim())) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;
		if (orderByCol == null) {
			orderByComparator = new OrderByLogLevelLogLevelId(orderByAsc);
		}
		else if (orderByCol.equals("LogLevelId")) {
			orderByComparator = new OrderByLogLevelLogLevelId(orderByAsc);
		}
		else if (orderByCol.equals("LogLevelDescription")) {
			orderByComparator = new OrderByLogLevelLogLevelDescription(orderByAsc);
		}
		else if (orderByCol.equals("LogLevelPriority")) {
			orderByComparator = new OrderByLogLevelLogLevelPriority(orderByAsc);
		}
		return orderByComparator;
	}
}

class OrderByLogLevelLogLevelDescription extends OrderByComparator {

	public static String ORDER_BY_FIELD = "LogLevelDescription";

	private boolean _asc;

	public OrderByLogLevelLogLevelDescription() {

		this(false);
	}

	public OrderByLogLevelLogLevelDescription(boolean asc) {

		_asc = asc;
	}

	@Override
	public int compare(Object o1, Object o2) {

		String str1 = "";
		String str2 = "";

		if (str1 != null)
			str1 = (String) o1;
		if (str2 != null)
			str2 = (String) o1;

		return str1.compareTo(str2);
	}

	@Override
	public String getOrderBy() {

		if (_asc)
			return ORDER_BY_FIELD + LogLevelComparator.ORDER_BY_ASC;
		else
			return ORDER_BY_FIELD + LogLevelComparator.ORDER_BY_DESC;
	}

	@Override
	public String[] getOrderByFields() {

		String[] orderByFields = new String[1];
		orderByFields[0] = ORDER_BY_FIELD;
		return orderByFields;
	}
}

class OrderByLogLevelLogLevelId extends OrderByComparator {

	public static String ORDER_BY_FIELD = "LogLevelId";

	private boolean _asc;

	public OrderByLogLevelLogLevelId() {

		this(false);
	}

	public OrderByLogLevelLogLevelId(boolean asc) {

		_asc = asc;
	}

	@Override
	public int compare(Object o1, Object o2) {

		Long lo1 = 0L;
		Long lo2 = 0L;

		if (o1 != null)
			lo1 = (Long) o1;
		if (o2 != null)
			lo2 = (Long) o2;

		return lo1.compareTo(lo2);
	}

	@Override
	public String getOrderBy() {

		if (_asc)
			return ORDER_BY_FIELD + LogLevelComparator.ORDER_BY_ASC;
		else
			return ORDER_BY_FIELD + LogLevelComparator.ORDER_BY_DESC;
	}

	@Override
	public String[] getOrderByFields() {

		String[] orderByFields = new String[1];
		orderByFields[0] = ORDER_BY_FIELD;
		return orderByFields;
	}
}

class OrderByLogLevelLogLevelPriority extends OrderByComparator {

	public static String ORDER_BY_FIELD = "LogLevelPriority";

	private boolean _asc;

	public OrderByLogLevelLogLevelPriority() {

		this(false);
	}

	public OrderByLogLevelLogLevelPriority(boolean asc) {

		_asc = asc;
	}

	@Override
	public int compare(Object o1, Object o2) {

		String str1 = "";
		String str2 = "";

		if (str1 != null)
			str1 = (String) o1;
		if (str2 != null)
			str2 = (String) o1;

		return str1.compareTo(str2);
	}

	@Override
	public String getOrderBy() {

		if (_asc)
			return ORDER_BY_FIELD + LogLevelComparator.ORDER_BY_ASC;
		else
			return ORDER_BY_FIELD + LogLevelComparator.ORDER_BY_DESC;
	}

	@Override
	public String[] getOrderByFields() {

		String[] orderByFields = new String[1];
		orderByFields[0] = ORDER_BY_FIELD;
		return orderByFields;
	}
}
