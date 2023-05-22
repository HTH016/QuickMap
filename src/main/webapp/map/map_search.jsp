<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="setting_map.jsp"%>
<link href="${project}style_map.css" rel="stylesheet" type="text/css">
<script src="${project}script_map.js"></script>

<form method="post" action="map_do_search.do" name="map_searchform" onsubmit="return checkSearchWord()">
	<input type="hidden" name="latiSouth" value="">
	<input type="hidden" name="latiNorth" value="">
	<input type="hidden" name="longWest"  value="">
	<input type="hidden" name="longEast"  value="">
	<input type="hidden" name="mapLevel"  value="">
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
				<input type="image" src="${images}search-32.png" alt="${btn_search}">
			</td>
		</tr>
	</table>
</form>

