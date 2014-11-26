
<%@include file="../init.jsp" %>

<%@ page import="gr.open.loglevelsmanager.loglevel.model.LogLevel"%>
<%@ page import="gr.open.loglevelsmanager.loglevel.service.LogLevelLocalServiceUtil"%>
<%@ page import="gr.open.loglevelsmanager.loglevel.service.permission.LogLevelEntryPermission"%>

<%
String containerStart = (String) request.getAttribute("containerStart");
String containerEnd =  (String) request.getAttribute("containerEnd");
String orderByType = (String) request.getAttribute("orderByType");
String orderByCol =  (String) request.getAttribute("orderByCol");
Integer cur          =  (Integer) request.getAttribute("cur");
String loglevelFilter = ParamUtil.getString(request, "LogLevelFilter");
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
LogLevel logLevel = (LogLevel)row.getObject();

long groupId = logLevel.getGroupId();
String name = LogLevel.class.getName();
String primKey = String.valueOf(logLevel.getPrimaryKey());

%>
<c:if test="<%= LogLevelEntryPermission.contains(permissionChecker, logLevel, ActionKeys.UPDATE) %>">
    <portlet:actionURL name="eventLogLevel" var="eventLogLevelURL">
        <portlet:param name="resourcePrimKey" value="<%=primKey %>" />
        <portlet:param name="containerStart" value="<%= containerStart %>" />
        <portlet:param name="containerEnd" value="<%= containerEnd %>" />
		<portlet:param name="cur" value="<%= String.valueOf(cur)  %>" />
        <portlet:param name="LogLevelFilter" value="<%= loglevelFilter %>" />
    </portlet:actionURL>
<%
	if (primKey.equalsIgnoreCase((String)request.getAttribute("highlightRowWithKey"))) {
%>
    <liferay-ui:icon image="forward" url="<%=eventLogLevelURL.toString() %>" />
<%
	} else {
%>
    <liferay-ui:icon image="view" url="<%=eventLogLevelURL.toString() %>" />
<%
	}
%>
</c:if>
