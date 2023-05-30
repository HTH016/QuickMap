<%@page import="review.ReviewDataBean"%>
<%@page import="review.ReviewDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="setting_review.jsp"%>
<h2> ${page_review_modify} </h2>

<form method="post" action="reviewmodifypro.do" name="reviewmodify" onsubmit="return modifycheck()">
	<input type="hidden" name="review_id" value="${dto.review_id}">
	<table>
		<tr>
			<td> ${dto.office_name} </td>
		</tr>
		<tr>
			<td> <input type="text" name="review_star" maxlength=20 value="${dto.review_star}"> </td>
		</tr>
		<tr>
			<th> <textarea name="review_data" rows=10 cols=40 autofocus>${dto.review_data}</textarea> </th>
		</tr>
		<tr>
			<th colspan=2>
				<input type="submit" value="${btn_modify}">
				<input type="reset" value="${btn_cancel}">
				<input type="button" value="${btn_modify_cancel}" onclick="location='reviewlist.do'">
			</th>
		</tr>
	</table>
</form>
