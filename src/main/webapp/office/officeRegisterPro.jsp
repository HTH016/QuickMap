<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="setting_office.jsp"%>
<script src="${project}office.js"></script>

<h2> 업장 등록 신청 </h2>

<c:if test="${result eq 0}">
	<script type="text/javascript">
		alert(registerror);
	</script>
	<meta http-equiv="refresh" content="0; url=map_main.do">
</c:if>
<c:if test="${result eq 1}">
	<c:redirect url="map_main.do"/>
</c:if>
