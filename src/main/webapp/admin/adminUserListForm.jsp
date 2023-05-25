<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

    

 
 <br><br>
 <h2>관리자 페이지</h2>
 <br>
 
<input class="inputbutton" type="button" value="회원 관리"
				onclick="location='adminuserlistform.do'">
<input class="inputbutton" type="button" value="업장 등록 관리"
				onclick="location='adminregisterofficeform.do'">
<input class="inputbutton" type="button" value="업장 등급 관리"
				onclick="location='adminrequestgradeform.do'">
<input class="inputbutton" type="button" value="광고 신청 관리"
				onclick="location='adminrequestadform.do'">
<input class="inputbutton" type="button" value="통계"
				onclick="location='statisticsadminform.do'">
 
<form method="post" action="adminuserlistoptionsortform.do" name="usersortby">
	<select name="usersort">
		<option value="1" selected>가입일자(최신순)</option>
		<option value="2">가입일자(오래된순)</option>
		<option value="3">일반회원</option>
		<option value="4">등록회원</option>
	</select>
		<input class="button" type="submit" value="정렬">
</form>

<form method="post" action="adminuserlistoptionselectform.do" name="userselectby">
 <select name="userselect">
  	<option value="5" selected>아이디</option>
  	<option value="6">닉네임</option>
  	
</select>
  	<input class="input" type="text" name="usersearchword">
	<input class="button" type="submit" value="검색">
</form>	




<table style="margin-left: auto; margin-right: auto;">
	
	<tr>
		<th style="width:7%"> 아이디 </th>
		<th style="width:40%"> 닉네임 </th>
		<th style="width:7%"> 가입일자 </th>
		<th style="width:9%"> 등급 </th>

	</tr>
	
	<c:if test="${count eq 0}">
	
	
		<tr>
			<td style="text-align:center" colspan="4">
				등록된 회원이 없습니다.
			</td>
		</tr>
	</c:if>
	
	<c:if test="${count ne 0 }">  ${count}
		
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




