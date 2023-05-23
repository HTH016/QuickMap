<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="setting_map.jsp"%>
<link href="${project}style_map.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="/quickmap/jquery-3.6.4.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=3dc8348a47c6ca7030528334a83b33b0"></script>
<script src="${project}script_map.js"></script>

<body>
	<div class="areaSearch">
		<div id="user">
			<jsp:include page="map_user.jsp"/>
		</div>
		<div id="search">
			<jsp:include page="map_search.jsp"/>
		</div>
		<div id="searchResult">
			<jsp:include page="map_search_result.jsp"/>
		</div>
	</div>
	<div id="kakaomap" class="areaMap">map
	</div>
</body>





