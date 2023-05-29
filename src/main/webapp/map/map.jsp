<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="setting_map.jsp"%>
<link href="${project}style_map_gpt.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="/quickmap/jquery-3.6.4.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=3dc8348a47c6ca7030528334a83b33b0"></script>
<script src="${project}script_map.js"></script>

<body>
	<div class="areaSearch">
		<div id="user_part">
			<c:if test="${user_id eq null}">
				<div class="user_do_login">
					<form method="post" action="memberloginform.do" name="user_beforeloginform">
						<input class="user_login_btn" type="submit" value="퀵맵 로그인">
						<div class="user_sign_up">
							<a href="memberinputform.do">회원가입</a>
						</div>
					</form>
				</div>
			</c:if>
			
			<c:if test="${user_id ne null}">
				<div class="user_do_logout">
					<form method="post" action="membermodifyview.do" name="user_afterloginform">
						<div class="user_image">
							<img src="${images}default-profile.png">
						</div>
						<div class="user_info">
							<div class="user_info_nick">
								<h3>${user_nick}</h3>
							</div>
							<div class="user_info_id">
								<h4>${user_id}</h4>
							</div>
							<div class="user_info_button">
								<input type="submit" value="마이페이지">
								<input type="button" value="로그아웃" onclick="location='memberlogout.do'">
							</div>
						</div>
					</form>
				</div>
			</c:if>
		</div>
		<div id="search">
			<div class="search_class">
				<select name="officeClass">
					<option value="0">${str_class_hos}</option>
					<option value="1">${str_class_pha}</option>
				</select>
			</div>
			<div class="search_word">
				<input type="text" name="searchWord" placeholder="${msg_searchword}" autofocus>
			</div>
			<div class="search_image">
				<input type="image" name="imgSearchOffice" src="${images}search-32.png">
			</div>
		</div>
		<div id="searchResult">
		</div>
		<div id="searchDetail">
		</div>
	</div>
	<div id="kakaomap" class="areaMap">
	</div>
</body>

