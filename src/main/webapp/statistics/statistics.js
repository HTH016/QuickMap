
var rangeerror = "시작 날짜와 끝 날짜를 모두 선택하세요.";

function erroralert( msg ) {
	alert( msg );
	history.back();
}

function incomerangecheck() {
	if( ! incomerange.incomestart.value ) {
		alert( rangeerror );
		return false;
	} else if(  ! incomerange.incomeend.value ) {
		alert( rangeerror );
		return false;
	}	
}

function searchrangecheck() {
	if( ! searchrange.searchstart.value ) {
		alert( rangeerror );
		return false;
	} else if(  ! searchrange.searchend.value ) {
		alert( rangeerror );
		return false;
	}	
}

function officerangecheck() {
	if( ! officerange.officestart.value ) {
		alert( rangeerror );
		return false;
	} else if(  ! officerange.officeend.value ) {
		alert( rangeerror );
		return false;
	}	
}