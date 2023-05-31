<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="setting_statistics.jsp"%>
<script src="${project}statistics.js"></script>

 
 <br><br>
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
 

<h3>${str_usage}</h3>
 
 <table border="1" style="text-align:center">
 	<tr>
 		<th style="width:50%">${str_num_general_user}</th>
 		<td style="width:50%">${numGeneralUser}</td>
 	<tr>
  	<tr>
 		<th>${str_num_regist_user}</th>
 		<td>${numRegistUser}</td>
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
 

<h3>${str_ad_income}</h3>
 <br>
 
<form method="post" action="statisticsadminincomeform.do" name="incomerange" onsubmit="return incomerangecheck()">
	<input type="date" name="incomestart" min="2023-01-01" max="2023-12-31">
	<input type="date" name="incomeend" min="2023-01-01" max="2023-12-31">
	<input type="submit" value="확인">
</form>

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



<h3>${str_search_rank}</h3>
 <br>

<form method="post" action="statisticsadminsearchform.do" name="searchrange" onsubmit="return searchrangecheck()">
	<input type="date" name="searchstart" min="2023-01-01" max="2023-12-31">
	<input type="date" name="searchend" min="2023-01-01" max="2023-12-31">
	<input type="submit" value="${btn_range}">
</form>


<table style="margin-left: auto; margin-right: auto;">
	
	<tr>
		<th style="width:20%"> ${str_word} </th>
		<th style="width:20%"> ${str_rank} </th>
		<th style="width:20%"> ${str_count} </th>
		

	</tr>

		
		<c:forEach var="dtoSearch" items="${dtosSearch}">
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

<script src="https://cdn.anychart.com/releases/v8/js/anychart-base.min.js"></script>
<script src="https://cdn.anychart.com/releases/v8/js/anychart-tag-cloud.min.js"></script>
<div class="chart-area">
	<div id="container" align="center" style="width:40%; height:40%;"></div>
</div>
	
<script>
anychart.onDocumentReady(function () {
  
	
	let data = [];
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
	

<br><br><br><br><br><br><br>
    
    