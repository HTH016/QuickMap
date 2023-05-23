<%@page import="review.ReviewDataBean"%>
<%@page import="review.ReviewDBBean"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="setting_review.jsp"%>

<h2> ${page_review}</h2>
<!-- 로그인해야 이용가능한 기능 -->
<c:if test="${sessionScope.memId == null}">
	<input type="button" value="확인" onclick="location='memberloginform.do'">
</c:if>
<c:if test="${sessionScope.memId != null}">
<table>	 	 
	<tr>
		<th style="width:7%"> ${str_review_id} </th>
		<th style="width:15%"> ${str_office_name} </th>
		<th style="width:40%"> ${str_review_data} </th>
		<th style="width:10%"> ${str_review_star}(${str_review_reg}) </th>
	</tr> 
	<c:if test="${reviewDao.getCount() eq 0}">
		<tr>
			<td style="text-align:center" colspan=5>
			작성한 리뷰가 존재하지 않습니다
			</td>
		</tr>
	</c:if>
	<c:if test="${reviewDao.getCount() ne 0}"></c:if>	
	<c:forEach var="dto" items="${dtos}">
	<tr>
		<td style="text-align:center">
			${dto.review_id}
		</td>
		<td style="text-align:center">
			${dto.office_name}
		</td>
		<td style="text-align:center">
			<a href="reviewmodifyview.do?review_id=${dto.review_id}">${dto.review_data}</a>
		</td>
		<td style="text-align:center">
			${dto.review_star}(<fmt:formatDate value="${dto.review_reg}" type="both" pattern="yyyy-MM-dd HH:mm:ss"/>)
		</td>
	</tr>
	</c:forEach>
</table>
</c:if>


