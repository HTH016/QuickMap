<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="setting.jsp" %>
<script src="${project}script_qm_admin.js"></script>

<c:if test="${(result eq 0)}">
	<script type="text/javascript">
		//<!--
		alert( adminrequestaderror );
		-->
	</script>
	<meta http-equiv="refresh" content="0; url=adminrequestadform.do">
</c:if>
<c:if test="${(result eq 1)}">
	<c:redirect url="url=adminrequestadform.do"/>
</c:if>	