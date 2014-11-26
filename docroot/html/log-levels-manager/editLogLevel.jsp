<%@page import="gr.open.loglevelsmanager.loglevel.enums.Level"%>
<%@include file="../init.jsp" %>
<%@ page import="gr.open.loglevelsmanager.loglevel.model.LogLevel" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.util.HttpUtil" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>

<jsp:useBean class="java.lang.String" id="editLogLevelURL" scope="request" />
<jsp:useBean id="logLevel" type="gr.open.loglevelsmanager.loglevel.model.LogLevel" scope="request"/>
<jsp:useBean id="editType" class="java.lang.String" scope="request"/>

<portlet:defineObjects />
<portlet:renderURL var="redirect"></portlet:renderURL>

<portlet:renderURL var="renderUrl" portletMode="view"></portlet:renderURL>

<c:set var="logLevel" value="<%= logLevel %>"/>
<c:choose>
	<c:when test='${logLevel eq null || logLevel.logLevelDescription eq null || logLevel.logLevelDescription == ""}'>
		<liferay-ui:header
			backURL="<%= renderUrl %>"
			title='Creating new log level'
		/>
	</c:when>
	<c:otherwise>
		<liferay-ui:header
			backURL="<%= renderUrl %>"
			title='Editing ${logLevel.logLevelCategory} (${logLevel.logLevelPriority})'
		/>
	</c:otherwise>
 </c:choose>
 
<liferay-ui:success key="loglevel-added-successfully" message="loglevel-added-successfully" />
<aui:form name="addLogLevel" action="<%=editLogLevelURL %>" method="post">

	<aui:input type="hidden" name="resourcePrimKey" value="<%=logLevel.getPrimaryKey() %>"/>
	<c:if test='<%= "add".equals(editType) %>'>
    	<aui:input type="hidden" name="addGuestPermissions" value="true"/>
    	<aui:input type="hidden" name="addGroupPermissions" value="true"/>
	</c:if>

	<aui:model-context bean="<%= logLevel %>" model="<%= LogLevel.class %>" />

	<% String requiredLabel=""; %>
	<aui:row>
		<aui:column>
		
			<aui:fieldset label="Main properties ">
				<% requiredLabel ="*"; %>
				<aui:input name="logLevelDescription" disabled="false" label='<%= LanguageUtil.get(pageContext, "loglevel-logleveldescription") + requiredLabel %>'/>
				<% requiredLabel =""; %>
				<liferay-ui:error key="loglevel-logleveldescription-required" message="loglevel-logleveldescription-required" />
				
				<% requiredLabel ="*"; %>
				<aui:input name="logLevelCategory" disabled="false" label='<%= LanguageUtil.get(pageContext, "loglevel-logLevelCategory") + requiredLabel %>'/>
				<% requiredLabel =""; %>
				<liferay-ui:error key="loglevel-logLevelCategory-required" message="loglevel-logLevelCategory-required" />
				
				<aui:select name="logLevelPriority">
					<c:set var="logLevel" value="<%=logLevel %>"/>
					<c:forEach items="<%= Level.values() %>" var="enumLevel">
						<option ${enumLevel.name eq logLevel.logLevelPriority ? "selected='selected'":"" } value="${enumLevel.name }">${enumLevel.name }</option>
					</c:forEach>
				</aui:select>
			</aui:fieldset>
		
		</aui:column>
		
		<aui:column>
		
			<aui:fieldset label="Scheduling">
				<div id="schedulerToggler">
					<aui:input class="header" name="logLevelScheduled" disabled="false" label='<%= LanguageUtil.get(pageContext, "loglevel-logLevelScheduled") + requiredLabel %>'/>
					<aui:input class="content" name="logLevelStartDate" disabled="false" label='<%= LanguageUtil.get(pageContext, "loglevellogLevelStartDate") + requiredLabel %>'/>
					<aui:input class="content" name="logLevelEndDate" disabled="false" label='<%= LanguageUtil.get(pageContext, "loglevel-logLevelEndDate") + requiredLabel %>'/>
				 </div>
			 </aui:fieldset>
			 
		</aui:column>
	
		<aui:column>
			<aui:fieldset label="Other">
				<aui:input name="activateOnStartup" disabled="false" label='<%= LanguageUtil.get(pageContext, "loglevel-logLevelActivateOnStartup") + requiredLabel %>'/>
			</aui:fieldset>
		</aui:column>
	</aui:row>
		
	<aui:row>

		<aui:button-row>
			<% String publishButtonLabel = "submit"; %>
	
			<aui:button type="submit" value="<%=publishButtonLabel %>" />
			<aui:button onClick="<%= redirect %>" type="cancel"/>
		</aui:button-row>

	</aui:row>

</aui:form>
