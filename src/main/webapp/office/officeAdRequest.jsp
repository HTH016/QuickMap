<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="setting_office.jsp"%>
<script src="${project}office.js"></script>

<h2> ${page_ad_request} </h2>
<c:if test="${sessionScope.memId == null}">
	<input type="button" value="${btn_login}" onclick="location='memberloginform.do'">
</c:if>
<c:if test="${sessionScope.memId != null}">
<form method="post" name="officeadrequest" action="officeadrequestpro.do" onsubmit="return adrequestcheck()">
	<table>
		<tr>
			<th> ${str_office_id} </th>
			<td> ${dto.office_id} </td>
		</tr>
		<tr>
			<th> ${str_ad_start} </th>
			<td> <input type="date" name="ad_request_start"> </td>
		</tr>
		<tr>
			<th> ${str_ad_end}</th>
			<td> <input type="date" name="ad_request_end"> </td>
		</tr>
		<tr>
			<th> ${str_ad_level} </th>
			<td> <input type="number" name="ad_request_level" max=7 min=1> </td>
		</tr>
		<tr>
			<th colspan=2>
				<input type="submit" value="${btn_request}">
				<input type="reset" value="${btn_cancel}">
				<input type="button" value="${btn_request_cancel}" onclick="location='membermodifyview.do'">
			</th>
		</tr>
	</table>
</form>
</c:if>