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
				onclick="location='statisticsadminform.do'">


<h3> 업장 등록 확인 </h3>

		<table>
			
			<tr>
				<th> 아이디 </th>
					<td> 
						${dto.user_id}
					</td>
			</tr>
			<tr>
				<th> 업장명 </th>
					<td> 
						${dto.office_name}
					</td>
			</tr>
		<!--  	<tr>
				<th> 사업자 등록 번호 </th>
					<td>
						${dto.office_regist_num}
					</td>
			</tr>		-->
			<tr>
				<th> 사업자 등록증 </th>
					<td>
						${dto.office_regist_num_img}
					</td>
			</tr>
						
		</table>
	<form method="post" action="adminregisterofficeconfirmpro.do" name="inputform">
		<input type="hidden" name="regist_request_id" value="${regist_request_id}">	
		
		<input class="inputbutton" type="submit" value="업장 등록 승인"
			onclick="location='adminregisterofficeconfirmpro.do'">
		<input class="inputbutton" type="reset" value="목록"
			onclick="location='adminregisterofficeform.do'">
	</form>
			
				
	













