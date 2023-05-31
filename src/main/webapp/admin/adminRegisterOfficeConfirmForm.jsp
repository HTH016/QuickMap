<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="setting_admin.jsp" %>
    
 <br>
 <h2>${page_admin}</h2>
 <br>

<input type="button" style="width:90pt; height:20pt" value="${btn_admin_user}"
				onclick="location='adminuserlistform.do'">
<input type="button" style="width:90pt; height:20pt" value="${btn_admin_office}"
				onclick="location='adminregisterofficeform.do'">
<input type="button" style="width:90pt; height:20pt" value="${btn_admin_grade}"
				onclick="location='adminrequestgradeform.do'">
<input type="button" style="width:90pt; height:20pt" value="${btn_admin_ad}"
				onclick="location='adminrequestadform.do'">
<input type="button" style="width:90pt; height:20pt" value="${btn_admin_statistics}"
				onclick="location='statisticsadminform.do'">
				
<input type="button" style="width:90pt; height:30pt; float:right" value="${btn_to_main}"
				onclick="location='main.do'">


<h3 style="text-align:center">
${btn_admin_office}
</h3>	

		<table  border="1">
			
			<tr>
				<th> ${str_id} </th>
					<td> 
						${dto.user_id}
					</td>
			</tr>
			<tr>
				<th> ${str_office_name} </th>
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
				<th> ${str_office_regist} </th>
					<td>
						<!--  <img src="/JSP/save/systemName"> -->
						<img src="/quickmap${dto.office_regist_num_img}">
					</td>
			</tr>
						
		</table>
	<br>
	<form method="post" action="adminregisterofficeconfirmpro.do" name="inputform">
		<input type="hidden" name="regist_request_id" value="${regist_request_id}">	
		
		<input class="inputbutton" type="submit" value="업장 등록 승인"
			onclick="location='adminregisterofficeconfirmpro.do'">
		<input class="inputbutton" type="reset" value="목록"
			onclick="location='adminregisterofficeform.do'">
	</form>
			
				
	













