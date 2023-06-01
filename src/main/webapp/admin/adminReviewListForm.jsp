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
 ${user_id} ${str_review_writer} 
 </h3>
 
<table style="margin-left: auto; margin-right: auto;" border="1" width="70%">
	<tr>
		<th style="width:20%"> ${str_office_name} </th>
		<th style="width:30%"> ${str_review} </th>
		<th style="width:7%"> ${str_star} </th>
		<th style="width:9%"> ${str_reg_date} </th>
	</tr>
	<c:if test="${count eq 0}">
		<tr>
			<td style="text-align:center" colspan="4">
				${user_nick}(${user_id})${str_no_review}
			</td>
		</tr>
	</c:if>
	<c:if test="${count ne 0 }">
		<c:forEach var="dto" items="${dtos}">
			<tr>
				<td style="text-align:center">
					${dto.office_name}
				</td>
				<td style="text-align:center">
					<a href="adminreviewform.do?review_id=${dto.review_id}">
						${dto.review_data}
					</a>
				</td>
				<td style="text-align:center">
					${dto.review_star}
				</td>
				<td style="text-align:center">
					${dto.review_reg}
				</td>
			</tr>
		</c:forEach>
	</c:if>
</table>

<br><br><br><br><br>




