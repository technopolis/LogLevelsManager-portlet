
package gr.open.loglevelsmanager.loglevel;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.struts.BaseStrutsAction;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.theme.ThemeDisplay;

import gr.open.loglevelsmanager.loglevel.enums.Action;
import gr.open.loglevelsmanager.loglevel.enums.Level;
import gr.open.loglevelsmanager.loglevel.service.permission.LogLevelEntryPermission;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogLevelsStrutsAction extends BaseStrutsAction {

	private static final Log logger = LogFactoryUtil.getLog(LogLevelsStrutsAction.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();

		JSONObject result = JSONFactoryUtil.createJSONObject();

		String action = ParamUtil.getString(request, "action");
		String name = ParamUtil.getString(request, "name");
		String priority = ParamUtil.getString(request, "priority");
		long logLevelId = ParamUtil.getLong(request, "logLevelId");

		Log log = LogFactoryUtil.getLogFactory().getLog(name);

		if (logger.isDebugEnabled()) {
			logger.debug("======================");
			logger.debug("action:" + action);
			logger.debug("name:" + name);
			logger.debug("priority:" + priority);
			logger.debug("isSignedIn:" + themeDisplay.isSignedIn());
			logger.debug("user:" + themeDisplay.getUser());
		}

		boolean success = true;

		switch (Action.valueOf(action)) {

		case enable:
			if (!LogLevelEntryPermission.contains(permissionChecker, logLevelId, "ENABLE")) {
				success = false;
				result.put("error", "You don't have permission to enable a log");
			}
			else {
				LogFactoryUtil.getLogFactory().setLevel(name, priority, true);
				result.put("set", true);
			}

			break;
		case exists:

			if (log != null) {
				boolean isEnabled = Level.isEnabled(log, priority);
				Level currentLevel = Level.getLevel(log);
				logger.debug("  isEnabled: " + isEnabled);
				result.put("exists", isEnabled);
				result.put("current", currentLevel.toString());
				result.put("cssStyle", currentLevel.getCssStyle());
			}

			break;
		case disable:
			if (!LogLevelEntryPermission.contains(permissionChecker, logLevelId, "DISABLE")) {
				success = false;
				result.put("error", "You don't have permission to enable a log");
			}
			else {
				LogFactoryUtil.getLogFactory().setLevel(name, "OFF", true);
				result.put("set", true);
			}
			break;
		}

		result.put("success", success);

		logger.debug("RETURNING JSON:" + result);

		PrintWriter writer = response.getWriter();
		writer.print(result.toString());
		writer.flush();
		response.setContentType("application/json");

		return null;
	}

}
