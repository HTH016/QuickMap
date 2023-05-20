<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="setting_map.jsp"%>
<link href="${project}style_map.css" rel="stylesheet" type="text/css">
<!--
<script src="${project}script_map.js"></script>
-->

<script type="text/javascript" src="/quickmap/jquery-3.6.4.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=3dc8348a47c6ca7030528334a83b33b0"></script>
<script type="text/javascript">
// <!--

var	kakaomap;

$(document).ready(
	function() {
		setLayoutSize();
		
		var container = document.getElementById('kakaomap');			// 지도를 담을 영역의 DOM 레퍼런스
		var options = {													// 지도를 생성할 때 필요한 기본 옵션
			center: new kakao.maps.LatLng(37.49455001, 127.02747878),	// 지도의 중심좌표 : 비트빌 위도, 경도로 초기화
			level: 3													// 지도의 레벨(확대, 축소 정도)
		};
		
		kakaomap = new kakao.maps.Map(container, options);				// 지도 생성 및 객체 리턴

		
		// 줌 컨트롤 생성
		var zoomControl = new kakao.maps.ZoomControl();
		kakaomap.addControl(zoomControl, kakao.maps.ControlPosition.BOTTOMRIGHT);
		
		// 지도타입 컨트롤 생성 (일반 지도 / 스카이뷰)
		// var mapTypeControl = new kakao.maps.MapTypeControl();
		// kakaomap.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

		getInfo();
	}
);

$(window).resize(
	function() {
		setLayoutSize();
	}
);

function setLayoutSize() {
	var	windowWidth		= $(window).width();
	var	searchAreaWidth	= 350;
	var	mapWidth		= windowWidth - searchAreaWidth; 
	
	var	windowHeight	= $(window).height();
	var	userHeight		= 200;
	var	searchHeight	= 150;
	var	searchResHeight	= windowHeight - userHeight - searchHeight; 
	var	mapHeight		= windowHeight;

	$('.areaSearch').css({'width':searchAreaWidth+'px'});
	$('.areaMap').css({'width':mapWidth+'px'});

	$('#user').css({'height':userHeight+'px'});
	$('#search').css({'height':searchHeight+'px'});
	$('#searchResult').css({'height':searchResHeight+'px'});
	$('.areaMap').css({'height':mapHeight+'px'});
}

function getInfo() {
    // 지도의 현재 중심좌표를 얻어옵니다 
    var center = kakaomap.getCenter(); 
    
    // 지도의 현재 레벨을 얻어옵니다
    var level = kakaomap.getLevel();
    
    // 지도타입을 얻어옵니다
    var mapTypeId = kakaomap.getMapTypeId(); 
    
    // 지도의 현재 영역을 얻어옵니다 
    var bounds = kakaomap.getBounds();
    
    // 영역의 남서쪽 좌표를 얻어옵니다 
    var swLatLng = bounds.getSouthWest(); 
    
    // 영역의 북동쪽 좌표를 얻어옵니다 
    var neLatLng = bounds.getNorthEast(); 
    
    // 영역정보를 문자열로 얻어옵니다. ((남,서), (북,동)) 형식입니다
    var boundsStr = bounds.toString();
    
    
    var message = '지도 중심좌표는 위도 ' + center.getLat() + ', <br>';
    message += '경도 ' + center.getLng() + ' 이고 <br>';
    message += '지도 레벨은 ' + level + ' 입니다 <br> <br>';
    message += '지도 타입은 ' + mapTypeId + ' 이고 <br> ';
    message += '지도의 남서쪽 좌표는 ' + swLatLng.getLat() + ', ' + swLatLng.getLng() + ' 이고 <br>';
    message += '북동쪽 좌표는 ' + neLatLng.getLat() + ', ' + neLatLng.getLng() + ' 입니다';
    
    // 개발자도구를 통해 직접 message 내용을 확인해 보세요.
    // ex) console.log(message);
    console.log(message);
}

// -->
</script>

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





