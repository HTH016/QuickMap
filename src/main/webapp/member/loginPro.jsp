<%@page import="member.MemberDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="setting_member.jsp" %>
<script type="text/javascript" src="/quickmap/jquery-3.6.4.js"></script>

<script src="${project}member.js"></script>

<h2>로그인</h2>
<c:if test="${grade_id eq 0}">
	<script type="text/javascript">
		erroralert(gradeerror);
	</script>
</c:if>
<c:if test="${grade_id ne 0}">
	<c:if test="${result eq -1}">
		<script type="text/javascript">
			erroralert(idxerror);
		</script>
	</c:if>
	<c:if test="${result eq 0}">
		<script type="text/javascript">
			erroralert(passerror);
		</script>
	</c:if>
	<c:if test="${result eq 1}">
		${sessionScope.memId = user_id}
		<c:redirect url="main.do"/>
	</c:if>
</c:if>