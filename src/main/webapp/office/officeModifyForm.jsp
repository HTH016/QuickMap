<%@page import="office.OfficeDataBean"%>
<%@page import="office.OfficeDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="setting_office.jsp"%>
<script src="${project}office.js"></script>

<h2>${page_office_modify}</h2>

<c:if test="${sessionScope.memId == null}">
	<input type="button" value="확인" onclick="location='memberloginform.do'">
</c:if>
<c:if test="${sessionScope.memId != null}">
<form method="post" action="officemodifypro.do" name="officemodify" onsubmit="return modifycheck()">
	<table border=1>
		<tr>
			<th colspan=2> ${str_user_id} </th>
			<td colspan=2> &nbsp;${dto.user_id} </td>
		</tr>
		<tr>
			<th colspan=2> ${str_grade_id} </th>
			<td colspan=2> &nbsp;${dto.grade_id} </td>
		</tr>
		<tr>
			<th colspan=2> ${str_office_regist_num} </th>
			<td colspan=2> &nbsp;${dto.office_regist_num} </td>
		</tr>
		<tr>
			<th colspan=2> ${str_office_name} </th>
			<td colspan=2> &nbsp;${dto.office_name} </td>
		</tr>
		<tr>
			<th colspan=2> ${str_office_address} </th>
			<td colspan=2> &nbsp;${dto.office_address} </td>
		</tr>
		<tr>
			<th colspan=2> ${str_office_class} </th>
			<td colspan=2> &nbsp;${dto.office_class} </td>
		</tr>
		<tr>
			<th colspan=2> ${str_service_id} </th>
			<td colspan=2>
				<input type="text" name="service_id" maxlength=50 value="${dto.service_id}" style="width:300px">
			</td>
		</tr>
		<tr>
			<th colspan=2> ${str_office_tel} </th>
			<td colspan=2>
				<input type="text" name="office_tel" maxlength=50 value="${dto.office_tel}" style="width:300px">
			</td>
		</tr>
		<tr>
			<th colspan=2> ${str_office_image} </th>
			<td colspan=2>
				<c:set var="i" value="${fn:split(dto.office_image, ',')}"/>
				<input type="text" name="image1" maxlength=100 value="${i[0]}" style="width:90px">
				, <input type="text" name="image2" maxlength=100 value="${i[1]}" style="width:90px">
				, <input type="text" name="image3" maxlength=100 value="${i[2]}" style="width:90px">
			</td>
		</tr>
		<tr>
			<th colspan=2> ${str_office_keyword} </th>
			<td colspan=2>
				<c:set var="k" value="${fn:split(dto.office_keyword, ',')}"/>
				<input type="text" name="keyword1" maxlength=10 value="${k[0]}" style="width:65px">
				, <input type="text" name="keyword2" maxlength=10 value="${k[1]}" style="width:65px">
				, <input type="text" name="keyword3" maxlength=10 value="${k[2]}" style="width:65px">
				, <input type="text" name="keyword4" maxlength=10 value="${k[3]}" style="width:65px">
			</td>
		</tr>
		<tr>
			<th colspan=2> ${str_office_business_hours_noti} </th>
			<td colspan=2>
				<input type="text" name="office_business_hours_noti" maxlength=30 value="${dto.office_business_hours_noti}" style="width:300px">
			</td>
		</tr>
		<tr>
			<th> ${str_office_start_mon} </th>
			<td>
				<input type="text" name="office_start_mon" maxlength=30 value="${dto.office_start_mon}">
			</td>
			<th> ${str_office_end_mon} </th>
			<td>
				<input type="text" name="office_end_mon" maxlength=30 value="${dto.office_end_mon}">
			</td>
		</tr>
		<tr>
			<th> ${str_office_start_tue} </th>
			<td>
				<input type="text" name="office_start_tue" maxlength=30 value="${dto.office_start_tue}">
			</td>
			<th> ${str_office_end_tue} </th>
			<td>
				<input type="text" name="office_end_tue" maxlength=30 value="${dto.office_end_tue}">
			</td>
		</tr>
		<tr>
			<th> ${str_office_start_wed} </th>
			<td>
				<input type="text" name="office_start_wed" maxlength=30 value="${dto.office_start_wed}">
			</td>
			<th> ${str_office_end_wed} </th>
			<td>
				<input type="text" name="office_end_wed" maxlength=30 value="${dto.office_end_wed}">
			</td>
		</tr>
		<tr>
			<th> ${str_office_start_thu} </th>
			<td>
				<input type="text" name="office_start_thu" maxlength=30 value="${dto.office_start_thu}">
			</td>
			<th> ${str_office_end_thu} </th>
			<td>
				<input type="text" name="office_end_thu" maxlength=30 value="${dto.office_end_thu}">
			</td>
		</tr>
		<tr>
			<th> ${str_office_start_fri} </th>
			<td>
				<input type="text" name="office_start_fri" maxlength=30 value="${dto.office_start_fri}">
			</td>
			<th> ${str_office_end_fri} </th>
			<td>
				<input type="text" name="office_end_fri" maxlength=30 value="${dto.office_end_fri}">
			</td>
		</tr>
		<tr>
			<th> ${str_office_start_sat} </th>
			<td>
				<input type="text" name="office_start_sat" maxlength=30 value="${dto.office_start_sat}">
			</td>
			<th> ${str_office_end_sat} </th>
			<td>
				<input type="text" name="office_end_sat" maxlength=30 value="${dto.office_end_sat}">
			</td>
		</tr>
		<tr>
			<th> ${str_office_start_sun} </th>
			<td>
				<input type="text" name="office_start_sun" maxlength=30 value="${dto.office_start_sun}">
			</td>
			<th> ${str_office_end_sun} </th>
			<td>
				<input type="text" name="office_end_sun" maxlength=30 value="${dto.office_end_sun}">
			</td>
		</tr>
		<tr>
			<th colspan=4>
				<input type="submit" value="수정">
				<input type="reset" value="취소">
				<input type="button" value="수정취소" onclick="location='membermodifyview.do'">
			</th>
		</tr>
	</table>
</form>
</c:if>
