<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

    

 
 <br><br>
 <h2>관리자 페이지<h2>
 
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
 
 <h3> 업장 등록 신청 </h3>
 



<table style="margin-left: auto; margin-right: auto;">
	
	<tr>
		<th style="width:20%"> 작성자 </th>
		<th style="width:50%"> 업장명 </th>
		<th style="width:30%"> 신청일 </th>
		

	</tr>
	
	<c:if test="${count eq 0}">
		<tr>
			<td style="text-align:center" colspan="3">
				대기중인 신청자가 없습니다.
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




