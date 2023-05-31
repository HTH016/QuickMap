<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="member.MemberDBBean"%>
<%@include file="setting_member.jsp" %>
<script type="text/javascript" src="/quickmap/jquery-3.6.4.js"></script>

<script src="${project}member.js"></script>

<h2>${page_delete}</h2>

<c:if test="${resultCheck eq 0}">
	<script type="text/javascript">
		erroralert(passerror);
	</script>
</c:if>
<c:if test="${resultCheck eq 1}">
	<c:if test="${result eq 0}">
		<script type="text/javascript">
			alert(deleteerror);
		</script>
		<meta http-equiv="refresh" content="0; url=main.do">
	</c:if>
	<c:if test="${result eq 1}">
		${sessionScope.memId = null}
		<c:redirect url="main.do"/>
	</c:if>
</c:if>
