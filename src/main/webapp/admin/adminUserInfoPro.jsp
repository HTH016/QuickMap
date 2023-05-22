<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="setting.jsp" %>
<script src="${project}script_qm_admin.js"></script>

<c:if test="${(result eq 0)}">
	<script type="text/javascript">
		//<!--
		alert( usergradechangeerror );
		-->
	</script>
	<meta http-equiv="refresh" content="0; url=adminuserinfoform.do?user_id=${user_id}">
</c:if>
<c:if test="${(result eq 1)}">
	<script type="text/javascript">
		//<!--
		alert( usergradechangesuccess );
		-->
	</script>
	<c:redirect url="adminuserinfoform.do?user_id=${user_id}"/>
</c:if>	

