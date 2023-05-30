<%@page import="favorite.FavoriteDataBean"%>
<%@page import="favorite.FavoriteDBBean"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="setting_favorite.jsp"%>

<h2> ${page_favorite} </h2>

<!-- 로그인해야 이용가능한 기능-->
<c:if test="${sessionScope.memId == null}">
	<input type="button" value="${btn_ok}" onclick="location='memberloginform.do'">
</c:if>
<c:if test="${sessionScope.memId != null}">
<table>
	<tr>
		<th style="width:7%"> ${str_favorite_id} </th>
		<th style="width:15%"> ${str_office_name} </th>
		<th style="width:40%"> ${str_office_address} </th>
		<th style="width:5%"> ${str_office_star}(${str_office_review_num}) </th>
		<th style="width:15%"> ${str_favorite_reg} </th>
	</tr>
	<c:if test="${favoriteDao.getFavoriteCount eq 0}">
		<tr>
			<td style="text-align:center" colspan=5>
			${msg_favorite_x}
			</td>
		</tr>
	</c:if>
	<c:if test="${favoriteDao.getFavoriteCount ne 0}"></c:if>
	<c:forEach var="dto" items="${dtos}">
		<tr>
			<td style="text-align:center"> 
				${dto.favorite_id}
			</td>
			<td style="text-align:center">
				<a href="#">${dto.office_name}</a>
			</td>
			<td style="text-align:center">
				${dto.office_address}
			</td>
			<td style="text-align:center">
				${dto.office_star}(${dto.office_review_num})
			</td>
			<td style="text-align:center">
				<fmt:formatDate value="${dto.favorite_reg}" type="both" pattern="yyyy-MM-dd HH:mm:ss"/>
			</td>
		</tr>
	</c:forEach>
</table>
</c:if> 

