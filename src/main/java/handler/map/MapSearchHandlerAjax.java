package handler.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import map.MapDao;
import map.MapOfficeDetailDTO;
import statistics.StatisticsDAO;
import statistics.StatisticsSearchDTO;

@Controller
public class MapSearchHandlerAjax {
	@Resource(name="mapDao")
	private MapDao mapDao;

	@Resource(name="statisticsDao")
	private StatisticsDAO statisticsDao;

	@RequestMapping("/map_search_ajax")
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");

		String		user_id			= (String) request.getSession().getAttribute("memId");
		String		strSearchResult	= "";
		String[]	arrayWords		= request.getParameter("searchWord").split("\\s");
		int			officeClass		= Integer.parseInt(request.getParameter("officeClass"));

		for(int i=0 ; i<arrayWords.length ; i++) {
			String	word	= arrayWords[i];
			
			if(word.length() == 1) {
				arrayWords[i] = arrayWords[i] + "이";
			} else if(word.length() > 2) {
				arrayWords[i] = word.substring(0, 2);
			}

			System.out.println("wordlist : " + arrayWords[i]);
			
			StatisticsSearchDTO dto	= new StatisticsSearchDTO();
			
			dto.setUser_id(user_id);
			dto.setSearch_word(word);
			dto.setSearch_class(officeClass);
			
			statisticsDao.insertSearch(dto);
		}
		
		List<String>	serviceIds		= mapDao.searchServiceIdList(arrayWords);
		
		System.out.println("serviceIds   : " + serviceIds);
		
		if(serviceIds.size() > 0) {
			String strLatiSouth	= request.getParameter("latiSouth");
			String strLatiNorth	= request.getParameter("latiNorth");
			String strLongWest	= request.getParameter("longWest");
			String strlongEast	= request.getParameter("longEast");
			String strMapLevel	= request.getParameter("mapLevel");
			
			double	latiSouth	= Double.parseDouble(strLatiSouth);
			double	latiNorth	= Double.parseDouble(strLatiNorth);
			double	longWest	= Double.parseDouble(strLongWest);
			double	longEast	= Double.parseDouble(strlongEast);
			int		mapLevel	= Integer.parseInt(strMapLevel);
			
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
			
			int		i		= 0;
			long	seed	= System.currentTimeMillis();
			Random	rand	= new Random(seed);


			for(MapOfficeDetailDTO dto : officeList) {
				strSearchResult	+= "<div id=\"" + dto.getOffice_id() + "\" class=\"office_search_result_box\">\n";
				strSearchResult	+= "	<span class=\"marker_index\" hidden>" + (i++) + "</span>\n";
				strSearchResult	+= "	<span class=\"office_loc_latitude\" hidden>" + dto.getOffice_loc_latitude() + "</span>\n";
				strSearchResult	+= "	<span class=\"office_loc_longitude\" hidden>" + dto.getOffice_loc_longitude() + "</span>\n";
				strSearchResult	+= "	<div id=\"office_card\">\n";
				
				if(dto.getOffice_ad_state().equals("1")) {
					strSearchResult	+= "		<img class=\"image_ad\" src=\"/quickmap/images/ad_24.png\">\n";
				}
				
				strSearchResult	+= "		<div class=\"office_name\">\n";
				strSearchResult	+= "			<h3>" + dto.getOffice_name() + "</h3>\n";
				strSearchResult	+= "		</div>\n";
				strSearchResult	+= "	</div>\n";
				strSearchResult	+= "	<div>\n";
				strSearchResult	+= "		<div class=\"image_office\">\n";

				String		officeImages	= dto.getOffice_image();
				String[]	arrImage		= null;
				
				if(officeImages != null) {
					arrImage	= officeImages.split(";");
					
					int		 nImage		= arrImage.length;

					if(nImage > 0) {
						strSearchResult	+= "			<img src=\"/quickmap" + arrImage[rand.nextInt(nImage)] + "\">\n";
					} else {
						arrImage	= new String[3];
						arrImage[0]	= "/images/hos_00.jpg";
						arrImage[1]	= "/images/hos_01.jpg";
						arrImage[2]	= "/images/hos_02.jpg";

						strSearchResult	+= "			<img src=\"/quickmap" + arrImage[rand.nextInt(arrImage.length)] + "\">\n";
					}
				} else {
					arrImage	= new String[3];
					arrImage[0]	= "/images/hos_00.jpg";
					arrImage[1]	= "/images/hos_01.jpg";
					arrImage[2]	= "/images/hos_02.jpg";

					strSearchResult	+= "			<img src=\"/quickmap" + arrImage[rand.nextInt(arrImage.length)] + "\">\n";
				}
				
				strSearchResult	+= "		</div>\n";
				strSearchResult	+= "		<div class=\"office_info_box\">\n";
				strSearchResult	+= "			<div class=\"office_keyword_box\">\n";
				
				if(dto.getOffice_keyword() != null) {
					String[] arrKeyword	= dto.getOffice_keyword().split(";");
					
					if(arrKeyword.length > 0 && arrKeyword[0] != null) {
						strSearchResult	+= "					<div>\n";
						strSearchResult	+= "						<h5 class=\"office_keyword\">" + arrKeyword[0] + "</h5>\n";
						
						if(arrKeyword.length > 1 && arrKeyword[1] != null) {
							strSearchResult	+= "						<h5 class=\"office_keyword\">" + arrKeyword[1] + "</h5>\n";
						}
						
						strSearchResult	+= "					</div>\n";
					}

					if(arrKeyword.length > 2 && arrKeyword[2] != null) {
						strSearchResult	+= "					<div>\n";
						strSearchResult	+= "						<h5 class=\"office_keyword\">" + arrKeyword[2] + "</h5>\n";
						
						if(arrKeyword.length > 3 && arrKeyword[3] != null) {
							strSearchResult	+= "						<h5 class=\"office_keyword\">" + arrKeyword[3] + "</h5>\n";
						}
						
						strSearchResult	+= "					</div>\n";
					}
				}
				
				strSearchResult	+= "			</div>\n";
				strSearchResult	+= "			<div>\n";
				strSearchResult	+= "				<h5 class=\"office_business_hours\">" + dto.getOffice_business_hours_noti() + "</h5>\n";
				strSearchResult	+= "			</div>\n";
				strSearchResult	+= "			<div>\n";
				strSearchResult	+= "				<div class=\"office_review_box\">\n";
				strSearchResult	+= "					<h5 class=\"office_review\">방문자리뷰 : </h5>\n";
				strSearchResult	+= "					<h5 class=\"office_review\">" + dto.getOffice_review_num() + "</h5>\n";
				strSearchResult	+= "				</div>\n";
				strSearchResult	+= "				<div class=\"office_star_box\">\n";
				strSearchResult	+= "					<h5 class=\"office_star\">별점 : </h5>\n";
				strSearchResult	+= "					<h5 class=\"office_star\">" + dto.getOffice_star() + "</h5>\n";
				strSearchResult	+= "				</div>\n";
				strSearchResult	+= "			</div>\n";
				strSearchResult	+= "		</div>\n";
				strSearchResult	+= "	</div>\n";
				strSearchResult	+= "</div>\n";
			}
			
			request.setAttribute("resulthtml", strSearchResult);
		}
		
		return new ModelAndView("map/map_search_result");
	}

}
