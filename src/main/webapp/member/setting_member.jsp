<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"%>

<!-- 아래 내용은 참고용. 구현시 삭제/수정 후 사용하세요 -->
<c:set var="project" value="/quickmap/member/"/>

<c:set var="page_login" value="로그인"/>
<c:set var="page_confirmid" value="아이디 중복확인"/>
<c:set var="page_confirmnick" value="닉네임 중복확인"/>
<c:set var="page_input" value="회원가입"/>
<c:set var="page_modify" value="회원정보수정"/>
<c:set var="page_delete" value="회원탈퇴"/>
<c:set var="page_favorite" value="즐겨찾기"/>
<c:set var="page_review" value="이용후기"/>

<c:set var="msg_main" value= "로그인 하시고 퀵맵의 모든 서비스를 이용하세요"/>
<c:set var="msg_input" value = "회원정보를 입력해 주세요"/>
<c:set var="msg_use_o" value="는 사용할 수 있습니다"/>
<c:set var="msg_use_x" value="는 사용할 수 없습니다"/>
<c:set var="msg_passwd" value = "비밀번호를 한번 더 입력해주세요"/>
<c:set var="msg_modify" value = "수정할 정보를 입력하세요"/>
	
<c:set var="str_user_id" value = "아이디"/>
<c:set var="str_user_passwd" value = "비밀번호"/>
<c:set var="str_user_name" value = "이름"/>
<c:set var="str_user_nick" value = "닉네임"/>
<c:set var="str_user_tel" value = "전화번호"/>
<c:set var="str_user_email" value = "이메일"/>
<c:set var="str_user_reg_date" value = "가입일자"/>
<c:set var="str_user_grade_id" value = "회원등급"/>

<c:set var="btn_ok"	value="확인"/>
<c:set var="btn_cancel"	value="취소"/>
<c:set var="btn_confirm" value="중복확인"/>
<c:set var="btn_input" value="가입"/>
<c:set var="btn_input_cancel" value="가입취소"/>
<c:set var="btn_login" value="로그인"/>
<c:set var="btn_member" value="회원가입"/>
<c:set var="btn_ok_cancel" value="확인 취소"/>
<c:set var="btn_delete" value="탈퇴"/>
<c:set var="btn_delete_cancel" value="탈퇴 취소"/>
<c:set var="btn_modify" value="수정"/>
<c:set var="btn_modify_cancel" value="수정 취소"/>
