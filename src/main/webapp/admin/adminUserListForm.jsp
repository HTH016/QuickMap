<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
${page_admin_user}
</h3>		
 
<form method="post" action="adminuserlistoptionsortform.do" name="usersortby">
	<select name="usersort" style="text-align:right">
		<option value="1" selected>${option_reg_new}</option>
		<option value="2">${option_reg_old}</option>
		<option value="3">${option_user_general}</option>
		<option value="4">${option_user_regist}</option>
	</select>
		<input class="button" type="submit" value="${btn_user_sort}">
</form>

<form method="post" action="adminuserlistoptionselectform.do" name="userselectby">
 <select name="userselect">
  	<option value="5" selected>${option_id}</option>
  	<option value="6">${option_nick}</option>
  	
</select>
  	<input class="input" type="text" name="usersearchword">
	<input class="button" type="submit" value="${btn_user_search}">
</form>	

<table style="margin-left: auto; margin-right: auto;" border="1" width="70%">
	
	<tr>
		<th style="width:10%"> ${str_id} </th>
		<th style="width:10%"> ${str_nick} </th>
		<th style="width:7%"> ${str_user_reg} </th>
		<th style="width:3%"> ${str_user_grade} </th>
	</tr>
	
	<c:if test="${count eq 0}">
		<tr>
			<td style="text-align:center" colspan="4">
				${msg_no_user}
			</td>
		</tr>
	</c:if>
	
	<c:if test="${count ne 0 }">  
		<c:forEach var="dto" items="${dtos}">
			<tr>
				<td style="text-align:center">
					<a href="adminuserinfoform.do?user_id=${dto.user_id}">
					${dto.user_id}
					</a>
				</td>
				<td style="text-align:center">
					${dto.user_nick} 
				</td>
				<td style="text-align:center">
					${dto.user_reg} 
				</td>
				<td style="text-align:center">
					${dto.grade_name} 
				</td>
			</tr>
		</c:forEach>
	</c:if>
</table>

<br><br><br><br><br><br><br>




