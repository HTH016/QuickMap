<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 
    

 
 <br><br>

 <br>





<h3>세부 정보</h3>
 
 <input type="date" name="day" min="1977-01-01" max="2023-12-31">

<input type="date" name="day" min="1977-01-01" max="2023-12-31">

<table style="margin-left: auto; margin-right: auto;">
	
	<tr>
		<th style="width:30%"> detail_date </th>
		<th style="width:30%"> count </th>


	</tr>

		
		<c:forEach var="dtoDetail" items="${dtosDetail}">
			<tr>
				<td style="text-align:center">
					${dtoDetail.detail_date}
				</td>
				<td style="text-align:center">
					${dtoDetail.count} 
				</td>

			</tr>
		</c:forEach>

</table>


 

<h3>즐겨찾기</h3>
 <br>
 
<input type="date" name="day" min="1977-01-01" max="2023-12-31">

<input type="date" name="day" min="1977-01-01" max="2023-12-31">

<table style="margin-left: auto; margin-right: auto;">
	
	<tr>
		<th style="width:30%"> favorite_reg </th>
		<th style="width:30%"> count </th>


	</tr>

		
		<c:forEach var="dtoFavorite" items="${dtosFavorite}">
			<tr>
				<td style="text-align:center">
					${dtoFavorite.favorite_reg}
				</td>
				<td style="text-align:center">
					${dtoFavorite.count} 
				</td>

			</tr>
		</c:forEach>

</table>






<h3>리뷰</h3>
 <br>

<input type="date" name="day" min="1977-01-01" max="2023-12-31">

<input type="date" name="day" min="1977-01-01" max="2023-12-31">

<table style="margin-left: auto; margin-right: auto;">
	
	<tr>
		<th style="width:30%"> review_reg </th>
		<th style="width:30%"> count </th>


	</tr>

		
		<c:forEach var="dtoReview" items="${dtosReview}">
			<tr>
				<td style="text-align:center">
					${dtoReview.review_reg}
				</td>
				<td style="text-align:center">
					${dtoReview.count} 
				</td>

			</tr>
		</c:forEach>

</table>




<h3>광고 내역</h3>
 <br>


<input type="date" name="day" min="1977-01-01" max="2023-12-31">

<input type="date" name="day" min="1977-01-01" max="2023-12-31">

<table style="margin-left: auto; margin-right: auto;">
	
	<tr>
		<th style="width:15%"> ad_request_id </th>
		<th style="width:15%"> ad_request_start </th>
		<th style="width:15%"> ad_request_end </th>
		<th style="width:15%">  ad_request_level </th>

	</tr>

		
		<c:forEach var="dtoAd" items="${dtosAd}">
			<tr>
				<td style="text-align:center">
					${dtoAd.ad_request_id}
				</td>
				<td style="text-align:center">
					${dtoAd.ad_request_start} 
				</td>
				<td style="text-align:center">
					${dtoAd.ad_request_end} 
				</td>
				<td style="text-align:center">
					${dtoAd.ad_request_level} 
				</td>
			</tr>
		</c:forEach>

</table>
<br><br><br><br><br><br><br>
    
    