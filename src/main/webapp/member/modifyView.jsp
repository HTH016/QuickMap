<%@page import="java.text.SimpleDateFormat"%>
<%@page import="member.MemberDataBean"%>
<%@page import="member.MemberDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="setting_member.jsp" %>
<script type="text/javascript" src="/quickmap/jquery-3.6.4.js"></script>
<script src="${project}member.js"></script>

<h2>${page_modify}</h2>

<c:if test="${sessionScope.memId == null}">
	<input type="button" value="${btn_login}" onclick="location='memberloginform.do'">
</c:if>
<c:if test="${sessionScope.memId != null}">
	<form method="post" action="membermodifypro.do" name="modifyform" onsubmit="return modifycheck()">
		<table>
			<tr>
				<th colspan=2> ${page_modify} </th>
			</tr>
			<tr>
				<th> ${str_user_id} </th>
				<td> &nbsp;${dto.user_id} </td>
			</tr>
			<tr>
				<th rowspan=2> ${str_user_passwd} </th>
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
				<th> ${str_user_name} </th>
				<td> &nbsp; ${dto.user_name} </td>
			</tr>
			<tr>
				<th> ${str_user_nick} </th>
				<td> &nbsp; ${dto.user_nick} </td>
				<td>
					<input type="text" name="nick" maxLength="30" autofocus
							value="${dto.getUser_nick()}">
					<input type="button" value="${btn_confirm}"
							onclick="confirmnick('modifyform')">
				</td>
			</tr>
			<tr>
				<th> ${str_user_tel} </th>
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
				<th> ${str_user_email} </th>
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
				<th> ${str_user_reg_date} </th>
				
				<td>
					&nbsp; <fmt:formatDate value="${dto.user_reg}" type="both" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
			</tr>
			<tr>
				<th> ${str_user_grade_id} </th>
				<td>
					<c:if test="${dto.grade_id eq 2 or dto.grade_id eq 1}">
						&nbsp; ${dto.grade_id}
					</c:if>
					<c:if test="${dto.grade_id eq 3}">
						&nbsp; ${dto.grade_id}
						<input type="button" value="${btn_office_modify}" onclick="location='officemodifyform.do'">
						<input type="button" value="${btn_office_review}" onclick="location='reviewlistbyoffice.do'">
						<input type="button" value="${btn_ad_requset}" onclick="location='officeadrequest.do'">
						<input type="button" value="${btn_premium}" onclick="premium()">
					</c:if>
					<c:if test="${dto.grade_id eq 9}">
						&nbsp; ${dto.grade_id}
						<input type="button" value="${btn_admin}" onclick="location='adminuserlistform.do'">
					</c:if>
				</td>
			</tr>
			<tr>
				<th colspan=2>
					<input type="submit" value="${btn_modify}">
					<input type="reset" value="${btn_cancel}">
					<input type="button" value="${btn_favorite}" onclick="location='favoritelist.do'">
					<input type="button" value="${btn_review}" onclick="location='reviewlist.do'">
					<input type="button" value="${btn_modify_cancel}" onclick="location='main.do'">
					<input type="button" value="${btn_delete}" onclick="location='memberdeleteform.do'">
				</th>
			</tr>
		</table>
	</form>
</c:if>
<script type="text/javascript">
	function premium() {
		if(confirm("월 300,000원의 프리미엄 서비스 이용료가 부과됩니다. 신청하시겠습니까?") == true) {
			location.href="officegraderequest.do";
			return true;
		} else {
			return false;
		}
	}
</script>

