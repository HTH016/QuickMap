<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<h2> 관리자 페이지 </h2>

<input class="inputbutton" type="button" value="회원 관리"
				onclick="location='adminuserlistform.do'">
<input class="inputbutton" type="button" value="업장 등록 관리"
				onclick="location='adminregisterofficeform.do'">
<input class="inputbutton" type="button" value="업장 등급 관리"
				onclick="location='adminrequestgradeform.do'">
<input class="inputbutton" type="button" value="광고 신청 관리"
				onclick="location='adminrequestadform.do'">
<input class="inputbutton" type="button" value="통계"
				onclick="location='statisticsadminform.do'">


<table border="1" style="margin-left: auto; margin-right: auto; margin-top: auto; margin-bottom: auto;">
	
	<tr>
		<th>${dto.office_name}</th>
		<td colspan="2"> </td>
	</tr>
	<tr>
		<td colspan="3"> <pre>${dto.review_data}</pre> </td>
	</tr>
	<tr>
		<td style="text-align:center"> ${dto.user_nick} </td>
		<td style="text-align:center"> ${dto.review_star} </td>
		<td style="text-align:center"> ${dto.review_reg} </td>
	</tr>
</table>

<input class="inputbutton" type="button" value="삭제"
				onclick="location='adminreviewpro.do?review_id=${dto.review_id}&user_id=${dto.user_id}'">
		





























