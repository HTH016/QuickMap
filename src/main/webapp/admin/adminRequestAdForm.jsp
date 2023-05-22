<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

    

 
 <br><br>
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
 
 <h3> 광고 신청 관리 </h3>
 

<form method="post" action="adminrequestadpro.do" name="requestad">
	<table style="margin-left: auto; margin-right: auto;">
		
		<tr>
			<th style="width:10%">  </th>
			<th style="width:50%"> 업장명 </th>
			<th style="width:10%"> 신청일 </th>
			<th style="width:10%"> 시작일 </th>
			<th style="width:10%"> 종료일 </th>
			<th style="width:10%"> 레벨 </th>
		</tr>
		
		<c:if test="${count eq 0}">
			<tr>
				<td style="text-align:center" colspan="7">
					대기중인 신청 광고가 없습니다.
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
	
		<input class="inputbutton" type="submit" value="광고 승인">
		
</form>
<br><br><br><br><br><br><br>




