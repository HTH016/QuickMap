<%@page import="member.MemberDataBean"%>
<%@page import="member.MemberDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="setting_member.jsp" %>
<script type="text/javascript" src="/quickmap/jquery-3.6.4.js"></script>

<script src="${project}member.js"></script>

<h2>${page_confirmnick}</h2>

<c:if test="${result eq 0}">
	<table>
		<tr>
			<th style="width:300px"> ${user_nick}${msg_use_o} </th>
		</tr>
		<tr>
			<th>
				<input type="button" value="${btn_ok}"
					onclick="setnick('${form}', '${user_nick}')">
			</th>
		</tr>
	</table>
</c:if>
<c:if test="${result eq 1}">
	<form method="post" action="memberconfirmnick.do" name="confirmnickform" onsubmit="return confirmnickcheck()">
		<table>
			<tr>
				<th colspan=2> ${user_nick}${msg_use_x} </th>
			</tr>
			<tr>
				<th> ${str_user_nick} </th>
				<td> <input type="text" name="user_nick" maxlength=30 autofocus> </td>
			</tr>
			<tr>
				<th colspan=2>
					<input type="submit" value="${btn_ok}">
					<input type="button" value="${btn_cancel}"
						onclick="self.close()">
				</th>
			</tr>
		</table>
	</form>
</c:if>