var dataerror = "내용을 입력하세요";
var starerror = "별점을 입력하세요";

var modifyerror = "글 수정에 실패했습니다 \n 잠시 후 다시 시도하세요";
var deleteerror = "글 삭제에 실패했습니다 \n 잠시 후 다시 시도하세요";
var writeerror = "글 작성에 실패했습니다 \n 잠시 후 다시 시도하세요";





function erroralert(msg) {
	alert(msg);
	history.back();
}

function confirmalert(msg) {
	confirm(msg);
	history.back();
}

// 수정
function modifycheck() {
	if(! reviewmodify.review_data.value) {
		alert(dataerror);
		reviewmodify.review_data.focus();
		return false;
	}
}

// 리뷰작성
function writecheck() {
	if(! reviewwrite.review_star.value) {
		alert(starerror);
		reviewwrite.review_star.focus();
		return false;
	}
	if(! reviewwrite.review_data.value) {
		alert(dataerror);
		reviewwrite.review_data.focus();
		return false;
	}
}


