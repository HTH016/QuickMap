<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="setting_map.jsp"%>

<body>

<c:if test="${sessionScope.memId eq null}">
	<form method="post" action="memberloginform.do" name="user_beforeloginform">
		<table>
			<tr>
				<td>
					<input type="submit" value="퀵맵 로그인">
				</td>
			</tr>
			<tr>
				<td>
					<a href="memberinputform.do">회원가입</a>
				</td>
			</tr>
		</table>
	</form>
</c:if>

<c:if test="${sessionScope.memId ne null}">
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
					<h4>${sessionScope.memId}</h4>
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="마이페이지">
				</td>
				<td>
					<input type="button" value="로그아웃" onclick="location='memberlogout.do'">
				</td>
			</tr>
		</table>
	</form>
</c:if>

</body>