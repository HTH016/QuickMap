
var search_word_empty = "검색어를 입력하세요";

var searcherror = "검색에 실패했습니다 \n 잠시 후 다시 시도하세요";


////////// event handlers //////////
$(function() {
	// initialize
	setLayoutSize();
	initializeMap('kakaomap');		// map을 표시할 element id : 'kakaomap'

	// 리뷰 작성 클릭
	$(document).on(
		"click",
		".office_detail_review_image",
		function() {
			var userId		= $("#map_user_id").text();
			var officeId	= $("#map_office_id").text();
			var hasReview	= $("#map_has_review").text();
			
			if(hasReview == 0) {
				window.location.href = "reviewwrite.do?userId=" + userId + "&officeId=" + officeId;
			} else {
				window.location.href = "reviewmodify.do?userId=" + userId + "&officeId=" + officeId + "&nextPage=main";
			}
		}
	);
	
	// 즐겨찾기 클릭
	$(document).on(
		"click",
		".office_detail_favorite",
		function() {
			var userId		= $("#map_user_id").text();
			var officeId	= $("#map_office_id").text();

			$.ajax({
				url : "map_favorite_ajax.do",
				type : "POST",
				data : {
					userId		: userId,
					officeId	: officeId
				},
				dataType : "html",
				success : function(data) {
					var $favoriteImage	= $(".office_detail_fav_image");
					
					$favoriteImage.attr("src", data);
				},
				error : function(request, status, error) {
					alert("즐겨찾기 등록/해제에 실패하였습니다\n잠시 후 다시 시도해주세요.");
				}
			});	// ajax
		}
	);
	
	// 상세 정보 닫기 클릭
	$(document).on(
		"click",
		".office_detail_close_box",
		function() {
			var $officeDetail = $("#searchDetail");

			$officeDetail.removeClass('on'); // detail 닫기
		}
	);

	// 검색 결과 항목 클릭
	$(document).on(
		"click",
		".office_search_result_box",
		function(e) {
//			alert("click");

			index	= $(this).find("span.marker_index:hidden").map(function() {
							return $(this).text();
						}).get();
			
			setSelectedMarker(index)

			$.ajax({
				url : "map_search_detail_ajax.do",
				type : "POST",
				data : {
					officeId	: e.currentTarget.id
				},
				dataType : "html",
				success : function(data) {
//					alert(data);
					var $officeDetail = $("#searchDetail");

					$officeDetail.html(data);
					setDetailLayoutSize();			// detail layout 설정
					$officeDetail.addClass('on');	// detail layout 열기
/*		
					if ($officeDetail.hasClass('on')) {
						$officeDetail.removeClass('on'); // detail 닫기
					} else {
						$officeDetail.html(data);
						$officeDetail.css('z-index', 2);
						$officeDetail.addClass('on'); // detail 열기
					}
*/
				},
				error : function(request, status, error) {
					alert("상세정보 불러오기에 실패하였습니다\n잠시 후 다시 시도해주세요");
				}
			});	// ajax

//			return false;
		}
	);	// 검색 결과 항목 클릭

	// 검색 버튼 클릭 + 검색어 입력 창에서 엔터 입력
	$(document).on(
		"keyup click",
		"input[name='searchWord'], input[name='imgSearchOffice']",
		function(event) {
			if(event.type === "keyup" && event.keyCode !== 13) {
				return;
			}
			
			if (event.type === "click" && event.target.name === 'searchWord') {
				$('input[name="searchWord"]').val('');
				return;
			}
			
			if(checkSearchWord() == false) {
				return;
			}
			
			var level		= kakaomap.getLevel();
			var bounds		= kakaomap.getBounds();
			var swLatLng	= bounds.getSouthWest();
			var neLatLng	= bounds.getNorthEast();
	
			$.ajax({
				url : "map_search_ajax.do",
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
				dataType : "html",
				success : function(data) {
//					alert(data);
					$("#searchResult").html(data);
					
					hideMarkers();
					
					markerIndexs		= $("span.marker_index:hidden").map(function() {
							return $(this).text();
						}).toArray();
					var arrLatitude		= $("span.office_loc_latitude:hidden").map(function() {
							return $(this).text();
						}).toArray();
					var arrLongitude	= $("span.office_loc_longitude:hidden").map(function() {
							return $(this).text();
						}).toArray();

					for(var i=0 ; i<arrLatitude.length ; i++) {
//						console.log(arrLatitude[i]);
						addMarker(new kakao.maps.LatLng(arrLatitude[i], arrLongitude[i]));
					}

					showMarkers();
				},
				error : function(request, status, error) {
					alert("검색에 실패하였습니다\n잠시 후 다시 시도해주세요.");
				}
			});	// ajax
		}
	);	// 검색 버튼 클릭
});

var windowHeight	= $(window).height();
var	windowWidth		= $(window).width();

