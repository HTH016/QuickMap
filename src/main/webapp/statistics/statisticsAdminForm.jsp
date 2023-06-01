<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="setting_statistics.jsp"%>
<script src="${project}statistics.js"></script>

 <br>
 <h2>${page_admin}</h2>
 <br>
 
<input type="button" style="width:90pt; height:20pt" value="${btn_admin_user}"
				onclick="location='adminuserlistform.do'">
<input type="button" style="width:90pt; height:20pt" value="${btn_admin_office}"
				onclick="location='adminregisterofficeform.do'">
<input type="button" style="width:90pt; height:20pt" value="${btn_admin_grade}"
				onclick="location='adminrequestgradeform.do'">
<input type="button" style="width:90pt; height:20pt" value="${btn_admin_ad}"
				onclick="location='adminrequestadform.do'">
<input type="button" style="width:90pt; height:20pt" value="${btn_admin_statistics}"
				onclick="location='statisticsadminform.do'">		
<input type="button" style="width:90pt; height:30pt; float:right" value="${btn_to_main}"
				onclick="location='main.do'">
<br><br>
<h3>${str_usage}</h3>
 
 <table border="1" style="text-align:center">
 	<tr>
 		<th style="width:50%">${str_num_general_user}</th>
 		<td style="width:50%">${numGeneralUser}</td>
 	<tr>
  	<tr>
 		<th>${str_num_regist_office}</th>
 		<td>${numRegistOffice}</td>
 	<tr>
  	<tr>
 		<th>${str_num_premium_office}</th>
 		<td>${numPremiumOffice}</td>
 	<tr>
  	<tr>
 		<th>${str_num_ad_office}</th>
 		<td>${numAdOffice}</td>
 	<tr>
 
 </table>
 <br><br>
 
	<form method="post" action="statisticsadminrangeform.do" name="adminrange" onsubmit="return rangecheck()">
		<input type="date" name="rangestart" min="2020-01-01" max="2023-12-31">
		<input type="date" name="rangeend" min="2020-01-01" max="2023-12-31">
		<input type="submit" value="${btn_range}">
	</form>
 
<br><br>
<h3>${str_ad_income}</h3>
<br>
	<table>
		<tr>
			<th style="width:30%"> ${str_ad_length} </th>
			<th style="width:30%"> ${str_ad_level} </th>
		</tr>
			<c:forEach var="dtoAd" items="${dtosAd}">
				<tr>
					<td style="text-align:center">
						${dtoAd.s}
					</td>
					<td style="text-align:center">
						${dtoAd.ad_request_level} 
					</td>
				</tr>
			</c:forEach>
				<tr>
					<td style="text-align:center" colspan="2">
						<h3>${strAdIncome}&#8361; 
						</h3> 
					</td>
				</tr>
	</table>

<br><br>
<h3>${str_search_rank}</h3>
<br>

<div>
	<script src="https://cdn.anychart.com/releases/v8/js/anychart-base.min.js"></script>
	<script src="https://cdn.anychart.com/releases/v8/js/anychart-tag-cloud.min.js"></script>
	<div class="chart-area" style="display:inline-block; width:600px;">
		<div id="container" align="center" style="width:100%; height:50%;"></div>
	</div>
	<div style="display:inline-block;">
		<table>
			<tr>
				<th style="width:20%"> ${str_rank} </th>
				<th style="width:20%"> ${str_word} </th>
				<th style="width:20%"> ${str_count} </th>
			</tr>
				<c:forEach var="dtoSearch" items="${dtosSearch}" begin="0" end="17" step="1">
					<tr>
						<td style="text-align:center">
							${dtoSearch.rank} 
						</td>
						<td style="text-align:center">
							${dtoSearch.search_word}
						</td>
						<td style="text-align:center">
							${dtoSearch.count} 
						</td>
					</tr>
				</c:forEach>
		</table>
	</div>
</div>	
<script>
anychart.onDocumentReady(function () {

	let		data	= [];
	<c:forEach var="dtosSearch" items="${dtosSearch}" varStatus="status">
		data.push(
				{
	                "x": "${dtosSearch.search_word}",
	                "value": ${dtosSearch.count}
	            }
		);
	</c:forEach>
	
	
    var chart = anychart.tagCloud(data);
    chart.angles([0]);
    chart.container("container");
    // chart.getCredits().setEnabled(false);
    chart.draw();
});
</script>
	
<br><br><br><br><br>


<h3>${str_detail_statistics}</h3>

<br>

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

<br><br><br><br>
<h3>${str_favorite_statistics}</h3>
<br>

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

<br><br><br><br>
<h3>${str_review_statistics}</h3>

<br>

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

<br><br><br><br><br>
    
    
    