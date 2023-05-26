package handler.map;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import favorite.FavoriteDao;
import map.MapDao;
import map.MapOfficeDetailDTO;

@Controller
public class MapSearchDetailHandlerAjax {
	@Resource(name="mapDao")
	private MapDao mapDao;
	
	@Resource(name="favoriteDao")
	private FavoriteDao favoriteDao;
	
	@RequestMapping("/map_search_detail_ajax")
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		int					officeId		= Integer.parseInt(request.getParameter("officeId"));
		MapOfficeDetailDTO	dto				= mapDao.getOfficeInfoByOfficeId(officeId);
		String				userId			= (String) request.getSession().getAttribute("memId");
		String				strSearchResult	= "";
		
		System.out.println(Thread.currentThread().getStackTrace()[1] + ">> userId : " + userId);

		strSearchResult	+= "<div class=\"office_detail\">\n";
		strSearchResult	+= "	<div class=\"office_detail_info_box\">\n";
		strSearchResult	+= "		<div class=\"office_detail_image\">\n";
		
		String	images	= dto.getOffice_image();
		
		if(images != null) {
			String[] arrImage	= images.split(";");
			
			for(int i=0 ; i<arrImage.length ; i++) {
				strSearchResult	+= "			<img src=\"" + arrImage[i]+ "\">\n";
			}

			for(int i=0 ; i<3-arrImage.length ; i++) {
				strSearchResult	+= "			<img src=\"/quickmap/images/hos_0" + i + ".jpg\">\n";
			}
		} else {
			for(int i=0 ; i<3 ; i++) {
				strSearchResult	+= "			<img src=\"/quickmap/images/hos_0" + i + ".jpg\">\n";
			}
		}

		strSearchResult	+= "		</div>\n";
		strSearchResult	+= "		<div class=\"office_detail_name\">\n";
		strSearchResult	+= "			<h3>" + dto.getOffice_name() + "</h3>\n";
		strSearchResult	+= "		</div>\n";
		strSearchResult	+= "		<div class=\"office_detail_keyword\">\n";

		String	keywords	= dto.getOffice_keyword();
		
		if(keywords != null) {
			String[] arrKeyword	= keywords.split(";");

			for(int i=0 ; i<arrKeyword.length ; i++) {
				strSearchResult	+= "			<h5>" + arrKeyword[i] + "</h5>\n";
			}
		}

		strSearchResult	+= "		</div>\n";
		strSearchResult	+= "		<div class=\"office_detail_tel\">\n";
		strSearchResult	+= "			<h5>"+ dto.getOffice_tel() +"</h5>\n";
		strSearchResult	+= "		</div>\n";
		strSearchResult	+= "		<div class=\"office_detail_address\">\n";
		strSearchResult	+= "			<h5>"+ dto.getOffice_address() +"</h5>\n";
		strSearchResult	+= "		</div>\n";
		strSearchResult	+= "		<div class=\"office_detail_comm\">\n";
		strSearchResult	+= "			<div class=\"office_detail_favorite\">\n";

		if(userId != null) {
			Map<String, Object>	param	= new HashMap<>();
			
			param.put("userId", userId);
			param.put("officeId", dto.getOffice_id());
			
			if(favoriteDao.getFavoriteCount(param) == 0) {
				strSearchResult	+= "				<img class=\"office_detail_fav_y\" src=\"/quickmap/images/fav_emp.png\">\n";
			} else {
				strSearchResult	+= "				<img class=\"office_detail_fav_y\" src=\"/quickmap/images/fav_sol.png\">\n";
			}
		}
		
		strSearchResult	+= "			</div>\n";
		strSearchResult	+= "			<div class=\"office_detail_star\">\n";
		strSearchResult	+= "				<img class=\"office_detail_image_star\" src=\"/quickmap/images/star_32.png\">\n";
		strSearchResult	+= "				<h5>" + dto.getOffice_star() + "</h5>\n";
		strSearchResult	+= "			</div>\n";
		strSearchResult	+= "			<div class=\"office_detail_review_num\">\n";
		strSearchResult	+= "				<h5>방문자 리뷰 : </h5>\n";
		strSearchResult	+= "				<h5>" + dto.getOffice_review_num() + "</h5>\n";
		strSearchResult	+= "			</div>\n";
		strSearchResult	+= "		</div>\n";
		strSearchResult	+= "		<hr>\n";
		strSearchResult	+= "		<div class=\"office_detail_reg\">\n";
		strSearchResult	+= "			<a href=\"#\">비즈니스의 소유주인가요?<br> 소유주 등록하고 혜택을 받아보세요</a>\n";
		strSearchResult	+= "		</div>\n";
		strSearchResult	+= "		<hr>\n";
		strSearchResult	+= "		<div class=\"office_detail_business_hours\">\n";
		strSearchResult	+= "			<h4 class=\"office_detail_business_hours_title\">영업 시간</h4>\n";
		
