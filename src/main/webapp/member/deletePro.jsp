<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="${project}member.js"></script>

<h2>회원탈퇴</h2>

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
		<meta http-equiv="refresh" content="0; url=지도">
	</c:if>
	<c:if test="${result eq 1}">
		${sessionScope.memId = null}
		<c:redirect url="지도"/>
	</c:if>
</c:if>
