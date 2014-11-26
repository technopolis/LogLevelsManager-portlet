<%@page import="gr.open.loglevelsmanager.loglevel.enums.Level"%>
<%@page import="gr.open.loglevelsmanager.loglevel.enums.Action"%>
<%@include file="../init.jsp" %>

<jsp:useBean id="addLogLevelURL" class="java.lang.String" scope="request" />
<jsp:useBean id="LogLevelFilterURL" class="java.lang.String" scope="request" />
<jsp:useBean id="LogLevelFilter" class="java.lang.String" scope="request" />

<liferay-ui:success key="prefs-success" message="prefs-success" />
<liferay-ui:success key="loglevel-added-successfully" message="loglevel-added-successfully" />
<liferay-ui:success key="loglevel-deleted-successfully" message="loglevel-deleted-successfully" />
<liferay-ui:success key="loglevel-updated-successfully" message="loglevel-updated-successfully" />
<liferay-ui:error key="loglevel-error-deleting" message="loglevel-error-deleting" />
<liferay-ui:error key="permission-error" message="permission-error" />


<aui:nav-bar>
	<aui:nav collapsible="true">		
		<c:choose>
			<c:when test='<%= (Boolean)request.getAttribute("hasAddPermission") %>'>
				<aui:nav-item iconCssClass="icon-plus-sign" name="addLogLevelButton" href="<%=addLogLevelURL %>" label="loglevel-add"/>
			</c:when>
		</c:choose>
		<c:choose>
			<c:when test='<%= (Boolean)request.getAttribute("hasModelPermissions") %>'>
				<liferay-security:permissionsURL
					modelResource="gr.open.loglevelsmanager.loglevel.LogLevel"
					modelResourceDescription="<%= HtmlUtil.escape(themeDisplay.getScopeGroupName()) %>"
					resourcePrimKey="<%= String.valueOf(themeDisplay.getScopeGroupId()) %>"
					var="modelPermissionsURL"
				/>
				<aui:nav-item name="addLogLevelButton" href="<%= modelPermissionsURL %>" label="permissions"/>
			</c:when>
		</c:choose>
	</aui:nav>

</aui:nav-bar>
<%
	String iconChecked = "checked";
	String iconUnchecked = "unchecked";
	int rows_per_page = Integer.parseInt((String)request.getAttribute("rowsPerPage"));
	SimpleDateFormat dateFormat = new SimpleDateFormat(prefs.getValue("date-format", "yyyy/MM/dd"));
	SimpleDateFormat dateTimeFormat = new SimpleDateFormat(prefs.getValue("datetime-format","yyyy/MM/dd HH:mm"));

	PortalPreferences portalPrefs = PortletPreferencesFactoryUtil.getPortalPreferences(request);

	String orderByCol = ParamUtil.getString(request, "orderByCol");
	String orderByType = ParamUtil.getString(request, "orderByType");

	if (Validator.isNotNull(orderByCol) && Validator.isNotNull(orderByType)) {
		portalPrefs.setValue("LogLevel_order", "LogLevel-order-by-col", orderByCol);
		portalPrefs.setValue("LogLevel_order", "LogLevel-order-by-type", orderByType);
	} else {
		orderByCol = portalPrefs.getValue("LogLevel_order", "LogLevel-order-by-col", "LogLevelId");
		orderByType = portalPrefs.getValue("LogLevel_order", "LogLevel-order-by-type", "asc");
	}

	List<LogLevel> tempResults = (List<LogLevel>)request.getAttribute("tempResults");
	Integer totalCount = (Integer)request.getAttribute("totalCount");

	int containerStart;
	int containerEnd;
	try {
		containerStart = ParamUtil.getInteger(request, "containerStart");
		containerEnd = ParamUtil.getInteger(request, "containerEnd");
	} catch (Exception e) {
		containerStart = 0;
		containerEnd = rows_per_page;
	}
	
