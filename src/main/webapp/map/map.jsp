<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="setting_map.jsp"%>
<link href="${project}style_map.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="/quickmap/jquery-3.6.4.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=3dc8348a47c6ca7030528334a83b33b0"></script>
<script src="${project}script_map.js"></script>

<body>
	<div class="areaSearch">
		<div id="user">
			<c:if test="${user_id eq null}">
				<form method="post" action="memberloginform.do" name="user_beforeloginform">
					<table>
						<tr>
							<td>
								<input type="submit" value="${btn_login}">
							</td>
						</tr>
						<tr>
							<td>
								<a href="memberinputform.do">${str_id}</a>
							</td>
						</tr>
					</table>
				</form>
			</c:if>
			
			<c:if test="${user_id ne null}">
				<form method="post" action="membermodifyview.do" name="user_afterloginform">
					<table>
						<tr>
							<td rowspan="3">
								<img alt="user image" src="${images}default-profile.png" width="100px" height="100px">
							</td>
							<td colspan="2">
								<h3>${user_nick}</h3>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<h4>${user_id}</h4>
							</td>
						</tr>
						<tr>
							<td>
								<input type="submit" value="${str_mypage}">
							</td>
							<td>
								<input type="button" value="${str_logout}" onclick="location='memberlogout.do'">
							</td>
						</tr>
					</table>
				</form>
			</c:if>
		</div>
		<div id="search">
			<!-- <form method="post" name="map_searchform"> -->
				<table>
					<tr>
						<td>
							<select name="officeClass">
								<option value="0">${str_class_hos}</option>
								<option value="1">${str_class_pha}</option>
							</select>
						</td>
						<td>
							<input type="text" name="searchWord" placeholder="${msg_searchword}" autofocus>
						</td>
						<td>
							<input type="image" name="imgSearchOffice" src="${images}search-32.png" alt="${btn_search}">
						</td>
					</tr>
				</table>
			<!-- </form> -->
		</div>
		<div id="searchResult">
		</div>
	</div>
	<div id="kakaomap" class="areaMap">
	</div>
</body>

