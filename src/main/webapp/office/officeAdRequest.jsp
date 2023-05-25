<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="setting_office.jsp"%>
<script src="${project}office.js"></script>

<h2> 광고 신청 </h2>
<c:if test="${sessionScope.memId == null}">
	<input type="button" value="로그인" onclick="location='memberloginform.do'">
</c:if>
<c:if test="${sessionScope.memId != null}">
<form method="post" name="officeadrequest" action="officeadrequestpro.do" onsubmit="return adrequestcheck()">
	<table>
		<tr>
			<th> 업장 id </th>
			<td> ${dto.office_id} </td>
		</tr>
		<tr>
			<th> 광고 시작일 </th>
			<td> <input type="date" name="ad_request_start"> </td>
		</tr>
		<tr>
			<th> 광고 종료일 </th>
			<td> <input type="date" name="ad_request_end"> </td>
		</tr>
		<tr>
			<th> 광고 레벨 </th>
			<td> <input type="text" name="ad_request_level"> </td>
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
</c:if>