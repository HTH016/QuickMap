<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h2> 회원정보수정 </h2>

<form method="post" action="membermodifyview.do" name="passwordform">
	<table>
		<tr>
			<th colspan=2> 비밀번호를 입력하세요 </th>
		</tr>
		<tr>
			<th> PW </th>
			<td> <input type="password" name="user_passwd" maxlength=30 autofocus>
		</tr>
		<tr>
			<th colspan=2>
				<input type="submit" value="확인">
				<input type="button" value="취소" on>
			</th>
		</tr>
	</table>
</form>
