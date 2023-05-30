<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="setting_review.jsp"%>
<script src="${project}review.js"></script>

<h2>리뷰 수정</h2>

<c:if test="${result eq 0}">
<script type="text/javascript">
	// <!--
	alert(modifyerror);
	// -->
</script>
<meta http-equiv="refresh" content="0; url='${nextPage}.do'">
</c:if>

<c:if test="${result eq 1}">
	<c:redirect url="${nextPage}.do"/>
</c:if>
