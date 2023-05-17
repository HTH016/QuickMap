<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script src="${project}member.js"></script>
    
<h2>회원탈퇴</h2>

<form method="post" action="memberdeletepro.do" name="passwordform" onsubmit="return passwdcheck()">
	<table>
		<tr>
			<th colspan=2> 비밀번호를 입력하세요 </th>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="user_passwd" maxlength=30 autofocus></td>
		</tr>
		<tr>
			<th colspan=2>
				<input type="submit" value="탈퇴">
				<input type="button" value="탈퇴취소" onclick="location='지도'">
			</th>
		</tr>
	</table>
</form>
