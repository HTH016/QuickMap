<%@page import="review.ReviewDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="setting_review.jsp"%>
<script type="text/javascript" src="/quickmap/jquery-3.6.4.js"></script>
<script src="${project}review.js"></script>

<h2> 리뷰 삭제 </h2>

<!-- 삭제 안됨 -->
<c:if test="${result eq 0}">
	<script type="text/javascript">
		//<!--
		alert(deleteerror);
		-->
	</script>
	<meta http-equiv="refresh" content="0; url='reviewmodifyview.do?review_id=${review_id}'">
</c:if>
<!-- 삭제됨 -->
<c:if test="${result eq 1}">
	<c:redirect url="reviewlist.do"/>
</c:if>
