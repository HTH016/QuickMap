<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

    

 
 <br><br>
 <h2>관리자 페이지<h2>
 
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
				
 <h3> 회원 정보 수정 </h3>
 

<c:set var="templistnum" value="20"/>

<table style="margin-left: auto; margin-right: auto;">
	
	<tr>
		<th style="width:7%"> 업장명 </th>
		<th style="width:40%"> 후기 </th>
		<th style="width:7%"> 별점 </th>
		<th style="width:9%"> 작성일 </th>

	</tr>
	
	<c:if test="${templistnum eq 0}">
		<tr>
			<td style="text-align:center" colspan="4">
				닉네임(아이디)님의 리뷰가 없습니다.
			</td>
		</tr>
	</c:if>
	
	<c:if test="${templistnum ne 0 }">
		
		<c:forEach var="i" begin="0" end="${templistnum}">
			<tr>
				<td style="text-align:center">
					3층 내과
				</td>
				<td style="text-align:center">
					<a href="adminReviewForm.jsp">아아아아아아아아아ㅏ아아ㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅏㅏㅏㅏㅏ</a>
				</td>
				<td style="text-align:center">
					★★★★☆
				</td>
				<td style="text-align:center">
					2020/03/21
				</td>
			</tr>
		</c:forEach>
	</c:if>
</table>

<br><br><br><br><br><br><br>




<table style="margin-left: auto; margin-right: auto;">
	<tr>
		<th style="width:7%"> 업장명 </th>
		<th style="width:40%"> 후기 </th>
		<th style="width:7%"> 별점 </th>
		<th style="width:9%"> 작성일 </th>

	</tr>
	<tr>
		<td style="text-align:center">
			3층 내과
		</td>
		<td style="text-align:center">
			<a href="adminReviewForm.jsp">아아아아아아아아아ㅏ아아ㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅏㅏㅏㅏㅏ</a>
		</td>
		<td style="text-align:center">
			★★★★☆
		</td>
		<td style="text-align:center">
			2020/03/21
		</td>
	</tr>
	

</table>




<br><br><br><br><br><br>


