<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--
<div id="map"></div>
-->
<div id="map" style="width:500px;height:400px;"></div>

<script src="/quickmap/jquery-3.6.4.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=3dc8348a47c6ca7030528334a83b33b0"></script>

<script type="text/javascript">
// <!--

var	map;

$(document).ready(
	function() {
		setMapSize();
		
		var container = document.getElementById('map');					// 지도를 담을 영역의 DOM 레퍼런스
		var options = {													// 지도를 생성할 때 필요한 기본 옵션
			center: new kakao.maps.LatLng(37.49455001, 127.02747878),	// 지도의 중심좌표
			level: 3													// 지도의 레벨(확대, 축소 정도)
		};
		
		map = new kakao.maps.Map(container, options);					// 지도 생성 및 객체 리턴
		
		// 줌 컨트롤 생성
		var zoomControl = new kakao.maps.ZoomControl();
		map.addControl(zoomControl, kakao.maps.ControlPosition.BOTTOMRIGHT);
		
		// 지도타입 컨트롤 생성 (일반 지도 / 스카이뷰)
		// var mapTypeControl = new kakao.maps.MapTypeControl();
		// map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

		getInfo();
	}
);

$(window).resize(
	function() {
		setMapSize();
	}
);

function setMapSize() {
	var	mapHeight	= $(window).height();
	var	mapWidth	= $(window).width();

	$('#map').css({'height':mapHeight+'px'});
	$('#map').css({'width':mapWidth+'px'});
}

function getInfo() {
    // 지도의 현재 중심좌표를 얻어옵니다 
    var center = map.getCenter(); 
    
    // 지도의 현재 레벨을 얻어옵니다
    var level = map.getLevel();
    
    // 지도타입을 얻어옵니다
    var mapTypeId = map.getMapTypeId(); 
    
    // 지도의 현재 영역을 얻어옵니다 
    var bounds = map.getBounds();
    
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




