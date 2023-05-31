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
${page_admin_ad}
</h3>	

	<form method="post" action="adminrequestadpro.do" name="requestad">
		<table style="margin-left: auto; margin-right: auto;"  border="1" width="70%">
			<tr>
				<th style="width:3%"> </th>
				<th style="width:50%"> ${str_office_name} </th>
				<th style="width:10%"> ${str_request_date} </th>
				<th style="width:10%"> ${str_ad_start} </th>
				<th style="width:10%"> ${str_ad_end} </th>
				<th style="width:10%"> ${str_ad_level} </th>
			</tr>	
			<c:if test="${count eq 0}">
				<tr>
					<td style="text-align:center" colspan="6">
						${str_no_request_ad}
					</td>
				</tr>
			</c:if>
			<c:if test="${count ne 0 }">
				<c:forEach var="dto" items="${dtos}">
					<tr>
						<td>
							<input type="checkbox" name="adselect" value="${dto.ad_request_id}">
						</td>
						<td style="text-align:center">
							${dto.office_name} 
						</td>
						<td style="text-align:center">
							${dto.ad_request_submit} 
						</td>
						<td style="text-align:center">
							${dto.ad_request_start} 
						</td>
						<td style="text-align:center">
							${dto.ad_request_end} 
						</td>
						<td style="text-align:center">
							${dto.ad_request_level} 
						</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
	<br>	
		<input class="inputbutton" type="submit" value="${btn_office_ad_ok}">
	</form>
<br><br><br><br><br>




