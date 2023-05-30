<%@page import="review.ReviewDataBean"%>
<%@page import="review.ReviewDBBean"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="setting_review.jsp"%>

<h2> ${page_reviewwrite}</h2>
<!-- 
<c:if test="${sessionScope.memId == null}">
	<input type="button" value="확인" onclick="location='memberloginform.do'">
</c:if>
<c:if test="${sessionScope.memId != null}"></c:if>
 -->
 
<form method="post" action="reviewwritepro.do" name="reviewwrite" onsubmit="return writecheck()">
	<table>
		<tr>
			<td> ${dto.office_name} </td>
		</tr>
		<tr>
			<td> <input type="text" name="review_star" maxlength=20> </td>
		</tr>
		<tr>
			<th> <textarea name="review_data" rows=10 cols=40 autofocus></textarea> </th>
		</tr>
		<tr>
			<th colspan=2>
				<input type="submit" value="${btn_write}">
				<input type="reset" value="${btn_cancel}">
				<input type="button" value="${btn_write_cancel}" onclick="location='main.do'">
			</th>
		</tr>
	</table>
</form>