		int		dayofweek	= LocalDateTime.now().getDayOfWeek().getValue();	// 1:월요일 ~ 7:일요일
		String	startT		= "";
		String	endT		= "";
		
		switch(dayofweek) {
		case 1:
			startT	= dto.getOffice_start_mon();
			endT	= dto.getOffice_end_mon();
			break;
		case 2:
			startT	= dto.getOffice_start_tue();
			endT	= dto.getOffice_end_tue();
			break;
		case 3:
			startT	= dto.getOffice_start_wed();
			endT	= dto.getOffice_end_wed();
			break;
		case 4:
			startT	= dto.getOffice_start_thu();
			endT	= dto.getOffice_end_thu();
			break;
		case 5:
			startT	= dto.getOffice_start_fri();
			endT	= dto.getOffice_end_fri();
			break;
		case 6:
			startT	= dto.getOffice_start_sat();
			endT	= dto.getOffice_end_sat();
			break;
		case 7:
			startT	= dto.getOffice_start_sun();
			endT	= dto.getOffice_end_sun();
			break;
		}
		
		DateTimeFormatter	dtf			= DateTimeFormatter.ofPattern("HHmm");
		LocalTime	now			= LocalTime.now();
		LocalTime	officeStart	= null;
		LocalTime	officeEnd	= null;
		int			nWorking	= -1;	// -1 : 영업전, 0 : 영업중, 1 : 영업종료

		System.out.println(Thread.currentThread().getStackTrace()[1] + " >> startT : " + startT);
		System.out.println(Thread.currentThread().getStackTrace()[1] + " >> endT   : " + endT);

		if(!startT.equals("")) {
			officeStart	= LocalTime.parse(startT, dtf);
			
			if(now.compareTo(officeStart) > 0)
			{
				nWorking	= 0;
				
				if(!endT.equals("")) {
					officeEnd	= LocalTime.parse(endT, dtf);
					
					if(now.compareTo(officeEnd) > 0) {
						nWorking	= 1;
					}
				}
			}
		} else if(!endT.equals("")) {
			officeEnd	= LocalTime.parse(endT, dtf);
			
			if(now.compareTo(officeEnd) < 0) {
				nWorking	= 0;
			} else if(now.compareTo(officeEnd) > 0) {
				nWorking	= 1;
			}
		}
		
		if(nWorking > 0) {
			strSearchResult	+= "			<h5>영업종료</h5>\n";
		} else if(nWorking < 0) {
			if(!startT.equals("")) {
				strSearchResult	+= "			<h5>영업전 - " + officeStart.getHour() + ":" + officeStart.getMinute() + " 에 영업 시작</h5>\n";
			} else {
				strSearchResult	+= "			<h5>영업전 - 영업 시작 정보 없음</h5>\n";
			}
		} else {
			if(!endT.equals("")) {
				strSearchResult	+= "			<h5>영업중 - " + officeEnd.getHour() + ":" + officeEnd.getMinute() + " 에 영업 종료</h5>\n";
			} else {
				strSearchResult	+= "			<h5>영업중 - 영업 종료 정보 없음</h5>\n";
			}
		}
		
		
		strSearchResult	+= "		</div>\n";
		strSearchResult	+= "		<hr>\n";
		strSearchResult	+= "		<div class=\"office_detail_service\">\n";
		strSearchResult	+= "			<h4 class=\"office_detail_service_title\">진료 과목</h4>\n";
		strSearchResult	+= "			<h5>"+ dto.getService_id() +"</h5>\n";
		strSearchResult	+= "		</div>\n";
		strSearchResult	+= "		<hr>\n";
		strSearchResult	+= "		<div class=\"office_detail_review_list\">\n";
		strSearchResult	+= "			<div class=\"office_detail_review_list_title\">\n";
		strSearchResult	+= "				<h4>방문자 리뷰</h4>\n";

		if(userId != null) {
			strSearchResult	+= "				<img id=\"" + userId + "\" class=\"office_detail_review_image\" src=\"/quickmap/images/write_32.png\">\n";
		}

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
		strSearchResult	+= "		<img class=\"office_detail_close_image\" src=\"/quickmap/images/arrow_left_32.png\">\n";
		strSearchResult	+= "	</div>\n";
		strSearchResult	+= "</div>\n";

		request.setAttribute("detailhtml", strSearchResult);
//		}
		
		return new ModelAndView("map/map_search_detail");
	}

}
