<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<script src="${project}member.js"></script>

<h2>아이디 중복확인</h2>

<c:if test="${result eq 0}">
	<table>
		<tr>
			<th style="width:300px"> ${user_id}는 사용할 수 있습니다 </th>
		</tr>
		<tr>
			<th>
				<input type="button" value="확인"
					onclick="setid('${user_id}')">
			</th>
		</tr>
	</table>
</c:if>
<c:if test="${result eq 1}">
	<form method="post" action="memberconfirmid.do" name="confirmidform" onsubmit="return confirmidcheck()">
		<table>
			<tr>
				<th colspan=2> ${user_id}는 사용할 수 없습니다 </th>
			</tr>
			<tr>
				<th> ID </th>
				<td> <input type="text" name="user_id" maxlength=30 autofocus> </td>
			</tr>
			<tr>
				<th colspan=2>
					<input type="submit" value="확인">
					<input type="button" value="확인 취소"
						onclick="self.close()">
				</th>
			</tr>
		</table>
	</form>
</c:if>