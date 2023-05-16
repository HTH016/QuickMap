<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

    

 
 <br><br>
 <h2>관리자 페이지</h2>
 
 <input class="inputbutton" type="button" value="회원 관리"
				onclick="location='adminUserListForm.jsp'">
<input class="inputbutton" type="button" value="업장 등록 관리"
				onclick="location='adminRegisterOfficeForm.jsp'">
<input class="inputbutton" type="button" value="업장 등급 관리"
				onclick="location='adminRequestGradeForm.jsp'">
<input class="inputbutton" type="button" value="광고 신청 관리"
				onclick="location='adminRequestAdForm.jsp'">
<input class="inputbutton" type="button" value="통계"
				onclick="location='adminStatics.jsp'">
 
 <h3> 업장 등급 신청 </h3>
 

<c:set var="templistnum" value="20"/>

<form method="post" action="adminrequestgradepro.do" name="requestpre">
	<table style="margin-left: auto; margin-right: auto;">
		
		<tr>
			<th style="width:5%">  </th>
			<th style="width:15%"> 작성자 </th>
			<th style="width:50%"> 업장명 </th>
			<th style="width:30%"> 신청일 </th>
			
	
		</tr>
		
		<c:if test="${templistnum eq 0}">
			<tr>
				<td style="text-align:center" colspan="3">
					대기중인 신청자가 없습니다.
				</td>
			</tr>
		</c:if>
		
		<c:if test="${templistnum ne 0 }">
			
			<c:forEach var="i" begin="0" end="${templistnum}">
				<tr>
					<td>
						<input type="checkbox" name="check_num">
					</td>
					<td style="text-align:center">
						zxcv1234
					</td>
					<td style="text-align:center">
						 AAA 피부과 
					</td>
					<td style="text-align:center">
						2022.07.28
					</td>
					
				</tr>
			</c:forEach>
		</c:if>
	</table>
	
	<input class="inputbutton" type="submit" value="등급 조정">
	
</form>
<br><br><br><br><br><br><br>


