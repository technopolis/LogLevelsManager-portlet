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

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import gr.open.loglevelsmanager.loglevel.model.LogLevel;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.portlet.ActionRequest;

public class LogLevelValidator {

	public static boolean validateEditLogLevel(String rowsPerPage, String dateFormat, String datetimeFormat, List errors) {

		boolean valid = true;
		if (Validator.isNull(rowsPerPage)) {
			errors.add("rows-per-page-required");
			valid = false;
		}
		else if (!Validator.isNumber(rowsPerPage)) {
			errors.add("rows-per-page-invalid");
			valid = false;
		}
		else if (Validator.isNull(dateFormat)) {
			errors.add("date-format-required");
			valid = false;
		}
		else if (Validator.isNull(datetimeFormat)) {
			errors.add("datetime-format.required");
			valid = false;
		}
		return valid;
	}

	public static ArrayList<String> validateLogLevel(LogLevel logLevel, ActionRequest request)
		throws IOException {

		ArrayList<String> errors = new ArrayList<String>();
		Properties props = new Properties();
		ClassLoader classLoader = LogLevelValidator.class.getClassLoader();
		InputStream is = classLoader.getResourceAsStream("regexp.properties");
		props.load(is);

		// Field LogLevelDescription

		if (!validateLogLevelDescription(props, ParamUtil.getString(request, "LogLevelDescription"))) {
			errors.add("error");
		}
		if (Validator.isNull(logLevel.getLogLevelDescription())) {
			errors.add("loglevel-logleveldescription-required");
		}

		// Field LogLevelPriority

		if (!validateLogLevelPriority(props, ParamUtil.getString(request, "LogLevelPriority"))) {
			errors.add("error");
		}
		if (Validator.isNull(logLevel.getLogLevelPriority())) {
			errors.add("loglevel-loglevelpriority-required");
		}
		return errors;
	}

	// Field LogLevelDescription
	private static boolean validateLogLevelDescription(Properties props, String field) {

		boolean valid = true;
		return valid;
	}

	// Field LogLevelId
	private static boolean validateLogLevelId(Properties props, String field) {

		boolean valid = true;
		try {
			Double.parseDouble(field);
		}
		catch (NumberFormatException nfe) {
			valid = false;
		}
		return valid;
	}

	// Field LogLevelPriority
	private static boolean validateLogLevelPriority(Properties props, String field) {

		boolean valid = true;
		return valid;
	}
}
