
package gr.open.loglevelsmanager.loglevel;

import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.SimpleAction;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import gr.open.loglevelsmanager.loglevel.model.LogLevel;
import gr.open.loglevelsmanager.loglevel.service.LogLevelLocalServiceUtil;

public class SetLogLevelsAction extends SimpleAction {

	private static final Log logger = LogFactoryUtil.getLog(SetLogLevelsAction.class);

	@Override
	public void run(String[] arg0)
		throws ActionException {

		for (LogLevel logLevel : LogLevelLocalServiceUtil.getByActivateOnStartup(true)) {
			logger.debug("ENABLING " + logLevel);
			LogFactoryUtil.getLogFactory().setLevel(
				logLevel.getLogLevelCategory(), logLevel.getLogLevelPriority(), true);
		}
	}
}
