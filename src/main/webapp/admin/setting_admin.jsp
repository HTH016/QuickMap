<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"%>


<c:set var="project"				value="/quickmap/admin/"/>

<c:set var="page_default"			value="기 본 페 이 지"/>
<c:set var="page_main"				value="메 인 페 이 지"/>
<c:set var="page_admin"				value="관리자 페이지"/>
<c:set var="page_admin_user"		value="회원 관리"/>
<c:set var="page_admin_user_info"	value="회원 정보 및 등급 수정"/>
<c:set var="page_admin_office"		value="업장 등록 관리"/>
<c:set var="page_admin_grade"		value="업장 등급 관리"/>
<c:set var="page_admin_ad"			value="광고 신청 관리"/>
<c:set var="page_admin_statistics"	value="관리자 통계"/>

<c:set var="msg_main"				value="비회원이시면 회원가입을 해주세요"/>
<c:set var="msg_no_user"			value="등록된 회원이 없습니다"/>
<c:set var="str_no_review"			value="님의 리뷰가 없습니다"/>
<c:set var="str_no_request_regist"	value="대기중인 신청자가 없습니다"/>
<c:set var="str_no_request"			value="대기중인 신청이 없습니다"/>
<c:set var="str_no_request_ad"		value="대기중인 신청 광고가 없습니다"/>
	
<c:set var="str_id"						value="아이디"/>
<c:set var="str_nick"					value="닉네임"/>
<c:set var="str_passwd"					value="비밀번호"/>
<c:set var="str_name"					value="이름"/>
<c:set var="str_tel"					value="전화번호"/>
<c:set var="str_email"					value="이메일"/>
<c:set var="str_user_reg"				value="가입일자"/>
<c:set var="str_user_grade"				value="회원등급"/>
<c:set var="str_review_writer"			value="님의 리뷰"/>
<c:set var="str_office_regist"			value="사업자 등록증"/>
<c:set var="str_office_name"			value="업장명"/>
<c:set var="str_review"					value="후기"/>
<c:set var="str_star"					value="별점"/>
<c:set var="str_reg_date"				value="작성일"/>
<c:set var="str_writer"					value="작성자"/>
<c:set var="str_request_date"			value="신청일"/>
<c:set var="str_ad_start"				value="시작일"/>
<c:set var="str_ad_end"					value="종료일"/>
<c:set var="str_ad_level"				value="레벨"/>


<c:set var="btn_cancel"					value="취소"/>
<c:set var="btn_admin_user"				value="회원 관리"/>
<c:set var="btn_admin_office"			value="업장 등록 관리"/>
<c:set var="btn_admin_grade"			value="업장 등급 관리"/>
<c:set var="btn_admin_ad"				value="광고 신청 관리"/>
<c:set var="btn_admin_statistics"		value="관리자 통계"/>
<c:set var="btn_to_main"				value="메인"/>
<c:set var="btn_user_sort"				value="정렬"/>
<c:set var="btn_user_search"			value="검색"/>
<c:set var="btn_user_modify"			value="회원 등급 수정"/>
<c:set var="btn_to_list"				value="목록"/>
<c:set var="btn_to_review"				value="리뷰 내역 보기"/>
<c:set var="btn_delete"					value="삭제"/>
<c:set var="btn_office_regist_ok"		value="업장 등록 승인"/>
<c:set var="btn_office_ad_ok"			value="광고 승인"/>
<c:set var="btn_office_grade_modify" 	value="등급 조정"/>

<c:set var="option_reg_new"				value="가입일자(최신순)"/>
<c:set var="option_reg_old"				value="가입일자(오래된순)"/>
<c:set var="option_user_general"		value="일반회원"/>
<c:set var="option_user_regist"			value="등록회원"/>
<c:set var="option_id"					value="아이디"/>
<c:set var="option_nick"				value="닉네임"/>
<c:set var="option_user_delete"			value="탈퇴"/>
<c:set var="option_user_freeze"			value="활동정지"/>


