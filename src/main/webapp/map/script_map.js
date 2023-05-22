
var search_word_empty = "검색어를 입력하세요";

var searcherror = "검색에 실패했습니다 \n 잠시 후 다시 시도하세요";





function erroralert(msg) {
	alert(msg);
	history.back();
}

function checkSearchWord() {
	var searchword	= map_searchform.searchword.value;
	
	if(searchword == "") {
		alert(search_word_empty);
		map_searchform.searchword.focus();
		return false;
	}
	
	
}


