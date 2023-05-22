<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="setting.jsp" %>
<script src="${project}script_qm_admin.js"></script>

<c:if test="${(result eq 0)}">
	<script type="text/javascript">
		//<!--
		alert( adminreviewdeleteerror );
		-->
	</script>
	<meta http-equiv="refresh" content="0; url=adminreviewlistform.do">
</c:if>
<c:if test="${(result eq 1)}">
	<script type="text/javascript">
		//<!--
		alert( adminreviewdeletesuccess );
		-->
	</script>
	<c:redirect url="adminreviewlistform.do?user_id=${user_id}"/>
</c:if>	