<%@page import="office.OfficeDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="setting_office.jsp"%>
<script type="text/javascript" src="/quickmap/jquery-3.6.4.js"></script>
<script src="${project}office.js"></script>

<h2> 업장정보수정 </h2>

<c:if test="${result eq 0}">
	<script type="text/javascript">
		alert(modifyerror);
	</script>
	<meta http-equiv="refresh" content="0; url=membermodifyview.do">
</c:if>
<c:if test="${result eq 1}">
	<c:redirect url="membermodifyview.do"/>
</c:if>