%>
<liferay-ui:search-container deltaConfigurable="false" delta='<%= rows_per_page %>' emptyResultsMessage="loglevel-empty-results-message" orderByCol="<%= orderByCol%>" orderByType="<%= orderByType%>">
	<liferay-ui:search-container-results total="<%= totalCount %>" results="<%= tempResults %>">

		<%
		request.setAttribute("containerStart",String.valueOf(containerStart));
		request.setAttribute("containerEnd",String.valueOf(containerEnd));
		request.setAttribute("orderByCol", orderByCol);
		request.setAttribute("orderByType", orderByType);
		%>

	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row
		className="gr.open.loglevelsmanager.loglevel.model.LogLevel"
		keyProperty="logLevelId"
		modelVar="logLevel"
	>

		<liferay-ui:search-container-column-text
			name="Description"
		    property="logLevelDescription"
			align="left"
		/>
		<liferay-ui:search-container-column-text
			name="Category"
			
		    property="logLevelCategory"
			align="left"
		/>
		<%
		String cssStyle = "";
		if (Validator.isNotNull(logLevel.getLogLevelPriority())) {
			cssStyle = "label-" + Level.valueOf(logLevel.getLogLevelPriority()).getCssStyle();
		}
		String priorityValue = "<span class='label " + cssStyle + "'>" + logLevel.getLogLevelPriority() + "</span>";
		%>
		<liferay-ui:search-container-column-text
			name="Priority"
			value="<%=priorityValue %>"
			align="left"
		/>
		<liferay-ui:search-container-column-text name="Startup"	align="center" >
			 <%
 				String logLevelActivateOnStartupIcon = iconUnchecked;
  				if (logLevel.isActivateOnStartup()) {
  					logLevelActivateOnStartupIcon = iconChecked;
 				}
 			  %>
			<liferay-ui:icon image="<%=logLevelActivateOnStartupIcon %>"/>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Scheduled"	align="center" >
			 <%
 				String logLevelScheduledIcon = iconUnchecked;
  				if (logLevel.isLogLevelScheduled()) {
 					logLevelScheduledIcon = iconChecked;
 				}
 			  %>
			<liferay-ui:icon image="<%=logLevelScheduledIcon %>"/>
		</liferay-ui:search-container-column-text>
		
		<%
		String isActiveLogLevelUrl = "http://localhost:8080/c/portal/logLevels?action=" + Action.exists.toString() + "&name=" + logLevel.getLogLevelCategory() + "&priority=" + logLevel.getLogLevelPriority();
		%>
		
		<script>
		YUI().use(
		  'node','aui-io-request',
		  function (Y) {
		    Y.io.request(
		      '<%=isActiveLogLevelUrl%>',
		      {
		        on: {
		          success: function() {
		            var data = JSON.parse(this.get('responseData'));
		            if (data.exists) {
			            Y.one('#logLevel-<%=logLevel.getLogLevelId() %>').setContent('<img src="<%=themeDisplay.getPathThemeImages() %>/common/checked.png"/>');
		            }
		            else {
		            	Y.one('#logLevel-<%=logLevel.getLogLevelId() %>').setContent('<img src="<%=themeDisplay.getPathThemeImages() %>/common/unchecked.png"/><span class="label label-' + data.cssStyle + '"/>' + data.current + '</span>');
		            }
		          }
		        }
		      }
		    );
		  }
		);
		</script>
		
		<liferay-ui:search-container-column-text
			name="Enabled"
			align="left"
		>
			<div id="logLevel-<%=logLevel.getLogLevelId()%>"><img src="<%=themeDisplay.getPathThemeImages() %>/progress_bar/loading_animation.gif"/></div>
		</liferay-ui:search-container-column-text>
		
		<liferay-ui:search-container-column-jsp
			align="right"
			path="/html/log-levels-manager/edit_actions.jsp"
		/>

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />

</liferay-ui:search-container>
