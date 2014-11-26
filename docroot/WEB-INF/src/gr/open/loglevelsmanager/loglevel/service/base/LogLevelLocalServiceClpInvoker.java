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

package gr.open.loglevelsmanager.loglevel.service.base;

import gr.open.loglevelsmanager.loglevel.service.LogLevelLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Jack A. Rider
 * @generated
 */
public class LogLevelLocalServiceClpInvoker {
	public LogLevelLocalServiceClpInvoker() {
		_methodName0 = "addLogLevel";

		_methodParameterTypes0 = new String[] {
				"gr.open.loglevelsmanager.loglevel.model.LogLevel"
			};

		_methodName1 = "createLogLevel";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteLogLevel";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteLogLevel";

		_methodParameterTypes3 = new String[] {
				"gr.open.loglevelsmanager.loglevel.model.LogLevel"
			};

		_methodName4 = "dynamicQuery";

		_methodParameterTypes4 = new String[] {  };

		_methodName5 = "dynamicQuery";

		_methodParameterTypes5 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName6 = "dynamicQuery";

		_methodParameterTypes6 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
			};

		_methodName7 = "dynamicQuery";

		_methodParameterTypes7 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName8 = "dynamicQueryCount";

		_methodParameterTypes8 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName9 = "dynamicQueryCount";

