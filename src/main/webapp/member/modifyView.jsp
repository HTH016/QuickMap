<%@page import="java.text.SimpleDateFormat"%>
<%@page import="member.MemberDataBean"%>
<%@page import="member.MemberDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="setting_member.jsp" %>
<script type="text/javascript" src="/quickmap/jquery-3.6.4.js"></script>
<script src="${project}member.js"></script>

<h2>회원정보수정</h2>

<c:if test="${sessionScope.memId == null}">
	<input type="button" value="확인" onclick="location='memberloginform.do'">
</c:if>
<c:if test="${sessionScope.memId != null}">
	<form method="post" action="membermodifypro.do" name="modifyform" onsubmit="return modifycheck()">
	<table>
		<tr>
				<th colspan=2> 회원정보수정 </th>
		</tr>
		<tr>
			<th> ID </th>
			<td> &nbsp;${dto.user_id} </td>
		</tr>
		<tr>
			<th rowspan=2> PW </th>
			<td> <input type="password" name="user_passwd" maxlength=30
				autofocus value="${dto.user_passwd}">
			</td>
		</tr>
		<tr>
			<td>
				<input type="password" name="user_repasswd" maxlength=30
				value="${dto.user_passwd}">
			</td>
		</tr>
		<tr>
			<th> 이름 </th>
			<td> &nbsp; ${dto.user_name} </td>
		</tr>
		<tr>
			<th> 닉네임 </th>
			<td> &nbsp; ${dto.user_nick} </td>
				<td>
					<input type="text" name="nick" maxLength="30" autofocus
							value="${dto.getUser_nick()}">
					<input type="button" value="중복확인"
							onclick="confirmnick('modifyform')">
				</td>
		</tr>
		<tr>
			<th> 전화번호 </th>
			<td>
				<c:if test="${dto.user_tel eq null}">
					<input type="text" name="tel1" maxlength=3 style="width:30px">
					- <input type="text" name="tel2" maxlength=4 style="width:40px">
					- <input type="text" name="tel3" maxlength=4 style="width:40px">
				</c:if>
				<c:if test="${dto.user_tel ne null}">
					<c:set var="t" value="${fn:split(dto.user_tel, '-')}"/>
					<input type="text" name="tel1" maxlength=3 style="width:30px" value="${t[0]}">
					- <input type="text" name="tel2" maxlength=4 style="width:40px" value="${t[1]}">
					- <input type="text" name="tel3" maxlength=4 style="width:40px" value="${t[2]}">
				</c:if>
			</td>
		</tr>
		<tr>
			<th> 이메일 </th>
			<td>
				<c:if test="${dto.user_email eq null}">
					<input type="text" name="email1" maxlength=25 style="width:100px">
					@ <input type="text" name="email2" maxlength=25 style="width:100px">
				</c:if>
				<c:if test="${dto.user_email ne null}">
					<c:set var="e" value="${fn:split(dto.user_email, '@')}"/>
					<input type="text" name="email1" maxlength=25
						value="${e[0]}" style="width:100px">
					@ <input type="text" name="email2" maxlength=25
						value="${e[1]}" style="width:100px">
				</c:if>
			</td>
		</tr>
		<tr>
			<th> 가입일자 </th>
			
			<td>
					&nbsp; <fmt:formatDate value="${dto.user_reg}" type="both" pattern="yyyy-MM-dd HH:mm:ss"/>
			</td>
		</tr>
		<tr>
			<th> 회원등급 </th>
			<td>
					<c:if test="${dto.grade_id eq 2}">
						&nbsp; ${dto.grade_id}
				</c:if>
					<c:if test="${dto.grade_id eq 3}">
						&nbsp; ${dto.grade_id}
						<input type="button" value="업장수정" onclick="location='officemodifyform.do'">
				</c:if>
				</td>
			</tr>
			<tr>
				<th colspan=2>
					<input type="submit" value="수정">
					<input type="reset" value="취소">
					<input type="button" value="즐겨찾기" onclick="location='favoritelist.do'">
					<input type="button" value="이용후기" onclick="location='reviewlist.do'">
					<input type="button" value="수정취소" onclick="location='map_main.do'">
				</th>
			</tr>
		</table>
</form>
</c:if>