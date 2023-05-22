<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="setting_map.jsp"%>
<link href="${project}style_map.css" rel="stylesheet" type="text/css">
<script src="${project}script_map.js"></script>

<c:if test="${user_id eq null}">
	<form method="post" action="memberloginform.do" name="user_beforeloginform">
		<table>
			<tr>
				<td>
					<input type="submit" value="${btn_login}">
				</td>
			</tr>
			<tr>
				<td>
					<a href="memberinputform.do">${str_id}</a>
				</td>
			</tr>
		</table>
	</form>
</c:if>

<c:if test="${user_id ne null}">
	<form method="post" action="membermodifyview.do" name="user_afterloginform">
		<table>
			<tr>
				<td rowspan="3">
					<img alt="user image" src="${images}default-profile.png" width="100px" height="100px">
				</td>
				<td colspan="2">
					<h3>${user_nick}</h3>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<h4>${user_id}</h4>
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="${str_mypage}">
				</td>
				<td>
					<input type="button" value="${str_logout}" onclick="location='memberlogout.do'">
				</td>
			</tr>
		</table>
	</form>
</c:if>

