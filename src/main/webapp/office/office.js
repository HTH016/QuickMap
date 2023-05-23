var iderror = "진료과 아이디를 입력하세요";
var telerror = "전화번호를 입력하세요";

var modifyerror = "회원정보수정에 실패했습니다 \n 잠시 후 다시 시도하세요";


function erroralert(msg) {
	alert(msg);
	history.back();
}


// 정보수정 (nn)
function modifycheck() {
	if(! officemodify.service_id.value){
		alert(iderror);
		officemodify.service_id.focus();
		return false;
	}
	if(! officemodify.office_tel.value) {
		alert(telerror);
		officemodify.office_tel.focus();
		return false;
	}
}






