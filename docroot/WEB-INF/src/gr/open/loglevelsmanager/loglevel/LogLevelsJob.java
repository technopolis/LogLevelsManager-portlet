
package gr.open.loglevelsmanager.loglevel;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;

import gr.open.loglevelsmanager.loglevel.enums.Level;
import gr.open.loglevelsmanager.loglevel.model.LogLevel;
import gr.open.loglevelsmanager.loglevel.service.LogLevelLocalServiceUtil;

import java.util.Date;

public class LogLevelsJob implements MessageListener {

	private static final Log logger = LogFactoryUtil.getLog(LogLevelsJob.class);

	@Override
	public void receive(Message message)
		throws MessageListenerException {

		logger.debug("RUNNING LOG LEVELS JOB");
		for (LogLevel logLevel : LogLevelLocalServiceUtil.getByScheduled(true)) {
			logger.debug("CHECKING " + logLevel);
			Date now = new Date();
			if (now.before(logLevel.getLogLevelStartDate()) || now.after(logLevel.getLogLevelEndDate())) {
				logger.debug("  DISABLING " + logLevel);
				LogFactoryUtil.getLogFactory().setLevel(logLevel.getLogLevelCategory(), Level.OFF.toString(), true);
				continue;
			}
			logger.debug("  ENABLING " + logLevel);
			LogFactoryUtil.getLogFactory().setLevel(
				logLevel.getLogLevelCategory(), logLevel.getLogLevelPriority(), true);
		}
		logger.debug("ENDING LOG LEVELS JOB");
	}
}
