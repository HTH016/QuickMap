<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    


<h2>관리자 페이지<h2>

<input class="inputbutton" type="button" value="회원 관리"
				onclick="location='adminUserListForm.jsp'">
<input class="inputbutton" type="button" value="업장 등록 관리"
				onclick="location='adminRegisterOfficeForm.jsp'">
<input class="inputbutton" type="button" value="업장 등급 관리"
				onclick="location='adminRequestGradeForm.jsp'">
<input class="inputbutton" type="button" value="광고 신청 관리"
				onclick="location='adminRequestAdForm.jsp'">
<input class="inputbutton" type="button" value="통계"
				onclick="location='adminStatics.jsp'">

<h3> 업장 등록 확인 </h3>

	
		
	<form method="post" action="adminuserinfopro.do" name="userinfoform">
		<table>
			
			<tr>
				<th> 아이디 </th>
				<td> <input class="input" type="text" name="id" value="asd123" readonly> </td>
			</tr>
			<tr>
				<th> 닉네임 </th>
				<td><input class="input" type="text" name="nick" value="닉네임" readonly> </td>
			</tr>
			<tr>
				<th> 비밀번호 </th>
				<td>
					<input class="input" type="password" name="passwd" value="1234qwer"readonly>
				</td>
			</tr>
			<tr>
				<th> 이름 </th>
				<td> <input class="input" type="text" name="name" value="홍길동" readonly> </td>
			</tr>
			<tr>
				<th> 전화번호 </th>
				<td>

						<input class="input" type="text" name="tel1" maxlength="3"
							style="width:30px" value="010" readonly>	
						- <input class="input" type="text" name="tel2" maxlength="4"
							style="width:40px" value="1111" readonly>
						- <input class="input" type="text" name="tel3" maxlength="4"
							style="width:40px" value="2222" readonly>					
					
				</td>
			</tr>
			<tr>
				<th> 이메일 </th>
				<td>
					
					
						<input class="input" type="text" name="email1" maxlength="25"
							value="qwer" style="width:100px" readonly>
						@ <input class="input" type="text" name="email2" maxlength="25"
							value="gmail.com" style="width:100px" readonly>							
						
				</td>
			</tr>
			<tr>
				<th> 가입일자 </th>
				
				<td>
					<input class="input" type="text" name="regdate" readonly>
				</td>
			</tr>	
			<tr>
				<th> 회원등급 </th>
				<td>
					<select name="usersort">
						<option value="0" selected>일반회원</option>
						<option value="1">등록회원</option>
						<option value="2">활동정지</option>
					</select>
				</td>
			</tr>			
		</table>
		
		<input class="inputbutton" type="submit" value="회원 등급 수정">
		<input class="inputbutton" type="reset" value="목록"
						onclick="location='adminUserListForm.jsp'">
		<input class="inputbutton" type="button" value="리뷰 내역 보기"
						onclick="location='adminReviewListForm.jsp'">		
				
	</form>		














