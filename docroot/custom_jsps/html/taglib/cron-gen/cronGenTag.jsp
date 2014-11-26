<%@include file="./init.jsp" %>

<liferay-ui:tabs 
	names="minutes,hourly,daily,weekly,monthly,yearly"
	refresh="<%=false %>"
	param="cronTab"
>
	<c:choose>
		<c:when test='${cronTab == "minutes"}'>
		</c:when>
				<c:when test='${cronTab == "minutes"}'>
		</c:when>
				<c:when test='${cronTab == "hourly"}'>
		</c:when>
				<c:when test='${cronTab == "daily"}'>
		</c:when>
				<c:when test='${cronTab == "weekly"}'>
		</c:when>
				<c:when test='${cronTab == "monthly"}'>
		</c:when>
						<c:when test='${cronTab == "yearly"}'>
		</c:when>
	</c:choose>
</liferay-ui:tabs>