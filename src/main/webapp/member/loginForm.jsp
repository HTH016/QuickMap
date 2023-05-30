<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="setting_member.jsp" %>
<script type="text/javascript" src="/quickmap/jquery-3.6.4.js"></script>
<script src="${project}member.js"></script>


<h2> ${page_login} </h2>

<form method="post" action="memberloginpro.do" name=loginform onsubmit="return logincheck()">
	<table>
		<tr>
			<th colspan=2> ${msg_main} </th>
		</tr>
		<tr>
			<th>${str_user_id}</th>
			<td><input type="text" name="user_id" maxlength=30 autofocus></td>
		</tr>
		<tr>
			<th>${str_user_passwd}</th>
			<td><input type="password" name="user_passwd" maxlength=30></td>
		</tr>
		<tr>
			<th colspan=2>
				<input type="submit" value="${btn_login}">
				<input type="reset" value="${btn_cancel}">
				<input type="button" value="${btn_member}" onclick="location='memberinputform.do'">
			</th>
		</tr>
	</table>
</form>