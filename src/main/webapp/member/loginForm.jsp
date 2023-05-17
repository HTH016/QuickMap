<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script src="${project}member.js"></script>


<h2> 로그인 </h2>

<form method="post" action="memberloginpro.do" name=loginform onsubmit="return logincheck()">
	<table>
		<tr>
			<th>ID</th>
			<td><input type="text" name="user_id" maxlength=30 autofocus></td>
		</tr>
		<tr>
			<th>PW</th>
			<td><input type="password" name="user_passwd" maxlength=30></td>
		</tr>
		<tr>
			<th colspan=2>
				<input type="submit" value="로그인">
				<input type="reset" value="취소">
				<input type="button" value="회원가입" onclick="location='memberinputform.do'">
			</th>
		</tr>
	</table>
</form>