$(window).on('resize', function() {
	windowHeight	= $(window).height();
	windowWidth		= $(window).width();

	console.log(windowHeight);
	
	setLayoutSize();
});


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
//	var	windowWidth		= $(window).width();
	var	searchAreaWidth	= $("#user_part").width();	// 320;
	var	mapWidth		= windowWidth - searchAreaWidth; 
	
//	var	windowHeight	= $(window).height();
	var	userHeight		= $("#user_part").height();
	var	searchHeight	= $("#search").height();
	var	searchResHeight	= windowHeight - userHeight - searchHeight; 
	var	mapHeight		= windowHeight;

	if($(".office_detail_review_item_list").length) {
		setDetailLayoutSize();
	}
	
	// width
//	$('.areaSearch').css({'width':searchAreaWidth+'px'});
	$('.areaMap').css({'width':mapWidth+'px'});

	// height
//	$('#user_part').css({'height': userHeight+'px'});
//	$('#search').css({'height': searchHeight+'px'});
	$('#searchResult').css({'height': searchResHeight+'px'});
	$('.areaMap').css({'height': mapHeight+'px'});
}

function setDetailLayoutSize() {
	var	windowHeight	= $(window).height();
	var reviewOffset	= $(".office_detail_review_item_list").offset();
	var reviewHeight	= windowHeight - reviewOffset.top - 1;
	
	$(".office_detail_review_item_list").css({'height': reviewHeight+'px'});
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
//	kakao.maps.event.addListener(map, 'zoom_changed', function() {        
	    // 지도의 현재 레벨을 얻어옵니다
//	    var level = map.getLevel();
//	    var message = '현재 지도 레벨은 ' + level + ' 입니다';
//	    var resultDiv = document.getElementById('result');  
//	    resultDiv.innerHTML = message;
//	});

//	kakao.maps.event.addListener(kakaomap, 'zoom_changed', search_office());

	// 지도가 이동, 확대, 축소로 인해 중심좌표가 변경되면 마지막 파라미터로 넘어온 함수를 호출하도록 이벤트를 등록합니다
//	kakao.maps.event.addListener(map, 'center_changed', function() {
	    // 지도의  레벨을 얻어옵니다
//	    var level = map.getLevel();
	
	    // 지도의 중심좌표를 얻어옵니다 
//	    var latlng = map.getCenter(); 
	
//	    var message = '<p>지도 레벨은 ' + level + ' 이고</p>';
//	    message += '<p>중심 좌표는 위도 ' + latlng.getLat() + ', 경도 ' + latlng.getLng() + '입니다</p>';
	
//	    var resultDiv = document.getElementById('result');
//	    resultDiv.innerHTML = message;
//});

//	kakao.maps.event.addListener(kakaomap, 'center_changed', search_office());
	
	// 지도 정보 출력
//	getInfo();
}

// 지도에 표시된 마커 객체를 가지고 있을 배열입니다
var markers				= [];
var markerIndexs		= [];
var selectedMarkerIndex	= -1;

var iconNormal		= "/quickmap/images/icon_office_normal.png";
var iconSelected	= "/quickmap/images/icon_office_selected.png";
var iconSize		= new kakao.maps.Size(30, 50);
var iconOption		= {offset: new kakao.maps.Point(15, 50)};
var markerNormal	= new kakao.maps.MarkerImage(iconNormal, iconSize, iconOption);
var markerSelected	= new kakao.maps.MarkerImage(iconSelected, iconSize, iconOption);


// 마커 하나를 지도위에 표시합니다 
//addMarker(new kakao.maps.LatLng(33.450701, 126.570667));

// 마커를 생성하고 지도위에 표시하는 함수입니다
function addMarker(position) {
    
    // 마커를 생성합니다
    var marker = new kakao.maps.Marker({
        position: position,
        image: markerNormal
    });

    // 마커가 지도 위에 표시되도록 설정합니다
//    marker.setMap(kakaomap);
    
    // 생성된 마커를 배열에 추가합니다
    markers.push(marker);
}

// 배열에 추가된 마커들을 지도에 표시하거나 삭제하는 함수입니다
function setMarkers(map) {
    for (var i = 0; i < markers.length; i++) {
        markers[i].setMap(map);
    }
}

// 배열에 추가된 마커를 지도에 표시하는 함수입니다
function showMarkers() {
    setMarkers(kakaomap);
}

// 배열에 추가된 마커를 지도에서 삭제하는 함수입니다
function hideMarkers() {
    setMarkers(null);
    markers				= [];
    selectedMarkerIndex	= -1;
}

// 배열에 추가된 마커 이미지를 변경하는 함수입니다
function setSelectedMarker(index) {
	if(selectedMarkerIndex != -1) {
		markers[selectedMarkerIndex].setImage(markerNormal);
		markers[selectedMarkerIndex].setZIndex(0);
	}
	
	selectedMarkerIndex	= index;
	markers[selectedMarkerIndex].setImage(markerSelected);
	markers[selectedMarkerIndex].setZIndex(999);
}

// 

/*
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
*/