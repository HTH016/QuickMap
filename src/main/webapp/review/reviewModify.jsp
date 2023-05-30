<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="setting_review.jsp"%>
<h2> ${page_review_modify} </h2>

<c:if test="${sessionScope.memId == null}">
	<h3>${msg_login_x}</h3>
	<br>
	<input type="button" value="${btn_main}" onclick="location='main.do'">
</c:if>

<c:if test="${sessionScope.memId != null}">
	<form method="post" action="reviewmodifypro.do" name="reviewmodify" onsubmit="return modifycheck()">
		<input type="hidden" name="review_id" value="${dto.review_id}">
		<input type="hidden" name="nextPage" value="${nextPage}">
		<input type="hidden" name="officeId" value="${officeId}">
		<table>
			<tr>
				<td> ${str_user_id}</td>
				<td> ${userNick} </td>
			</tr>
			<tr>
				<td> ${str_office_name} </td>
				<td> ${officeName} </td>
			</tr>
			<tr>
				<td> ${str_review_star} </td>
				<td> <input type="number" name="review_star" max=5 min=1 step=0.1 value="${dto.review_star}"> </td>
			</tr>
			<tr>
				<td> ${str_review_data} </td>
				<td> <textarea name="review_data" rows=10 cols=40 autofocus>${dto.review_data}</textarea> </td>
			</tr>
			<tr>
				<th colspan=2>
					<input type="submit" value="${btn_modify}">
					<input type="reset" value="${btn_cancel}">
					<input type="button" value="${btn_modify_cancel}" onclick="location='${nextPage}.do'">
				</th>
			</tr>
		</table>
	</form>
</c:if>
