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
		
		var container = document.getElementById('kakaomap');			// ������ ���� ������ DOM ���۷���
		var options = {													// ������ ������ �� �ʿ��� �⺻ �ɼ�
			center: new kakao.maps.LatLng(37.49455001, 127.02747878),	// ������ �߽���ǥ
			level: 3													// ������ ����(Ȯ��, ��� ����)
		};
		
		kakaomap = new kakao.maps.Map(container, options);				// ���� ���� �� ��ü ����

		
		// �� ��Ʈ�� ����
		var zoomControl = new kakao.maps.ZoomControl();
		kakaomap.addControl(zoomControl, kakao.maps.ControlPosition.BOTTOMRIGHT);
		
		// ����Ÿ�� ��Ʈ�� ���� (�Ϲ� ���� / ��ī�̺�)
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
	var	mapWidth		= windowWidth - searchAreaWidth - 4; 
	
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
    // ������ ���� �߽���ǥ�� ���ɴϴ� 
    var center = kakaomap.getCenter(); 
    
    // ������ ���� ������ ���ɴϴ�
    var level = kakaomap.getLevel();
    
    // ����Ÿ���� ���ɴϴ�
    var mapTypeId = kakaomap.getMapTypeId(); 
    
    // ������ ���� ������ ���ɴϴ� 
    var bounds = kakaomap.getBounds();
    
    // ������ ������ ��ǥ�� ���ɴϴ� 
    var swLatLng = bounds.getSouthWest(); 
    
    // ������ �ϵ��� ��ǥ�� ���ɴϴ� 
    var neLatLng = bounds.getNorthEast(); 
    
    // ���������� ���ڿ��� ���ɴϴ�. ((��,��), (��,��)) �����Դϴ�
    var boundsStr = bounds.toString();
    
    
    var message = '���� �߽���ǥ�� ���� ' + center.getLat() + ', <br>';
    message += '�浵 ' + center.getLng() + ' �̰� <br>';
    message += '���� ������ ' + level + ' �Դϴ� <br> <br>';
    message += '���� Ÿ���� ' + mapTypeId + ' �̰� <br> ';
    message += '������ ������ ��ǥ�� ' + swLatLng.getLat() + ', ' + swLatLng.getLng() + ' �̰� <br>';
    message += '�ϵ��� ��ǥ�� ' + neLatLng.getLat() + ', ' + neLatLng.getLng() + ' �Դϴ�';
    
    // �����ڵ����� ���� ���� message ������ Ȯ���� ������.
    // ex) console.log(message);
    console.log(message);
}

// -->
</script>

<body>
	<div class="areaSearch">
		<div id="user">user
		</div>
		<div id="search">search
		</div>
		<div id="searchResult">searchResult
		</div>
	</div>
	<div id="kakaomap" class="areaMap">map
	</div>
</body>





