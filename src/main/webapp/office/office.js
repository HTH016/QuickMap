var iderror = "진료과 아이디를 입력하세요";
var telerror = "전화번호를 입력하세요";
var nameerror = "업장명을 입력해주세요";
var addresserror = "업장주소를 입력해주세요";
var registnumerror = "사업자등록번호를 입력해주세요";
var imgerror = "사업자등록증 이미지를 첨부해주세요";
var dateerror = "날짜를 입력해주세요";

var modifyerror = "회원정보수정에 실패했습니다 \n 잠시 후 다시 시도하세요";
var registerror = "업장등록신청에 실패했습니다 \n 잠시 후 다시 시도하세요";
var requesterror = "광고신청에 실패했습니다 \n 잠시 후 다시 시도하세요";
var premiumerror = "업장등급변경신청에 실패했습니다 \n 잠시 후 다시 시도하세요";


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



// 업장등록신청폼
function registercheck() {
	if(! officeregister.office_name.value) {
		alert(officename);
		officeregister.office_name.focus();
		return false;
	}
	if(! officeregister.office_address.value) {
		alert(addresserror);
		officeregister.office_address.focus();
		return false;
	}
	if(! officeregister.office_regist_num.value) {
		alert(registnumerror);
		officeregister.office_regist_num.focus();
		return false;
	}
	if(! officeregister.office_regist_num_img.value) {
		alert(imgerror);
		return false;
	}
}



// 광고신청
function adrequestcheck() {
	if(! officeadrequest.ad_request_start.value) {
		alert(dateerror);
		return false;
	}
	if(! officeadrequest.ad_request_end.value) {
		alert(dateerror);
		return false;
	}
}
