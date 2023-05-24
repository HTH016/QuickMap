<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

${resulthtml}


<%-- 검증용으로 주석 처리만 해둠
<%@ include file="setting_map.jsp"%>
<link href="${project}style_map.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="/quickmap/jquery-3.6.4.js"></script>

<c:forEach var="dto" items="${dtos}">
<div class="office_search_result_box">
	<div id="office_card">
		<c:if test="${dto.office_ad_state eq '1'}">
		<img class="image_ad" src="${images}ad_24.png" alt="[ad]">
		</c:if>
		<div class="office_name">
			<h3>${dto.office_name}</h3>
		</div>
	</div>
	<div>
		<div class="image_office">
		</div>
		<div class="office_info_box">
			<div class="office_keyword_box">	<!-- height 결정해야 함 -->
				<c:if test="${dto.office_keyword ne null}">
					<c:set var="arrKeyword" value="${fn:split(dto.office_keyword,';')}" />
					<c:if test="${arrKeyword[0] ne null}">
					<div>
						<h5 class="office_keyword">${arrKeyword[0]}</h5>
						<c:if test="${arrKeyword[1] ne null}">
						<h5 class="office_keyword">${arrKeyword[1]}</h5>
						</c:if>
					</div>
					</c:if>
					<c:if test="${arrKeyword[2] ne null}">
					<div>
						<h5 class="office_keyword">${arrKeyword[2]}</h5>
						<c:if test="${arrKeyword[3] ne null}">
						<h5 class="office_keyword">${arrKeyword[3]}</h5>
						</c:if>
					</div>
					</c:if>
				</c:if>
			</div>
			<div>
				<h5 class="office_business_hours">${dto.office_business_hours_noti}</h5>
			</div>
			<div>
				<div class="office_review_box">
					<h5 class="office_review">${str_review}</h5>
					<h5 class="office_review">${dto.office_review_num}</h5>
				</div>
				<div class="office_star_box">
					<h5 class="office_star">${str_starpoint}</h5>
					<h5 class="office_star">${office_star}</h5>
				</div>
			</div>
		</div>
	</div>
</div>
</c:forEach>
--%>