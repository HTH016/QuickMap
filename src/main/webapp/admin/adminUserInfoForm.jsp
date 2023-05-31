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

<h3>
${page_admin_user_info}
</h3>	
	
	<form method="post" action="adminuserinfopro.do" name="userinfoform">
		<table border="1">	
			<tr>
				<th> ${str_id} </th>
				<td> <input type="text" name="user_id" value="${dto.user_id}" readonly> </td>
			</tr>
			<tr>
				<th> ${str_nick} </th>
				<td><input type="text" name="user_nick" value="${dto.user_nick}" readonly> </td>
			</tr>
			<tr>
				<th> ${str_passwd} </th>
				<td>
					<input type="password" name="user_passwd" value="${dto.user_passwd}"readonly>
				</td>
			</tr>
			<tr>
				<th> ${str_name} </th>
				<td> <input type="text" name="user_name" value="${dto.user_name}" readonly> </td>
			</tr>
			<tr>
				<th> ${str_tel} </th>
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
				<th> ${str_email} </th>
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
				<th> ${str_user_reg} </th>			
				<td>
					<input type="text" name="user_reg" value="${dto.user_reg}" readonly>
				</td>
			</tr>	
			<tr>
				<th> ${str_user_grade} </th>
				<td>
					<select name="usergradesort">
						<option value="7" selected>${dto.grade_name}</option>
						<option value="0">${option_user_delete}</option>
						<option value="1">${option_user_freeze}</option>
						<option value="2">${option_user_general}</option>
						<option value="3">${option_user_regist}</option>				
					</select>
				</td>
			</tr>			
		</table>
		<br>
		<input class="inputbutton" type="submit" value="${btn_user_modify}">
		<input class="inputbutton" type="reset" value="${btn_to_list}"
						onclick="location='adminuserlistform.do'">
		<input class="inputbutton" type="button" value="${btn_to_review}"
						onclick="location='adminreviewlistform.do?user_id=${user_id}'">			
	</form>		














