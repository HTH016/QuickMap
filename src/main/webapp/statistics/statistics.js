
var rangeerror = "시작 날짜와 끝 날짜를 모두 선택하세요.";

function erroralert( msg ) {
	alert( msg );
	history.back();
}

function rangecheck() {
	if( ! adminrange.rangestart.value ) {
		alert( rangeerror );
		return false;
	} else if(  ! adminrange.rangeend.value ) {
		alert( rangeerror );
		return false;
	}	
}

function rangecheck() {
	if( ! officerange.rangestart.value ) {
		alert( rangeerror );
		return false;
	} else if(  ! officerange.rangeend.value ) {
		alert( rangeerror );
		return false;
	}	
}