
<%@include file="../init.jsp" %>

<portlet:renderURL var="renderUrl" portletMode="view"></portlet:renderURL>

<liferay-ui:header
	backURL="<%= renderUrl %>"
	title='Log Levels Manager Help'
/>