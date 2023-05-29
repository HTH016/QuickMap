<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="setting_admin.jsp" %>
<script src="${project}script_qm_admin.js"></script>

<c:if test="${(result eq 0)}">
	<script type="text/javascript">
		//<!--
		alert( registerofficeerror );
		-->
	</script>
	<meta http-equiv="refresh" content="0; url=adminregisterofficeconfirmform.do?regist_request_id=${regist_request_id}">
</c:if>
<c:if test="${(result eq 1)}">
	<script type="text/javascript">
		//<!--
		alert( registerofficesuccess );
		-->
	</script>
	<c:redirect url="adminregisterofficeform.do"/>
</c:if>	
	