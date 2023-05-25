<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

    

 
 <br><br>
 <h2>관리자 페이지</h2>
 <br>
 
<input class="inputbutton" type="button" value="회원 관리"
				onclick="location='adminuserlistform.do'">
<input class="inputbutton" type="button" value="업장 등록 관리"
				onclick="location='adminregisterofficeform.do'">
<input class="inputbutton" type="button" value="업장 등급 관리"
				onclick="location='adminrequestgradeform.do'">
<input class="inputbutton" type="button" value="광고 신청 관리"
				onclick="location='adminrequestadform.do'">
<input class="inputbutton" type="button" value="통계"
				onclick="location='adminstatistics.do'">
 

<h3>서비스 이용 현황</h3>
 <br>
 ${numGeneralUser}
 <br>
 ${numRegistUser}
 <br>
  ${numRegistOffice}
 <br>
  ${numPremiumOffice}
 <br>
  ${numAdOffice}
 <br>
 
 

<h3>광고 수주 현황</h3>
 <br>
 

<input type="date" name="day" min="1977-01-01" max="2023-12-31">

<input type="date" name="day" min="1977-01-01" max="2023-12-31">

<table style="margin-left: auto; margin-right: auto;">
	
	<tr>
		<th style="width:30%"> ad_length_sum </th>
		<th style="width:30%"> ad_request_level </th>
		

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



<h3>검색 키워드</h3>
 <br>

<input type="date" name="day" min="1977-01-01" max="2023-12-31">

<input type="date" name="day" min="1977-01-01" max="2023-12-31">


<table style="margin-left: auto; margin-right: auto;">
	
	<tr>
		<th style="width:20%"> s </th>
		<th style="width:20%"> rank </th>
		<th style="width:20%"> c </th>
		

	</tr>

		
		<c:forEach var="dtoSearch" items="${dtosSearch}">
			<tr>
				<td style="text-align:center">
					${dtoSearch.s}
				</td>
				<td style="text-align:center">
					${dtoSearch.r} 
				</td>
				<td style="text-align:center">
					${dtoSearch.c} 
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
                "x": "${dtosSearch.s}",
                "value": ${dtosSearch.c}
            }
	);
	</c:forEach>
	
	
	/*
	var data = new Array();    //배열 선언

	<c:forEach var="data" items="${dtosSearch}">
		{

	        data.push(
	        		{
	                    "x": ${data.s},
	                    "value": ${data.c}
	                    
	                }	
	        );
	  
	</c:forEach>
	*/
	/*
	 var data = [
        {
            "x": "${dtosSearch[0].s}",
            "value": ${dtosSearch[0].c} 
            
        },
        {
            "x": "Python",
            "value": 283000000
            
        },
        {
            "x": "소프트웨어",
            "value": 544000000
            
        },
        {
            "x": "JAVA",
            "value": 527000000
           
        }, {
            "x": "C++",
            "value": 422000000
           
        }, {
            "x": "HTML",
            "value": 620000000
           
        } 
    ];
	*/
    var chart = anychart.tagCloud(data);
    chart.angles([0]);
    chart.container("container");
    // chart.getCredits().setEnabled(false);
    chart.draw();
});
</script>
	

<br><br><br><br><br><br><br>
    
    