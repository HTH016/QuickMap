<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="setting_member.jsp" %>
<script type="text/javascript" src="/quickmap/jquery-3.6.4.js"></script>    
<script src="${project}member.js"></script>
    
<h2>${page_delete}</h2>

<form method="post" action="memberdeletepro.do" name="passwordform" onsubmit="return passwdcheck()">
	<table>
		<tr>
			<th colspan=2> ${msg_passwd} </th>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="user_passwd" maxlength=30 autofocus></td>
		</tr>
		<tr>
			<th colspan=2>
				<input type="submit" value="${btn_delete}">
				<input type="button" value="${btn_delete_cancel}" onclick="location='main.do'">
			</th>
		</tr>
	</table>
</form>
