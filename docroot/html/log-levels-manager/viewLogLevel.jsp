
<%@include file="../init.jsp" %>
<%@ page import="gr.open.loglevelsmanager.loglevel.model.LogLevel" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.util.HttpUtil" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="javax.script.ScriptEngine" %>
<%@ page import="javax.script.ScriptEngineManager" %>	


<jsp:useBean class="java.lang.String" id="editLogLevelURL" scope="request" />
<jsp:useBean id="logLevel" type="gr.open.loglevelsmanager.loglevel.model.LogLevel" scope="request"/>


<portlet:defineObjects />



<portlet:renderURL var="redirect"></portlet:renderURL>

<div class="entry">




			<span class="aui-field-content">
				<label class="aui-field-label"> 
					<liferay-ui:message key="loglevel-logleveldescription" />
				</label>
				<span class="aui-field-element">
					<%= logLevel.getLogLevelDescription() %>
				</span>
			</span>

			<span class="aui-field-content">
				<label class="aui-field-label"> 
					<liferay-ui:message key="loglevel-loglevelpriority" />
				</label>
				<span class="aui-field-element">
					<%= logLevel.getLogLevelPriority() %>
				</span>
			</span>



</div>
