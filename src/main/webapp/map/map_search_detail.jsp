<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- ${resulthtml} --%>

<%@ include file="setting_map.jsp"%>
<link href="${project}style_map.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="/quickmap/jquery-3.6.4.js"></script>

<div class="office_detail">
	<div class="office_detail_info_box">
		<!-- 병원정보 -->
		<div class="office_detail_image">
			<img src="${images}ad_24.png" alt="[ad]">
			<img src="${images}ad_24.png" alt="[ad]">
			<img src="${images}ad_24.png" alt="[ad]">
		</div>
		<div class="office_detail_name">
			<h3>세상에서 제일가는 치킨 전문 병원</h3>
		</div>
		<div class="office_detail_keyword">
			<h5>강남역 22번 출구</h5>
			<h5>강남역 23번 출구</h5>
			<h5>강남역 34번 출구</h5>
			<h5>강남역 45번 출구</h5>
		</div>
		<div class="office_detail_tel">
			<h5>02-1234-1234</h5>
		</div>
		<div class="office_detail_address">
			<h5>서울 서초구 서초대로 74길 33 비트빌빌딩</h5>
		</div>
		<div class="office_detail_comm">
			<div class="office_detail_favorite">
				<!-- 즐겨찾기 등록/해제 구분해야 함 -->
				<img class="office_detail_fav_y" src="${images}ad_24.png" alt="[f_y]">
			</div>
			<div class="office_detail_star">
				<img class="office_detail_image_star" src="${images}ad_24.png" alt="[star]">
				<h5>4.5</h5>
			</div>
			<div class="office_detail_review_num">
				<h5>방문자 리뷰 : </h5>
				<h5>9999</h5>
			</div>
		</div>
		<hr>
		<div class="office_detail_reg">
			<!-- 소유주 등록 -->
			<a href="#">비즈니스의 소유주인가요? 소유주 등록하고 혜택을 받아보세요</a>
		</div>
		<hr>
		<div class="office_detail_business_hours">
			<!-- 영업 시간 -->
			<h4 class="office_detail_business_hours_title">영업 시간</h4>
			<h5>영업중 - 18:30에 영업 종료</h5>
		</div>
		<hr>
		<div class="office_detail_service">
			<!-- 진료 과목 -->
			<h4 class="office_detail_service_title">진료 과목</h4>
			<h5>내과</h5>
		</div>
		<hr>
		<div class="office_detail_review_list">
			<!-- 방문자 리뷰 -->
			<div class="office_detail_review_list_title">
				<h4>방문자 리뷰</h4>
				<!-- 편집 / 작성 구분해야 함 -->
				<img class="office_detail_review_image" src="${images}ad_24.png" alt="[close]">
			</div>
			<div class="office_detail_review_item">
				<!-- 리뷰 리스트 -->
				<div class="office_detail_review_content">
					잘 먹었습니다! 고기가 엄청 부드럽진 않고.. 멸치국수 너무 비리고, 안경쓴 아주머니..주문하면 대답도 없고, 계산서.. 왜 돈 내고 먹는데 손님이 거지인 것.. 굉장히 무례하고 다시는 안가고 싶네요.. 쬬아~!
				</div>
				<div class="office_detail_review_comm">
					<div class="office_detail_user_nick">
						<b>내가다시는가나봐라</b>
					</div>
					<div class="office_detail_user_star">
						★★★★★
					</div>
					<div class="office_detail_review_date">
						2023.05.24
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="office_detail_close_box">
		<img class="office_detail_close_image" src="${images}ad_24.png" alt="[close]">
	</div>
</div>