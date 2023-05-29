<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="setting_statistics.jsp"%>
 <script src="${project}statistics.js"></script>
    

 <br>
 <h2>${page_office_statistics}</h2>
 <!--  
  <h2>${office_name}${page_statistics_of}</h2>
 -->
 <br>


${msg_range}
<form method="post" action="statisticsofficerangeform.do" name="officerange" onsubmit="return officerangecheck()">
	<input type="date" name="officestart" min="2023-01-01" max="2023-12-31">
	<input type="date" name="officeend" min="2023-01-01" max="2023-12-31">
	<input type="submit" value="${btn_range}">
</form>


<h3>${str_detail_statistics}</h3>
<!--  
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
-->

<script src="https://cdn.jsdelivr.net/npm/chart.js@3.7.1/dist/chart.min.js"></script>
 <canvas id="chartDetail" width="800" height="500"></canvas>
 
 <script>
 
 let labelsDetail = [];
	<c:forEach var="dtosDetail" items="${dtosDetail}" varStatus="status">
	labelsDetail.push(
			"${dtosDetail.detail_date}"
	);
	</c:forEach>
 
 
	let dataDetail = [];
	<c:forEach var="dtosDetail" items="${dtosDetail}" varStatus="status">
	dataDetail.push(
			${dtosDetail.count} 
	);
	</c:forEach>
 
 
const ctxDetail = document.getElementById('chartDetail').getContext('2d');
const chartDetail = new Chart(ctxDetail, {
    type: 'line',
    data: {
        labels: labelsDetail,
        datasets: [{
            label: '# of Votes',
            data: dataDetail,
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)'
            ],
            borderColor: [
                'rgba(255, 99, 132, 1)'
            ],
            borderWidth: 1
        }]
    },
    options: {
    	 responsive: false,
        scales: {
            y: {
                beginAtZero: true
            }
        }
    }
});
</script>



<h3>${str_favorite_statistics}</h3>
 <br>
 
<!--
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
-->


<script src="https://cdn.jsdelivr.net/npm/chart.js@3.7.1/dist/chart.min.js"></script>
<canvas id="chartFavorite" width="800" height="500">
 
 <script>
 
 let labelsFavorite = [];
 let dataFavorite = [];
	<c:forEach var="dtosFavorite" items="${dtosFavorite}" varStatus="status">
	labelsFavorite.push(
			"${dtosFavorite.favorite_reg}"
	);
	dataFavorite.push(
			${dtosFavorite.count} 
	);
	</c:forEach>
 
const ctxFavorite = document.getElementById('chartFavorite').getContext('2d');
const chartFavorite = new Chart(ctxFavorite, {
    type: 'line',
    data: {
        labels: labelsFavorite,
        datasets: [{
            label: '# of Votes',
            data: dataFavorite,
            backgroundColor: [
                'rgba(54, 162, 235, 0.2)'
            ],
            borderColor: [
                'rgba(54, 162, 235, 1)'
            ],
            borderWidth: 1
        }]
    },
    options: {
    	 responsive: false,
        scales: {
            y: {
                beginAtZero: true
            }
        }
    }
});
</script>
</canvas>



<h3>${str_review_statistics}</h3>
 <br>

<!-- 
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
-->


<script src="https://cdn.jsdelivr.net/npm/chart.js@3.7.1/dist/chart.min.js"></script>
<canvas id="chartReview" width="800" height="500">
 
 <script>
 
 let labelsReview = [];
	<c:forEach var="dtosReview" items="${dtosReview}" varStatus="status">
	labelsReview.push(
			"${dtosReview.review_reg}"
	);
	</c:forEach>
 
 
	let dataReview = [];
	<c:forEach var="dtosReview" items="${dtosReview}" varStatus="status">
	dataReview.push(
			${dtosReview.count} 
	);
	</c:forEach>
 
 
const ctxReview = document.getElementById('chartReview').getContext('2d');
const chartReview = new Chart(ctxReview, {
    type: 'line',
    data: {
        labels: labelsReview,
        datasets: [{
            label: '# of Votes',
            data: dataReview,
            backgroundColor: [
                'rgba(75, 192, 192, 0.2)'
            ],
            borderColor: [
                'rgba(75, 192, 192, 1)'
            ],
            borderWidth: 1
        }]
    },
    options: {
    	 responsive: false,
        scales: {
            y: {
                beginAtZero: true
            }
        }
    }
});

</script>
</canvas>




<h3>${str_ad_history}</h3>
 <br>
	<table style="margin-left: auto; margin-right: auto;" border="1" width="60%">
		
		<tr>
			<th style="width:15%"> ${str_ad_start} </th>
			<th style="width:15%"> ${str_ad_end} </th>
			<th style="width:15%">  ${str_ad_level} </th>
		</tr>	
			<c:forEach var="dtoAd" items="${dtosAd}">
				<tr>
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
    
    