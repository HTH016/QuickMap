<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="setting_member.jsp" %>
<script type="text/javascript" src="/quickmap/jquery-3.6.4.js"></script>    
<script src="${project}member.js"></script>

<h2> 회원정보수정 </h2>
<c:if test="${sessionScope.memId != null}">
<form method="post" action="membermodifyview.do" name="passwordform" onsubmit="return passwdcheck()">
	<table>
		<tr>
			<th style="width:500px"> <span>${sessionScope.memId}</span> 님 안녕하세요</th>
		</tr>
		<tr>
			<th colspan=2> 비밀번호를 입력하세요 </th>
		</tr>
		<tr>
			<th> 비밀번호 </th>
			<td> <input type="password" name="user_passwd" maxlength=30 autofocus>
		</tr>
		<tr>
			<th colspan=2>
				<input type="submit" value="확인">
				<input type="button" value="취소" onclick="location='map_main.do'">
			</th>
		</tr>
	</table>
</form>
</c:if>
<c:if test="${sessionScope.memId == null}">
	<input type="button" value="확인" onclick="location='memberloginform.do'">
</c:if>