<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="setting_review.jsp"%>

<h2> ${page_reviewwrite}</h2>

<c:if test="${sessionScope.memId == null}">
	<h3>${msg_login_x}</h3>
	<br>
	<input type="button" value="${btn_main}" onclick="location='main.do'">
</c:if>

<c:if test="${sessionScope.memId != null}">
	<form method="post" action="reviewwritepro.do" name="reviewwrite" onsubmit="return writecheck()">
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
				<td> <input type="text" name="review_star" maxlength=20> </td>
			</tr>
			<tr>
				<td> ${str_review_data} </td>
				<td> <textarea name="review_data" rows=10 cols=40 autofocus></textarea> </td>
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
</c:if>
 
