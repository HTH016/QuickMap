package handler.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import map.MapDao;
import map.MapOfficeDetailDTO;

@Controller
public class MapSearchDetailHandlerAjax {
	@Resource(name="mapDao")
	private MapDao mapDao;

	@RequestMapping("/map_search_detail_ajax")
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");

		String		strSearchResult	= "";
/*
		String[]	arrayWords		= request.getParameter("searchWord").split("\\s");

		for(int i=0 ; i<arrayWords.length ; i++) {
			String	word	= arrayWords[i];
			
			if(word.length() == 1) {
				arrayWords[i] = arrayWords[i] + "이";
			} else if(word.length() > 2) {
				arrayWords[i] = word.substring(0, 2);
			}

			System.out.println("wordlist : " + arrayWords[i]);
		}
		
		List<String>	serviceIds		= mapDao.searchServiceIdList(arrayWords);
		
		System.out.println("serviceIds   : " + serviceIds);
		
		if(serviceIds.size() > 0) {
			String strLatiSouth	= request.getParameter("latiSouth");
			String strLatiNorth	= request.getParameter("latiNorth");
			String strLongWest	= request.getParameter("longWest");
			String strlongEast	= request.getParameter("longEast");
			String strMapLevel	= request.getParameter("mapLevel");
			String strOfficeClass	= request.getParameter("officeClass");
			
			double	latiSouth	= Double.parseDouble(strLatiSouth);
			double	latiNorth	= Double.parseDouble(strLatiNorth);
			double	longWest	= Double.parseDouble(strLongWest);
			double	longEast	= Double.parseDouble(strlongEast);
			int		mapLevel	= Integer.parseInt(strMapLevel);
			int		officeClass	= Integer.parseInt(strOfficeClass);
			
			System.out.println("latiSouth  : " + latiSouth + " / latiNorth : " + latiNorth);
			System.out.println("longWest   : " + longWest  + " / longEast  : " + longEast);
			System.out.println("mapLevel   : " + mapLevel);
			
			Map<String, Object> param	= new HashMap<>();

			param.put("latiSouth", latiSouth);
			param.put("latiNorth", latiNorth);
			param.put("longWest", longWest);
			param.put("longEast", longEast);
			param.put("mapLevel", mapLevel);
			param.put("officeClass", officeClass);
			param.put("serviceIds", serviceIds);
			
			List<MapOfficeDetailDTO> officeList	= new ArrayList<>();
			List<MapOfficeDetailDTO> dtosAd		= mapDao.searchOfficeList(param, true);

			for(MapOfficeDetailDTO dto : dtosAd) {
				System.out.println("[dtosAd] office_id : " + dto.getOffice_id() + " / service_id : " + dto.getService_id());
				dto.setOffice_ad_state("1");
			}

			List<MapOfficeDetailDTO> dtosNormal	= mapDao.searchOfficeList(param, false);
			
			for(MapOfficeDetailDTO dto : dtosNormal) {
				System.out.println("[dtosNo] office_id : " + dto.getOffice_id() + " / service_id : " + dto.getService_id());
			}
			
			officeList.addAll(dtosAd);
			officeList.addAll(dtosNormal);
*/			

