<%@page import="member.MemberDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="setting_member.jsp" %>
<script type="text/javascript" src="/quickmap/jquery-3.6.4.js"></script>

<script src="${project}member.js"></script>

<h2> 회원정보수정 </h2>

<c:if test="${result eq 0}">
	<script type="text/javascript">
		alert(modifyerror);
	</script>
	<meta http-equiv="refresh" content="0; url=main.do">
</c:if>
<c:if test="${result eq 1}">
	<c:redirect url="main.do"/>
</c:if>

