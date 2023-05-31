<%@page import="java.text.SimpleDateFormat"%>
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

	<table border="1" style="margin-left: auto; margin-right: auto; margin-top: auto; margin-bottom: auto;">
		<tr>
			<th>${dto.office_name}</th>
			<td colspan="2"> </td>
		</tr>
		<tr>
			<td colspan="3"> <pre>${dto.review_data}</pre> </td>
		</tr>
		<tr>
			<td style="text-align:center"> ${dto.user_nick} </td>
			<td style="text-align:center"> ${dto.review_star} </td>
			<td style="text-align:center"> ${dto.review_reg} </td>
		</tr>
	</table>
	<input class="inputbutton" type="button" value="삭제"
				onclick="location='adminreviewpro.do?review_id=${dto.review_id}&user_id=${dto.user_id}'">
		





























