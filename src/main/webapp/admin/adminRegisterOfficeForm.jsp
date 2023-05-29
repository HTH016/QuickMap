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
${btn_admin_office}
</h3>	


<table style="margin-left: auto; margin-right: auto;" border="1" width="70%">
	
	<tr>
		<th style="width:20%"> ${str_writer} </th>
		<th style="width:50%"> ${str_office_name} </th>
		<th style="width:30%"> ${str_request_date} </th>
		

	</tr>
	
	<c:if test="${count eq 0}">
		<tr>
			<td style="text-align:center" colspan="3">
				${str_no_request_regist}
			</td>
		</tr>
	</c:if>
	
	<c:if test="${count ne 0 }">
		
		<c:forEach var="dto" items="${dtos}">
			<tr>
				<td style="text-align:center">
					${dto.user_id} 
				</td>
				<td style="text-align:center">
					<a href="adminregisterofficeconfirmform.do?regist_request_id=${dto.regist_request_id}">
						${dto.office_name}  
					</a>
				</td>
				<td style="text-align:center">
					${dto.office_regist_submit} 
				</td>
			
			</tr>
		</c:forEach>
	</c:if>
</table>

<br><br><br><br><br><br><br>




