<%@page import="review.ReviewDataBean"%>
<%@page import="review.ReviewDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="setting_review.jsp"%>
<h2> 리뷰 확인(수정X) </h2>

<form method="post" action="reviewdelete.do" onsubmit="return deletedata()">
	<input type="hidden" name="review_id" value="${dto.review_id}">
	<table>
		<tr>
			<td> ${dto.office_name} </td>
		</tr>
		<tr>
			<td> ${dto.review_star} </td>
		</tr>
		<tr>
			<th> ${dto.review_data} </th>
		</tr>
		<tr>
			<th colspan=2>
				<input type="button" value="수정"
				onclick="location='reviewmodify.do?review_id=${dto.review_id}'">
				<input type="submit" value="삭제">
			</th>
		</tr>
	</table>
</form>

<script type="text/javascript">
	function deletedata() {
		if(confirm("정말 삭제하시겠습니까?") == true) {
			return true;
		} else {
			return false;
		}
	}
</script>