		_methodParameterTypes9 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery",
				"com.liferay.portal.kernel.dao.orm.Projection"
			};

		_methodName10 = "fetchLogLevel";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getLogLevel";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getLogLevels";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getLogLevelsCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateLogLevel";

		_methodParameterTypes15 = new String[] {
				"gr.open.loglevelsmanager.loglevel.model.LogLevel"
			};

		_methodName32 = "getBeanIdentifier";

		_methodParameterTypes32 = new String[] {  };

		_methodName33 = "setBeanIdentifier";

		_methodParameterTypes33 = new String[] { "java.lang.String" };

		_methodName39 = "addEntryResources";

		_methodParameterTypes39 = new String[] {
				"gr.open.loglevelsmanager.loglevel.model.LogLevel", "boolean",
				"boolean"
			};

		_methodName40 = "addEntryResources";

		_methodParameterTypes40 = new String[] {
				"gr.open.loglevelsmanager.loglevel.model.LogLevel",
				"java.lang.String[][]", "java.lang.String[][]"
			};

		_methodName41 = "addEntryResources";

		_methodParameterTypes41 = new String[] { "long", "boolean", "boolean" };

		_methodName42 = "addEntryResources";

		_methodParameterTypes42 = new String[] {
				"long", "java.lang.String[][]", "java.lang.String[][]"
			};

		_methodName43 = "addLogLevel";

		_methodParameterTypes43 = new String[] {
				"gr.open.loglevelsmanager.loglevel.model.LogLevel",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName44 = "countAllInGroup";

		_methodParameterTypes44 = new String[] { "long" };

		_methodName45 = "countAllInUser";

		_methodParameterTypes45 = new String[] { "long" };

		_methodName46 = "countAllInUserAndGroup";

		_methodParameterTypes46 = new String[] { "long", "long" };

		_methodName47 = "deleteLogLevelEntry";

		_methodParameterTypes47 = new String[] {
				"gr.open.loglevelsmanager.loglevel.model.LogLevel"
			};

		_methodName48 = "findAllInGroup";

		_methodParameterTypes48 = new String[] { "long" };

		_methodName49 = "findAllInGroup";

		_methodParameterTypes49 = new String[] {
				"long", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName50 = "findAllInGroup";

		_methodParameterTypes50 = new String[] {
				"long", "com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName51 = "findAllInUser";

		_methodParameterTypes51 = new String[] { "long" };

		_methodName52 = "findAllInUser";

		_methodParameterTypes52 = new String[] {
				"long", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName53 = "findAllInUser";

		_methodParameterTypes53 = new String[] {
				"long", "com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName54 = "findAllInUserAndGroup";

		_methodParameterTypes54 = new String[] { "long", "long" };

		_methodName55 = "findAllInUserAndGroup";

		_methodParameterTypes55 = new String[] {
				"long", "long", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName56 = "findAllInUserAndGroup";

		_methodParameterTypes56 = new String[] {
				"long", "long",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName57 = "getByActivateOnStartup";

		_methodParameterTypes57 = new String[] { "boolean" };

		_methodName58 = "getByScheduled";

		_methodParameterTypes58 = new String[] { "boolean" };

		_methodName59 = "getCompanyEntries";

		_methodParameterTypes59 = new String[] { "long", "int", "int" };

		_methodName60 = "getCompanyEntries";

		_methodParameterTypes60 = new String[] {
				"long", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName61 = "getCompanyEntriesCount";

		_methodParameterTypes61 = new String[] { "long" };

		_methodName62 = "updateEntryResources";

		_methodParameterTypes62 = new String[] {
				"gr.open.loglevelsmanager.loglevel.model.LogLevel",
				"java.lang.String[][]", "java.lang.String[][]"
			};

		_methodName63 = "updateLogLevel";

		_methodParameterTypes63 = new String[] {
				"gr.open.loglevelsmanager.loglevel.model.LogLevel",
				"com.liferay.portal.service.ServiceContext"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return LogLevelLocalServiceUtil.addLogLevel((gr.open.loglevelsmanager.loglevel.model.LogLevel)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return LogLevelLocalServiceUtil.createLogLevel(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return LogLevelLocalServiceUtil.deleteLogLevel(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return LogLevelLocalServiceUtil.deleteLogLevel((gr.open.loglevelsmanager.loglevel.model.LogLevel)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return LogLevelLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return LogLevelLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return LogLevelLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return LogLevelLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return LogLevelLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return LogLevelLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return LogLevelLocalServiceUtil.fetchLogLevel(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return LogLevelLocalServiceUtil.getLogLevel(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return LogLevelLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return LogLevelLocalServiceUtil.getLogLevels(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return LogLevelLocalServiceUtil.getLogLevelsCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return LogLevelLocalServiceUtil.updateLogLevel((gr.open.loglevelsmanager.loglevel.model.LogLevel)arguments[0]);
		}

		if (_methodName32.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes32, parameterTypes)) {
			return LogLevelLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName33.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes33, parameterTypes)) {
			LogLevelLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName39.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes39, parameterTypes)) {
			LogLevelLocalServiceUtil.addEntryResources((gr.open.loglevelsmanager.loglevel.model.LogLevel)arguments[0],
				((Boolean)arguments[1]).booleanValue(),
				((Boolean)arguments[2]).booleanValue());

			return null;
		}

		if (_methodName40.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes40, parameterTypes)) {
			LogLevelLocalServiceUtil.addEntryResources((gr.open.loglevelsmanager.loglevel.model.LogLevel)arguments[0],
				(java.lang.String[])arguments[1],
				(java.lang.String[])arguments[2]);

			return null;
		}

		if (_methodName41.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes41, parameterTypes)) {
			LogLevelLocalServiceUtil.addEntryResources(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				((Boolean)arguments[2]).booleanValue());

			return null;
		}

		if (_methodName42.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes42, parameterTypes)) {
			LogLevelLocalServiceUtil.addEntryResources(((Long)arguments[0]).longValue(),
				(java.lang.String[])arguments[1],
				(java.lang.String[])arguments[2]);

			return null;
		}

		if (_methodName43.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes43, parameterTypes)) {
			return LogLevelLocalServiceUtil.addLogLevel((gr.open.loglevelsmanager.loglevel.model.LogLevel)arguments[0],
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName44.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes44, parameterTypes)) {
			return LogLevelLocalServiceUtil.countAllInGroup(((Long)arguments[0]).longValue());
		}

		if (_methodName45.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes45, parameterTypes)) {
			return LogLevelLocalServiceUtil.countAllInUser(((Long)arguments[0]).longValue());
		}

		if (_methodName46.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes46, parameterTypes)) {
			return LogLevelLocalServiceUtil.countAllInUserAndGroup(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName47.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes47, parameterTypes)) {
			LogLevelLocalServiceUtil.deleteLogLevelEntry((gr.open.loglevelsmanager.loglevel.model.LogLevel)arguments[0]);

			return null;
		}

		if (_methodName48.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes48, parameterTypes)) {
			return LogLevelLocalServiceUtil.findAllInGroup(((Long)arguments[0]).longValue());
		}

		if (_methodName49.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes49, parameterTypes)) {
			return LogLevelLocalServiceUtil.findAllInGroup(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName50.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes50, parameterTypes)) {
			return LogLevelLocalServiceUtil.findAllInGroup(((Long)arguments[0]).longValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[1]);
		}

		if (_methodName51.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes51, parameterTypes)) {
			return LogLevelLocalServiceUtil.findAllInUser(((Long)arguments[0]).longValue());
		}

		if (_methodName52.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes52, parameterTypes)) {
			return LogLevelLocalServiceUtil.findAllInUser(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName53.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes53, parameterTypes)) {
			return LogLevelLocalServiceUtil.findAllInUser(((Long)arguments[0]).longValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[1]);
		}

		if (_methodName54.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes54, parameterTypes)) {
			return LogLevelLocalServiceUtil.findAllInUserAndGroup(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName55.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes55, parameterTypes)) {
			return LogLevelLocalServiceUtil.findAllInUserAndGroup(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[4]);
		}

		if (_methodName56.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes56, parameterTypes)) {
			return LogLevelLocalServiceUtil.findAllInUserAndGroup(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[2]);
		}

		if (_methodName57.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes57, parameterTypes)) {
			return LogLevelLocalServiceUtil.getByActivateOnStartup(((Boolean)arguments[0]).booleanValue());
		}

		if (_methodName58.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes58, parameterTypes)) {
			return LogLevelLocalServiceUtil.getByScheduled(((Boolean)arguments[0]).booleanValue());
		}

		if (_methodName59.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes59, parameterTypes)) {
			return LogLevelLocalServiceUtil.getCompanyEntries(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName60.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes60, parameterTypes)) {
			return LogLevelLocalServiceUtil.getCompanyEntries(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName61.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes61, parameterTypes)) {
			return LogLevelLocalServiceUtil.getCompanyEntriesCount(((Long)arguments[0]).longValue());
		}

		if (_methodName62.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes62, parameterTypes)) {
			LogLevelLocalServiceUtil.updateEntryResources((gr.open.loglevelsmanager.loglevel.model.LogLevel)arguments[0],
				(java.lang.String[])arguments[1],
				(java.lang.String[])arguments[2]);

			return null;
		}

		if (_methodName63.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes63, parameterTypes)) {
			return LogLevelLocalServiceUtil.updateLogLevel((gr.open.loglevelsmanager.loglevel.model.LogLevel)arguments[0],
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName2;
	private String[] _methodParameterTypes2;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
	private String _methodName9;
	private String[] _methodParameterTypes9;
	private String _methodName10;
	private String[] _methodParameterTypes10;
	private String _methodName11;
	private String[] _methodParameterTypes11;
	private String _methodName12;
	private String[] _methodParameterTypes12;
	private String _methodName13;
	private String[] _methodParameterTypes13;
	private String _methodName14;
	private String[] _methodParameterTypes14;
	private String _methodName15;
	private String[] _methodParameterTypes15;
	private String _methodName32;
	private String[] _methodParameterTypes32;
	private String _methodName33;
	private String[] _methodParameterTypes33;
	private String _methodName39;
	private String[] _methodParameterTypes39;
	private String _methodName40;
	private String[] _methodParameterTypes40;
	private String _methodName41;
	private String[] _methodParameterTypes41;
	private String _methodName42;
	private String[] _methodParameterTypes42;
	private String _methodName43;
	private String[] _methodParameterTypes43;
	private String _methodName44;
	private String[] _methodParameterTypes44;
	private String _methodName45;
	private String[] _methodParameterTypes45;
	private String _methodName46;
	private String[] _methodParameterTypes46;
	private String _methodName47;
	private String[] _methodParameterTypes47;
	private String _methodName48;
	private String[] _methodParameterTypes48;
	private String _methodName49;
	private String[] _methodParameterTypes49;
	private String _methodName50;
	private String[] _methodParameterTypes50;
	private String _methodName51;
	private String[] _methodParameterTypes51;
	private String _methodName52;
	private String[] _methodParameterTypes52;
	private String _methodName53;
	private String[] _methodParameterTypes53;
	private String _methodName54;
	private String[] _methodParameterTypes54;
	private String _methodName55;
	private String[] _methodParameterTypes55;
	private String _methodName56;
	private String[] _methodParameterTypes56;
	private String _methodName57;
	private String[] _methodParameterTypes57;
	private String _methodName58;
	private String[] _methodParameterTypes58;
	private String _methodName59;
	private String[] _methodParameterTypes59;
	private String _methodName60;
	private String[] _methodParameterTypes60;
	private String _methodName61;
	private String[] _methodParameterTypes61;
	private String _methodName62;
	private String[] _methodParameterTypes62;
	private String _methodName63;
	private String[] _methodParameterTypes63;
}