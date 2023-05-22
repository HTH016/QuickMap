<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    


<h2>관리자 페이지</h2>

<input class="inputbutton" type="button" value="회원 관리"
				onclick="location='adminuserlistform.do'">
<input class="inputbutton" type="button" value="업장 등록 관리"
				onclick="location='adminregisterofficeform.do'">
<input class="inputbutton" type="button" value="업장 등급 관리"
				onclick="location='adminrequestgradeform.do'">
<input class="inputbutton" type="button" value="광고 신청 관리"
				onclick="location='adminrequestadform.do'">
<input class="inputbutton" type="button" value="통계"
				onclick="location='adminstatics.do'">

<h3> 회원 정보 수정 </h3>

	
		
	<form method="post" action="adminuserinfopro.do" name="userinfoform">
		<table>
			
			<tr>
				<th> 아이디 </th>
				<td> <input type="text" name="user_id" value="${dto.user_id}" readonly> </td>
			</tr>
			<tr>
				<th> 닉네임 </th>
				<td><input type="text" name="user_nick" value="${dto.user_nick}" readonly> </td>
			</tr>
			<tr>
				<th> 비밀번호 </th>
				<td>
					<input type="password" name="user_passwd" value="${dto.user_passwd}"readonly>
				</td>
			</tr>
			<tr>
				<th> 이름 </th>
				<td> <input type="text" name="user_name" value="${dto.user_name}" readonly> </td>
			</tr>
			<tr>
				<th> 전화번호 </th>
				<td>

					
							
					<c:if test="${dto.user_tel eq null}">
						<input type="text" name="tel1" maxlength=3 style="width:30px" readonly>
						- <input type="text" name="tel2" maxlength=4 style="width:40px" readonly>
						- <input type="text" name="tel3" maxlength=4 style="width:40px" readonly>
					</c:if>
					<c:if test="${dto.user_tel ne null}">
						<c:set var="t" value="${fn:split(dto.user_tel, '-')}"/>
						<input type="text" name="tel1" maxlength=3 style="width:30px" value="${t[0]}" readonly>
						- <input type="text" name="tel2" maxlength=4 style="width:40px" value="${t[1]}" readonly>
						- <input type="text" name="tel3" maxlength=4 style="width:40px" value="${t[2]}" readonly>
					</c:if>				
					
				</td>
			</tr>
			<tr>
				<th> 이메일 </th>
				<td>					
						
					<c:if test="${dto.user_email eq null}">
						<input type="text" name="email1" maxlength=25 style="width:100px" readonly>
						@ <input type="text" name="email2" maxlength=25 style="width:100px" readonly>
					</c:if>
					<c:if test="${dto.user_email ne null}">
						<c:set var="e" value="${fn:split(dto.user_email, '@')}"/>
						<input type="text" name="email1" maxlength=25
						value="${e[0]}" style="width:100px" readonly>
						@ <input type="text" name="email2" maxlength=25
						value="${e[1]}" style="width:100px" readonly>
				</c:if>
						
				</td>
			</tr>
			<tr>
				<th> 가입일자 </th>
				
				<td>
					<input type="text" name="user_reg" value="${dto.user_reg}" readonly>
				</td>
			</tr>	
			<tr>
				<th> 회원등급 </th>
				<td>
					<select name="usersort">
						<option value="7" selected>${dto.grade_name}</option>
						<option value="0">탈퇴</option>
						<option value="1">활동정지</option>
						<option value="2">일반회원</option>
						<option value="3">등록회원</option>
						
					</select>
				</td>
			</tr>			
		</table>
		
		<input class="inputbutton" type="submit" value="회원 등급 수정">
		<input class="inputbutton" type="reset" value="목록"
						onclick="location='adminuserlistform.do'">
		<input class="inputbutton" type="button" value="리뷰 내역 보기"
						onclick="location='adminreviewlistform.do?user_id=${user_id}'">		
				
	</form>		














