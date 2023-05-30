<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="setting_office.jsp"%>
<script src="${project}office.js"></script>

<h2> ${page_register} </h2>

<form method="post" action="officeregisterpro.do" name="officeregister"
	onsubmit="return registercheck()" enctype="multipart/form-data">
	<table>
		<tr>
			<th> ${str_office_name} </th>
			<td> <input type="text" name="office_name" value="${dto.office_name}"> </td>
		</tr>
		<tr>
			<th> ${str_office_address} </th>
			<td> <input type="text" name="office_address" value="${dto.office_address}"> </td>
		</tr>
		<tr>
			<th> ${str_office_regist_num} </th>
			<td> <input type="text" name="office_regist_num" value="${dto.office_regist_num}"> </td>
		</tr>
		<tr>
			<th> ${str_office_regist_img} </th>
			<td> <input type="file" name="office_regist_num_img"> </td>
		</tr>
		<tr>
			<th colspan=2>
				<input type="submit" value="${btn_request}">
				<input type="reset" value="${btn_cancel}">
				<input type="button" value="${btn_request_cancel}" onclick="location='main.do'">
			</th>
		</tr>
	</table>
</form>
