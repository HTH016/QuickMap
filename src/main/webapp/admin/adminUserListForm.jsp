<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

    

 
 <br><br>
 <h2>관리자 페이지</h2>
 <br>
 
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
 
<form method="post" action="adminuserlistform.do" name="usersort">
	<select name="usersort">
		<option value="0" selected>가입일자(최신순)</option>
		<option value="1">가입일자(오래된순)</option>
		<option value="2">일반회원</option>
		<option value="3">등록회원</option>
	</select>
		<input class="button" type="submit" value="정렬">
</form>

<form method="post" action="adminuserlistform.do" name="usersort">
 <select name="usersearch">
  	<option value="0" selected>아이디</option>
  	<option value="1">닉네임</option>
  	
</select>
  	<input class="input" type="text" name="usersearchword">
	<input class="button" type="submit" value="정렬">
</form>	

<c:set var="templistnum" value="20"/>

<table style="margin-left: auto; margin-right: auto;">
	
	<tr>
		<th style="width:7%"> 아이디 </th>
		<th style="width:40%"> 닉네임 </th>
		<th style="width:7%"> 가입일자 </th>
		<th style="width:9%"> 등급 </th>

	</tr>
	
	<c:if test="${templistnum eq 0}">
		<tr>
			<td style="text-align:center" colspan="4">
				등록된 회원이 없습니다.
			</td>
		</tr>
	</c:if>
	
	<c:if test="${templistnum ne 0 }">
		
		<c:forEach var="i" begin="0" end="${templistnum}">
			<tr>
				<td style="text-align:center">
					<a href="adminUserInfoForm.jsp">asdf123</a>
				</td>
				<td style="text-align:center">
					닉네임
				</td>
				<td style="text-align:center">
					2023/05/16
				</td>
				<td style="text-align:center">
					일반
				</td>
			</tr>
		</c:forEach>
	</c:if>
</table>

<br><br><br><br><br><br><br>




