<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h2> 회원가입 </h2>

<form method="post" action="memberinputpro.do" name="inputform">
	<table>
		<tr>
			<th> ID </th>
			<td>
				<input type="text" name="user_id" maxlength=30 autofocus>
				<input type="button" value="중복확인" onclick="confirmid()">
			</td>
		</tr>
		<tr>
			<th rowspan=2> PW </th>
			<td> <input type="password" name="user_passwd" maxlength=30> </td>
		</tr>
		<tr>
			<td> <input type="password" name="user_repasswd" maxlength=30> </td>
		</tr>
		<tr>
			<th> 이름 </th>
			<td> <input type="text" name="user_name" maxlength=50> </td>
		</tr>
		<tr>
			<th> 닉네임 </th>
			<td>
				<input type="text" name="user_nick" maxlength=50>
				<input type="button" value="중복확인" onclick="confirmnick()">	
			</td>
		</tr>
		<tr>
			
		</tr>
		<tr>
			<th> 전화번호 </th>
			<td>
				<input type="text" name="tel1" maxlength=3 style="width:30px"
				onkeyup="nexttel2()">
				- <input type="text" name="tel2" maxlength=4 style="width:40px"
				onkeyup="nexttel3()">
				- <input type="text" name="tel3" maxlength=4 style="width:40px"
				onkeyup="nextemail1()">
			</td>
		</tr>
		<tr>
			<th> 이메일 </th>
			<td>
				<input type="text" name="email1" maxlength=25
				style="width:100px">
				@
				<select name="email2">
					<option value=0> 직접입력 </option>
					<option value="daum.net"> 다음 </option>
					<option value="naver.com"> 네이버 </option>
					<option value="gmail.com"> 구글 </option>
					<option value="nate.com"> 네이트 </option>
				</select>
			</td>
		</tr>
		<tr>
			<th colspan=2>
				<input type="submit" value="가입">
				<input type="reset" value="취소">
				<input type="button" value="가입취소"
				onclick="location='logonmain.do'">
			</th>
		</tr>
	</table>
</form>
