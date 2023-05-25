<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="setting_office.jsp"%>
<script src="${project}office.js"></script>

<h2> 업장 등록 신청 </h2>

<form method="post" action="officeregisterpro.do" name="officeregister"
	onsubmit="return registercheck()" enctype="multipart/form-data">
	<table>
		<tr>
			<th> 업장명 </th>
			<td> <input type="text" name="office_name" value="${dto.office_name}"> </td>
		</tr>
		<tr>
			<th> 주소 </th>
			<td> <input type="text" name="office_address" value="${dto.office_address}"> </td>
		</tr>
		<tr>
			<th> 사업자등록번호 </th>
			<td> <input type="text" name="office_regist_num" value="${dto.office_regist_num}"> </td>
		</tr>
		<tr>
			<th> 사업자등록증사진 </th>
			<td> <input type="file" name="office_regist_num_img"> </td>
		</tr>
		<tr>
			<th colspan=2>
				<input type="submit" value="신청">
				<input type="reset" value="취소">
				<input type="button" value="신청 취소" onclick="location='membermodifyview.do'">
			</th>
		</tr>
	</table>
</form>
