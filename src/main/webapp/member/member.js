
var iderror = "아이디를 입력하세요";
var passwderror = "비밀번호를 입력하세요";
var repasswderror = "비밀번호가 다릅니다";
var nameerror = "이름을 입력하세요";
var nickerror = "닉네임을 입력하세요";
var telerror = "전화번호를 입력하세요";
var emailerror = "이메일주소를 확인하세요";
var confirmerror = "중복확인이 필요합니다";

var inputerror = "회원가입에 실패했습니다 \n 잠시 후 다시 시도하세요";
var idxerror = "입력하신 아이디가 없습니다 \n 다시 확인하세요";
var passerror = "입력하신 비밀번호가 다릅니다 \n 다시 확인하세요";
var deleteerror = "회원탈퇴에 실패했습니다 \n 잠시 후 다시 시도하세요";





function erroralert(msg) {
	alert(msg);
	history.back();
}


// 회원가입
function inputcheck() {
	/*
	if(inputform.check.value == "0") {
		alert(confirmerror);
		inputform.user_id.focus();
		return false;
	}
	*/
	if(! inputform.user_id.value) {
		alert(iderror);
		inputform.user_id.focus();
		return false;
	} else if(! inputform.user_passwd.value) {
		alert(passwderror);
		inputform.user_passwd.focus();
		return false;
	} else if(inputform.user_passwd.value != inputform.user_repasswd.value) {
		alert(repasswderror);
		inputform.user_passwd.focus();
		return false;
	} else if(! inputform.user_name.value) {
		alert(nameerror);
		inputform.user_name.focus();
		return false;
	} else if(! inputform.user_nick.value) {
		alert(nickerror);
		inputform.user_nick.focus();
		return false;
	}
	if(inputform.tel1.value || inputform.tel2.value || inputform.tel3.value) {
		if(inputform.tel1.value.length <3 || inputform.tel2.value.length <4 || inputform.tel3.value.length <4) {
			alert(telerror);
			inputform.tel1.focus();
			return false;
		}		
	}
	if(inputform.email1.value) {
		if( inputform.email2.value == "0" ) {
			// 직접 입력이면 이거해
			if(inputform.email1.value.indexOf("@")== -1) {				// 존재하지 않으면 -1
				alert(emailerror);
				inputform.email1.focus();
				return false;
			}
		} else {
			// 직접 입력이 아니면 이거해
			if(inputform.email1.value.indexOf("@") != -1) {			
				alert(emailerror);
				inputform.email1.focus();
				return false;
			} 
		}
	}
}

// 칸 자동으로 넘어가는거 
function nexttel2() {
	if(inputform.tel1.value.length ==3) {
		inputform.tel2.focus();
	}
}
function nexttel3() {
	if(inputform.tel2.value.length ==4) {
		inputform.tel3.focus();
	}
}
function nextemail1() {
	if(inputform.tel3.value.length ==4) {
		inputform.email1.focus();
	}
}


// 아이디 중복확인
function confirmid() {
	if (! inputform.user_id.value) {
		alert(iderror);
		inputform.user_id.focus();
	} else {
		url="memberconfirmid.do?id=" + inputform.user_id.value;
		open(url, "confirm", "scrollbar=no, statusbar=no, titlebar=no, menubar=no, width=400px, height=250px");
	}
}

function confirmidcheck() {
	if(! confirmidform.user_id.value) {
		alert(iderror);
		confirmidform.user_id.focus();
		return false;
	}
}

function setid(user_id) {
	opener.document.inputform.user_id.value = user_id;
	// opener.document.inputform.check.value="1";
	window.close();
}


// 닉네임 중복확인
function confirmnick() {
	if (! inputform.user_nick.value) {
		alert(nickerror);
		inputform.user_nick.focus();
	} else {
		url="memberconfirmnick.do?nick=" + inputform.user_nick.value;
		open(url, "confirm", "scrollbar=no, statusbar=no, titlebar=no, menubar=no, width=400px, height=250px");
	}
}

function confirmnickcheck() {
	if(! confirmnickform.user_nick.value) {
		alert(nickerror);
		confirmnickform.user_nick.focus();
		return false;
	}
}
function setnick(user_nick) {
	opener.document.inputform.user_nick.value = user_nick;
	// opener.document.inputform.check.value="1";
	window.close();
}


// 로그인
function logincheck() {
	if( ! loginform.user_id.value ) {
		alert(iderror);
		loginform.user_id.focus();
		return false;
	} else if ( ! loginform.user_passwd.value) {
		alert(passwderror);
		loginform.user_passwd.focus();
		return false;
	}
}



// 정보수정 (본인확인용 비번 일치, 수정한 비번 = 2차비번 일치여부)



// 회원탈퇴 (본인확인용 비번 일치)
function passwdcheck() {
	if (! passwdform.user_passwd.value) {
		alert(passerror);
		passwdform.user_passwd.focus();
		return false;
	}
}












