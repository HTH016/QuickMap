<%@page import="review.ReviewDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="setting_review.jsp"%>
<script src="${project}review.js"></script>

<h2>리뷰 수정</h2>
<c:if test="${result eq 0}">
<script type="text/javascript">
	//<!--
	alert(writeerror);
	-->
</script>
<meta http-equiv="refresh" content="0; url='map_main.do'">
</c:if>
<c:if test="${result eq 1}">
<c:redirect url="map_main.do"/>
</c:if>