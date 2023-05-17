<%@page import="java.text.SimpleDateFormat"%>
<%@page import="member.MemberDataBean"%>
<%@page import="member.MemberDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
<script src="${project}member.js"></script>

<h2>회원정보수정</h2>

<c:if test="${result eq 0}">
	<script type="text/javascript">
		erroralert(passerror);
	</script>
</c:if>
<c:if test="${result eq 1}">
	<form method="post" action="membermodifypro.do" name="modifyform" onsubmit="modifycheck()">
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
				&nbsp; <fmt:formatDate value="${dto.user_reg_date}" type="both" pattern="yyyy-MM-dd HH:mm:ss"/>
			</td>
		</tr>
		<tr>
			<th> 회원등급 </th>
			<td>
				<c:if test="${dto.user_grade_id eq 0}">
					&nbsp; ${dto.user_grage_id}
				</c:if>
				<c:if test="${dto.user_grade_id ne 0}">
					&nbsp; ${dto.user_grage_id}
					<input type="button" value="수정" onclick="location='업장수정'">
				</c:if>
			</td>
		</tr>
		<tr>
			<th colspan=2>
				<input class="inputbutton" type="submit" value="수정">
				<input class="inputbutton" type="reset" value="취소">
				<input class="inputbutton" type="button" value="수정취소"
					onclick="location='지도'">
			</th>
		</tr>
	</table>
</form>
</c:if>