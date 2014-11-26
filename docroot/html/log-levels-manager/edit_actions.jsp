<%@page import="java.net.URLEncoder"%>
<%@page import="gr.open.loglevelsmanager.loglevel.enums.Action"%>
<%@include file="../init.jsp" %>

<%@ page import="gr.open.loglevelsmanager.loglevel.model.LogLevel"%>
<%@ page import="gr.open.loglevelsmanager.loglevel.service.LogLevelLocalServiceUtil"%>
<%@ page import="gr.open.loglevelsmanager.loglevel.service.permission.LogLevelEntryPermission"%>
<%@ page import="com.liferay.portal.kernel.util.HttpUtil"%>
<%@ page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil"%>
<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
LogLevel logLevel = (LogLevel)row.getObject();

long groupId = logLevel.getGroupId();
String name = LogLevel.class.getName();
String primKey = String.valueOf(logLevel.getPrimaryKey());
boolean noDetailsRows = true;

%>
<liferay-ui:icon-menu cssClass="">

	<c:if test="<%= LogLevelEntryPermission.contains(permissionChecker, logLevel, ActionKeys.UPDATE) %>">
		<portlet:actionURL name="editLogLevel" var="editLogLevelURL">
			<portlet:param name="resourcePrimKey" value="<%=primKey %>" />
		</portlet:actionURL>

		<liferay-ui:icon image="edit" url="<%=editLogLevelURL.toString() %>" />
	</c:if>
	<c:if test="<%= LogLevelEntryPermission.contains (permissionChecker, logLevel, ActionKeys.DELETE) %>">
		<portlet:actionURL name="deleteLogLevel" var="deleteLogLevelURL">
			<portlet:param name="resourcePrimKey" value="<%= primKey %>" />
		</portlet:actionURL>
		<c:choose>
			<c:when test="<%= !noDetailsRows %>">
			<%
			String deleteUrl = null;
			deleteUrl = "javascript:if(confirm('" + UnicodeLanguageUtil.get(pageContext, "confirm-delete") + "')){submitForm(document.hrefFm, '" + HttpUtil.encodeURL(deleteLogLevelURL) + "');}";
			 
			%>
			<liferay-ui:icon image="delete" url="<%=deleteUrl %>" />

			</c:when>
			<c:otherwise>
		    		<liferay-ui:icon image="delete" url="<%=deleteLogLevelURL.toString() %>" />
		        </c:otherwise>
		</c:choose>
	</c:if>

	<portlet:actionURL name="copyLogLevel" var="copyLogLevelURL">
		<portlet:param name="resourcePrimKey" value="<%= primKey %>" />
	</portlet:actionURL>
	<liferay-ui:icon
		image="copy"
		message="Copy"
		url='<%= copyLogLevelURL.toString() %>'
	/>

<c:if test="<%= LogLevelEntryPermission.contains(permissionChecker, logLevel, ActionKeys.PERMISSIONS) %>">
		<liferay-security:permissionsURL
			modelResource="gr.open.loglevelsmanager.loglevel.model.LogLevel"
			modelResourceDescription="LogLevel"
			resourcePrimKey="<%= String.valueOf(primKey) %>"
			var="permissionsEntryURL"
		/>

		<liferay-ui:icon
			image="permissions"
			url="<%= permissionsEntryURL %>"
		/>
</c:if>
<%
	String enableUrl = URLEncoder.encode("http://localhost:8080/c/portal/logLevels?action=" + Action.enable.toString() + "&logLevelId=" + logLevel.getLogLevelId() + "&name=" + logLevel.getLogLevelCategory() + "&priority=" + logLevel.getLogLevelPriority(), "UTF-8");
	String disableUrl = URLEncoder.encode("http://localhost:8080/c/portal/logLevels?action=" + Action.disable.toString() + "&logLevelId=" + logLevel.getLogLevelId() + "&name=" + logLevel.getLogLevelCategory(), "UTF-8");
%>
	<c:set var="enableUrl" value="<%=enableUrl %>"/>
	<c:set var="disableUrl" value="<%=disableUrl %>"/>
	<liferay-ui:icon
		image="checked"
		message="Enable"
		url='javascript:callAndRefresh("${enableUrl }");'
	/>
	<liferay-ui:icon
		image="unchecked"
		message="Disable"
		url='javascript:callAndRefresh("${disableUrl }");'
	/>
</liferay-ui:icon-menu>

<script>
function callAndRefresh(url) {
	YUI().use(
	  'aui-io-request',
	  function (Y) {
	    Y.io.request(
	      url,
	      {
	        on: {
	          success: function() {
	        	  location.reload();
	          }
	        }
	      }
	    );
	  }
	);
}
</script>
