<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file="setting_member.jsp" %>
<script type="text/javascript" src="/quickmap/jquery-3.6.4.js"></script>
<script src="${project}member.js"></script>

<h2> ${page_input} </h2>

<form method="post" action="memberinputpro.do" name="inputform" onsubmit="return inputcheck()">
	<input type="hidden" name="checkid" value=0>
	<input type="hidden" name="checknick" value=0>
	<table>
		<tr>	
			<th colspan=2> ${msg_input} </th>
		</tr>
		<tr>
			<th> ${str_user_id} </th>
			<td>
				<input type="text" name="user_id" maxlength=30 autofocus>
				<input type="button" value="중복확인" onclick="confirmid()">
			</td>
		</tr>
		<tr>
			<th rowspan=2> ${str_user_passwd} </th>
			<td> <input type="password" name="user_passwd" maxlength=30> </td>
		</tr>
		<tr>
			<td> <input type="password" name="user_repasswd" maxlength=30> </td>
		</tr>
		<tr>
			<th> ${str_user_name} </th>
			<td> <input type="text" name="user_name" maxlength=50> </td>
		</tr>
		<tr>
			<th> ${str_user_nick} </th>
			<td>
				<input type="text" name="user_nick" maxlength=50>
				<input type="button" value="중복확인" onclick="confirmnick('inputform')">	
			</td>
		</tr>
		<tr>
			<th> ${str_user_tel} </th>
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
			<th> ${str_user_email} </th>
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
				onclick="location='main.do'">
			</th>
		</tr>
	</table>
</form>
