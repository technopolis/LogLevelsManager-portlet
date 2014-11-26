<%@include file="../init.jsp" %>

<%
	StringBuffer multiTabs = new StringBuffer();
	multiTabs.append(LanguageUtil.get(pageContext,"prefs-tab1"));
	multiTabs.append(",");
	multiTabs.append(LanguageUtil.get(pageContext,"prefs-tab2"));
%>
<portlet:renderURL var="renderUrl" portletMode="view"></portlet:renderURL>

<liferay-ui:header
	backURL="<%= renderUrl %>"
	title='Log Levels Manager Preferences'
/>

<liferay-ui:tabs
	names="<%= multiTabs.toString() %>"
	refresh="<%=false %>"
>
	<liferay-ui:section>
        <liferay-ui:success key="prefs-success" message="prefs-success" />
        <form name="setLogLevelPref" action="<portlet:actionURL name="setLogLevelPref" />" method="POST">
        <table border="0">
        	<tbody>
        		<tr>
        			<td>
        				<liferay-ui:message key="rows-per-page" />*<br>
        				<input type="text" name="rows-per-page" value="<%=prefs.getValue("rows-per-page","") %>" size="5" />
        				<liferay-ui:error key="rows-per-page-required" message="rows-per-page-required" />
        				<liferay-ui:error key="rows-per-page-invalid" message="rows-per-page-invalid" />
        			</td>
        		</tr>
        		<tr>
        			<td>
        				<liferay-ui:message key="date-format" />*<br>
        				<input type="text" name="date-format" value="<%=prefs.getValue("date-format","")%>" size="45" />
        				<liferay-ui:error key="date-format-required" message="date-format-required" />
        			</td>
        		</tr>
        		<tr>
        			<td>
        				<liferay-ui:message key="datetime-format" />*<br>
        				<input type="text" name="datetime-format" value="<%=prefs.getValue("datetime-format","")%>" size="45" />
        				<liferay-ui:error key="datetime-format-required" message="datetime-format-required" />
        			</td>
        		</tr>
			<% String viewTypeTmp = prefs.getValue("view-type","0"); %>
			<tr>
        			<td>
					<liferay-ui:message key="prefs-view-type" />*<br/>
					<select name="view-type"> 
						<option value="0" <%= (viewTypeTmp.equals("0")? "selected": "") %>><%= LanguageUtil.get(pageContext, "prefs-view-type-default") %> </option>
						<option value="1" <%= (viewTypeTmp.equals("1")? "selected": "") %>><%= LanguageUtil.get(pageContext, "prefs-view-type-user") %> </option>
						<option value="2" <%= (viewTypeTmp.equals("2")? "selected": "") %>><%= LanguageUtil.get(pageContext, "prefs-view-type-user-group") %> </option>
        				</select>
        			</td>
        		</tr>
        	</tbody>
        </table>
        <input type="submit" value="Submit" />
        </form>
	</liferay-ui:section>
	<liferay-ui:section>
		<aui:button-row>
			<ul>
				<li><liferay-ui:message key="prefs-export-message1" /></li>
				<li><liferay-ui:message key="prefs-export-message2" /></li>
				<li><liferay-ui:message key="prefs-export-message3" /></li>
			</ul>
			<input type="button" value="<%=LanguageUtil.get(pageContext,"prefs-export") %>"   onClick="location.href = '<portlet:resourceURL id="exportFullLogLevelResourceURL"></portlet:resourceURL>'" />
		</aui:button-row>
	</liferay-ui:section>
</liferay-ui:tabs>
