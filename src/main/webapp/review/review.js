var dataerror = "내용을 입력하세요";

var modifyerror = "글 수정에 실패했습니다 \n 잠시 후 다시 시도하세요";
var deleteerror = "글 삭제에 실패했습니다 \n 잠시 후 다시 시도하세요";





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
	if(! reviewmodify.reviewdata.value) {
		alert(dataerror);
		reviewmodify.reviewdata.focus();
		return false;
	}
}



