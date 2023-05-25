<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"%>

<!-- 아래 내용은 참고용. 구현시 삭제/수정 후 사용하세요 -->
<c:set var="project"			value="/quickmap/office/"/>

<c:set var="page_office_modify" value="업장 정보 수정"/>

<c:set var="msg_main" value="비회원이시면 회원가입을 해주세요"/>
	
<c:set var="str_user_id" value="사용자 ID"/>
<c:set var="str_grade_id" value="등급 ID"/>
<c:set var="str_office_regist_num" value="사업자등록번호"/>
<c:set var="str_office_name" value="업장명"/>
<c:set var="str_office_address" value="주소"/>
<c:set var="str_office_class" value="분류"/>

<c:set var="str_service_id" value="진료과 ID"/>
<c:set var="str_office_tel" value="전화번호"/>
<c:set var="str_office_image" value="홍보사진경로"/>
<c:set var="str_office_image_path" value="홍보사진경로"/>
<c:set var="str_office_keyword" value="홍보문구"/>
<c:set var="str_office_business_hours_noti" value="영업시간 기타 공지"/>
<c:set var="str_office_start_mon" value="월요일 영업 시작"/>
<c:set var="str_office_end_mon" value="월요일 영업 종료"/>
<c:set var="str_office_start_tue" value="화요일 영업 시작"/>
<c:set var="str_office_end_tue" value="화요일 영업 종료"/>
<c:set var="str_office_start_wed" value="수요일 영업 시작"/>
<c:set var="str_office_end_wed" value="수요일 영업 종료"/>
<c:set var="str_office_start_thu" value="목요일 영업 시작"/>
<c:set var="str_office_end_thu" value="목요일 영업 종료"/>
<c:set var="str_office_start_fri" value="금요일 영업 시작"/>
<c:set var="str_office_end_fri" value="금요일 영업 종료"/>
<c:set var="str_office_start_sat" value="토요일 영업 시작"/>
<c:set var="str_office_end_sat" value="토요일 영업 종료"/>
<c:set var="str_office_start_sun" value="일요일 영업 시작"/>
<c:set var="str_office_end_sun" value="일요일 영업 종료"/>

<c:set var="btn_modify" value="수정"/>
<c:set var="btn_cancel" value="취소"/>

