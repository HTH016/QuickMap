<%@page import="review.ReviewDataBean"%>
<%@page import="review.ReviewDBBean"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="setting_review.jsp"%>

<h2> ${page_reviewoffice}</h2>
<table>	 	 
	<tr>
		<th style="width:7%"> ${str_review_id} </th>
		<th style="width:10%"> ${str_user_id} </th>
		<th style="width:40%"> ${str_review_data} </th>
		<th style="width:15%"> ${str_review_star}(${str_review_reg}) </th>
	</tr>
	<c:forEach var="dto" items="${review}">
	<tr>
		<td style="text-align:center">
			${dto.review_id}
		</td>
		<td style="text-align:center">
			${dto.user_id}
		</td>
		<td style="text-align:center">
			${dto.review_data}
		</td>
		<td style="text-align:center">
			${dto.review_star}(<fmt:formatDate value="${dto.review_reg}" type="both" pattern="yyyy-MM-dd HH:mm:ss"/>)
		</td>
	</tr>
	</c:forEach>
</table>

