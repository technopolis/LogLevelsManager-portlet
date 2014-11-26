
package gr.open.loglevelsmanager.loglevel.enums;

import com.liferay.portal.kernel.log.Log;

public enum Level {
	OFF("OFF", "default"), FATAL("FATAL", "danger"), ERROR("ERROR", "danger"), WARN("WARN", "warning"), INFO("INFO",
		"success"), DEBUG("DEBUG", "info");

	public static Level getLevel(Log log) {

		if (log.isDebugEnabled()) {
			return DEBUG;
		}
		else if (log.isErrorEnabled()) {
			return ERROR;
		}
		else if (log.isFatalEnabled()) {
			return FATAL;
		}
		else if (log.isInfoEnabled()) {
			return INFO;
		}
		else if (log.isWarnEnabled()) {
			return WARN;
		}
		else {
			return OFF;
		}
	}

	public static boolean isEnabled(Log log, String priority) {

		switch (Level.valueOf(priority)) {
		case DEBUG:
			return log.isDebugEnabled();
		case ERROR:
			return log.isErrorEnabled();
		case FATAL:
			return log.isFatalEnabled();
		case INFO:
			return log.isInfoEnabled();
		case OFF:
			return false;
		case WARN:
			return log.isWarnEnabled();
		}
		return false;
	}

	private final String name;
	private final String cssStyle;

	private Level(String name, String cssStyle) {

		this.name = name;
		this.cssStyle = cssStyle;
	}

	public String getCssStyle() {

		return cssStyle;
	}

	public String getName() {

		return name;
	}
}
