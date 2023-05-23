
var search_word_empty = "검색어를 입력하세요";

var searcherror = "검색에 실패했습니다 \n 잠시 후 다시 시도하세요";

////////// event handlers //////////
$(document).ready(
	function() {
		setLayoutSize();
//		loadLayout();
		initializeMap('kakaomap');		// map을 표시할 element id : 'kakaomap'
	}
);

$(window).resize(
	function() {
		setLayoutSize();
	}
);

/*
$("input[name=imgSearchOffice]").on(
	"click",
	function(event) {
		if(checkSearchWord() == false) {
			return false;
		}
		
		var level		= kakaomap.getLevel();
		var bounds		= kakaomap.getBounds();
		var swLatLng	= bounds.getSouthWest();
		var neLatLng	= bounds.getNorthEast();

		$.ajax(
			{
				url : "map_do_search.do",
				type : "POST",
				data : {
					searchWord  : $("input[name=searchWord]").val(),
					latiSouth   : swLatLng.getLat(),
					latiNorth   : neLatLng.getLat(),
					longWest    : swLatLng.getLng(),
					longEast    : neLatLng.getLng(),
					mapLevel    : level,
					officeClass : $("select[name=officeClass]").val()
				},
				dataType : "text",
				success : function(data) {
					
				},
				error : function(request, status, error) {
					
				}
			}
		);
	}
);
*/

////////// functions //////////
function searchOffice() {
	if(checkSearchWord() == false) {
		return false;
	}

	var bounds		= kakaomap.getBounds();
	var swLatLng	= bounds.getSouthWest();
	var neLatLng	= bounds.getNorthEast();
	
	$('input[name=latiSouth]').attr('value', swLatLng.getLat());
	$('input[name=latiNorth]').attr('value', neLatLng.getLat());
	$('input[name=longWest]').attr('value', swLatLng.getLng());
	$('input[name=longEast]').attr('value', neLatLng.getLng());
	$('input[name=mapLevel]').attr('value', kakaomap.getLevel());
}

function checkSearchWord() {
	if($("input[name=searchWord]").val() == "") {
		alert(search_word_empty);
		$("input[name=searchWord]").focus();
		return false;
	}
}


////////// common functions //////////
function erroralert(msg) {
	alert(msg);
	history.back();
}


////////// layout functions //////////
function setLayoutSize() {
	var	windowWidth		= $(window).width();
	var	searchAreaWidth	= 300;
	var	mapWidth		= windowWidth - searchAreaWidth; 
	
	var	windowHeight	= $(window).height();
	var	userHeight		= 150;
	var	searchHeight	= 100;
	var	searchResHeight	= windowHeight - userHeight - searchHeight; 
	var	mapHeight		= windowHeight;

	$('.areaSearch').css({'width':searchAreaWidth+'px'});
	$('.areaMap').css({'width':mapWidth+'px'});

	$('#user').css({'height':userHeight+'px'});
	$('#search').css({'height':searchHeight+'px'});
	$('#searchResult').css({'height':searchResHeight+'px'});
	$('.areaMap').css({'height':mapHeight+'px'});
}

function loadLayout() {
	$("#user").load("map/map_user.jsp");
	$("#search").load("map/map_search.jsp");
	$("#searchResult").load("map/map_search_result.jsp");
}


////////// kakaomap //////////
var	kakaomap;

function initializeMap(div) {
	var container = document.getElementById(div);					// 지도를 담을 영역의 DOM 레퍼런스
	var options = {													// 지도를 생성할 때 필요한 기본 옵션
		center: new kakao.maps.LatLng(37.49455001, 127.02747878),	// 지도의 중심좌표
		level: 2													// 지도의 레벨(확대, 축소 정도)
	};
	
	kakaomap = new kakao.maps.Map(container, options);				// 지도 생성 및 객체 리턴
	
	// 줌 컨트롤 생성
	var zoomControl = new kakao.maps.ZoomControl();
	kakaomap.addControl(zoomControl, kakao.maps.ControlPosition.BOTTOMRIGHT);
	
	// 지도타입 컨트롤 생성 (일반 지도 / 스카이뷰)
//	var mapTypeControl = new kakao.maps.MapTypeControl();
//	kakaomap.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

// 지도가 확대 또는 축소되면 마지막 파라미터로 넘어온 함수를 호출하도록 이벤트를 등록합니다
/*
	kakao.maps.event.addListener(map, 'zoom_changed', function() {        
	    // 지도의 현재 레벨을 얻어옵니다
	    var level = map.getLevel();
	    var message = '현재 지도 레벨은 ' + level + ' 입니다';
	    var resultDiv = document.getElementById('result');  
	    resultDiv.innerHTML = message;
	});
*/
//	kakao.maps.event.addListener(kakaomap, 'zoom_changed', search_office());

	// 지도가 이동, 확대, 축소로 인해 중심좌표가 변경되면 마지막 파라미터로 넘어온 함수를 호출하도록 이벤트를 등록합니다
/*
	kakao.maps.event.addListener(map, 'center_changed', function() {
	    // 지도의  레벨을 얻어옵니다
	    var level = map.getLevel();
	
	    // 지도의 중심좌표를 얻어옵니다 
	    var latlng = map.getCenter(); 
	
	    var message = '<p>지도 레벨은 ' + level + ' 이고</p>';
	    message += '<p>중심 좌표는 위도 ' + latlng.getLat() + ', 경도 ' + latlng.getLng() + '입니다</p>';
	
	    var resultDiv = document.getElementById('result');
	    resultDiv.innerHTML = message;
});
*/
//	kakao.maps.event.addListener(kakaomap, 'center_changed', search_office());
	
	// 지도 정보 출력
//	getInfo();
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
    console.log(message);
}