		strSearchResult	+= "<div class=\"office_detail\">\n";
		strSearchResult	+= "	<div class=\"office_detail_info_box\">\n";
		strSearchResult	+= "		<!-- 병원정보 -->\n";
		strSearchResult	+= "		<div class=\"office_detail_image\">\n";
		strSearchResult	+= "			<img src=\"${images}ad_24.png\" alt=\"[ad]\">\n";
		strSearchResult	+= "			<img src=\"${images}ad_24.png\" alt=\"[ad]\">\n";
		strSearchResult	+= "			<img src=\"${images}ad_24.png\" alt=\"[ad]\">\n";
		strSearchResult	+= "		</div>\n";
		strSearchResult	+= "		<div class=\"office_detail_name\">\n";
		strSearchResult	+= "			<h3>세상에서 제일가는 치킨 전문 병원</h3>\n";
		strSearchResult	+= "		</div>\n";
		strSearchResult	+= "		<div class=\"office_detail_keyword\">\n";
		strSearchResult	+= "			<h5>강남역 22번 출구</h5>\n";
		strSearchResult	+= "			<h5>강남역 23번 출구</h5>\n";
		strSearchResult	+= "			<h5>강남역 34번 출구</h5>\n";
		strSearchResult	+= "			<h5>강남역 45번 출구</h5>\n";
		strSearchResult	+= "		</div>\n";
		strSearchResult	+= "		<div class=\"office_detail_tel\">\n";
		strSearchResult	+= "			<h5>02-1234-1234</h5>\n";
		strSearchResult	+= "		</div>\n";
		strSearchResult	+= "		<div class=\"office_detail_address\">\n";
		strSearchResult	+= "			<h5>서울 서초구 서초대로 74길 33 비트빌빌딩</h5>\n";
		strSearchResult	+= "		</div>\n";
		strSearchResult	+= "		<div class=\"office_detail_comm\">\n";
		strSearchResult	+= "			<div class=\"office_detail_favorite\">\n";
		strSearchResult	+= "				<!-- 즐겨찾기 등록/해제 구분해야 함 -->\n";
		strSearchResult	+= "				<img class=\"office_detail_fav_y\" src=\"${images}ad_24.png\" alt=\"[f_y]\">\n";
		strSearchResult	+= "			</div>\n";
		strSearchResult	+= "			<div class=\"office_detail_star\">\n";
		strSearchResult	+= "				<img class=\"office_detail_image_star\" src=\"${images}ad_24.png\" alt=\"[star]\">\n";
		strSearchResult	+= "				<h5>4.5</h5>\n";
		strSearchResult	+= "			</div>\n";
		strSearchResult	+= "			<div class=\"office_detail_review_num\">\n";
		strSearchResult	+= "				<h5>방문자 리뷰 : </h5>\n";
		strSearchResult	+= "				<h5>9999</h5>\n";
		strSearchResult	+= "			</div>\n";
		strSearchResult	+= "		</div>\n";
		strSearchResult	+= "		<hr>\n";
		strSearchResult	+= "		<div class=\"office_detail_reg\">\n";
		strSearchResult	+= "			<!-- 소유주 등록 -->\n";
		strSearchResult	+= "			<a href=\"#\">비즈니스의 소유주인가요? 소유주 등록하고 혜택을 받아보세요</a>\n";
		strSearchResult	+= "		</div>\n";
		strSearchResult	+= "		<hr>\n";
		strSearchResult	+= "		<div class=\"office_detail_business_hours\">\n";
		strSearchResult	+= "			<!-- 영업 시간 -->\n";
		strSearchResult	+= "			<h4 class=\"office_detail_business_hours_title\">영업 시간</h4>\n";
		strSearchResult	+= "			<h5>영업중 - 18:30에 영업 종료</h5>\n";
		strSearchResult	+= "		</div>\n";
		strSearchResult	+= "		<hr>\n";
		strSearchResult	+= "		<div class=\"office_detail_service\">\n";
		strSearchResult	+= "			<!-- 진료 과목 -->\n";
		strSearchResult	+= "			<h4 class=\"office_detail_service_title\">진료 과목</h4>\n";
		strSearchResult	+= "			<h5>내과</h5>\n";
		strSearchResult	+= "		</div>\n";
		strSearchResult	+= "		<hr>\n";
		strSearchResult	+= "		<div class=\"office_detail_review_list\">\n";
		strSearchResult	+= "			<!-- 방문자 리뷰 -->\n";
		strSearchResult	+= "			<div class=\"office_detail_review_list_title\">\n";
		strSearchResult	+= "				<h4>방문자 리뷰</h4>\n";
		strSearchResult	+= "				<!-- 편집 / 작성 구분해야 함 -->\n";
		strSearchResult	+= "				<img class=\"office_detail_review_image\" src=\"${images}ad_24.png\" alt=\"[close]\">\n";
		strSearchResult	+= "			</div>\n";
		strSearchResult	+= "			<div class=\"office_detail_review_item\">\n";
		strSearchResult	+= "				<!-- 리뷰 리스트 -->\n";
		strSearchResult	+= "				<div class=\"office_detail_review_content\">\n";
		strSearchResult	+= "					잘 먹었습니다! 고기가 엄청 부드럽진 않고.. 멸치국수 너무 비리고, 안경쓴 아주머니..주문하면 대답도 없고, 계산서.. 왜 돈 내고 먹는데 손님이 거지인 것.. 굉장히 무례하고 다시는 안가고 싶네요.. 쬬아~!\n";
		strSearchResult	+= "				</div>\n";
		strSearchResult	+= "				<div class=\"office_detail_review_comm\">\n";
		strSearchResult	+= "					<div class=\"office_detail_user_nick\">\n";
		strSearchResult	+= "						<b>내가다시는가나봐라</b>\n";
		strSearchResult	+= "					</div>\n";
		strSearchResult	+= "					<div class=\"office_detail_user_star\">\n";
		strSearchResult	+= "						★★★★★\n";
		strSearchResult	+= "					</div>\n";
		strSearchResult	+= "					<div class=\"office_detail_review_date\">\n";
		strSearchResult	+= "						2023.05.24\n";
		strSearchResult	+= "					</div>\n";
		strSearchResult	+= "				</div>\n";
		strSearchResult	+= "			</div>\n";
		strSearchResult	+= "		</div>\n";
		strSearchResult	+= "	</div>\n";
		strSearchResult	+= "	<div class=\"office_detail_close_box\">\n";
		strSearchResult	+= "		<img class=\"office_detail_close_image\" src=\"${images}ad_24.png\" alt=\"[close]\">\n";
		strSearchResult	+= "	</div>\n";
		strSearchResult	+= "</div>\n";

		request.setAttribute("detailhtml", strSearchResult);
//		}
		
		return new ModelAndView("map/map_search_detail");
	}

}
