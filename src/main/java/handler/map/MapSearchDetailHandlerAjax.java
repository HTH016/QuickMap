package handler.map;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
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
import review.ReviewDAO;
import review.ReviewDataBean;
import statistics.StatisticsDAO;
import statistics.StatisticsDetailDTO;

@Controller
public class MapSearchDetailHandlerAjax {
	@Resource(name="mapDao")
	private MapDao mapDao;
	
	@Resource(name="favoriteDao")
	private FavoriteDao favoriteDao;
	
	@Resource(name="reviewDao")
	private ReviewDAO reviewDao;
	
	@Resource(name="statisticsDao")
	private StatisticsDAO statisticsDao;
	
	@RequestMapping("/map_search_detail_ajax")
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		int		officeId		= Integer.parseInt(request.getParameter("officeId"));
		String	userId			= (String) request.getSession().getAttribute("memId");
		MapOfficeDetailDTO	dto	= mapDao.getOfficeInfoByOfficeId(officeId);
		
		StatisticsDetailDTO detailDTO	= new StatisticsDetailDTO();
		
		detailDTO.setUser_id(userId);
		detailDTO.setOffice_id(officeId);
		
		statisticsDao.insertStatisticsDetail(detailDTO);
		
		String	strSearchResult	= "";
		
		System.out.println(Thread.currentThread().getStackTrace()[1] + ">> userId : " + userId);
		
		strSearchResult	+= "<span id=\"map_user_id\" hidden>" + userId + "</span>\n";
		strSearchResult	+= "<span id=\"map_office_id\" hidden>" + officeId + "</span>\n";

		if(userId != null) {
			Map<String, Object>	param	= new HashMap<>();

			param.put("userId", userId);
			param.put("officeId", officeId);

			int	hasReview	= reviewDao.getReviewCount(param);

			strSearchResult	+= "<span id=\"map_has_review\" hidden>" + hasReview + "</span>\n";
		}

		strSearchResult	+= "<div class=\"office_detail\">\n";
		strSearchResult	+= "	<div class=\"office_detail_info_box\">\n";
		strSearchResult	+= "		<div class=\"office_detail_image\">\n";
		
		String	images	= dto.getOffice_image();
		
		if(images != null) {
			String[] arrImage	= images.split(";");
			
			for(int i=0 ; i<arrImage.length ; i++) {
				strSearchResult	+= "			<img src=\"/quickmap" + arrImage[i]+ "\">\n";
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
			Map<String, Object>	paramFav	= new HashMap<>();
			
			paramFav.put("userId", userId);
			paramFav.put("officeId", officeId);
			
			if(favoriteDao.getFavoriteCount(paramFav) == 0) {
				strSearchResult	+= "				<img class=\"office_detail_fav_image\" src=\"/quickmap/images/fav_emp.png\">\n";
			} else {
				strSearchResult	+= "				<img class=\"office_detail_fav_image\" src=\"/quickmap/images/fav_sol.png\">\n";
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

		if(userId != null) {
			strSearchResult	+= "		<div class=\"office_detail_reg\">\n";
			strSearchResult	+= "			<a href=\"officeregister.do?officeId=" + dto.getOffice_id() + "\">비즈니스의 소유주인가요?<br> 소유주 등록하고 혜택을 받아보세요</a>\n";
			strSearchResult	+= "		</div>\n";
			strSearchResult	+= "		<hr>\n";
		}
		
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
		strSearchResult	+= "			<h5>"+ mapDao.getServiceName(dto.getService_id()) +"</h5>\n";
		strSearchResult	+= "		</div>\n";
		strSearchResult	+= "		<hr>\n";
		strSearchResult	+= "		<div class=\"office_detail_review_list\">\n";
		strSearchResult	+= "			<div class=\"office_detail_review_list_title\">\n";
		strSearchResult	+= "				<h4>방문자 리뷰</h4>\n";

		if(userId != null) {
//			strSearchResult	+= "				<img id=\"" + userId + "\" class=\"office_detail_review_image\" src=\"/quickmap/images/write_32.png\">\n";
			strSearchResult	+= "				<img class=\"office_detail_review_image\" src=\"/quickmap/images/write_32.png\">\n";
		}

		strSearchResult	+= "			</div>\n";
		strSearchResult	+= "			<div class=\"office_detail_review_item_list\">\n";

		Map<String, Object>		paramRev	= new HashMap<>();
		List<ReviewDataBean>	reviews		= null;
		
		if(userId == null) {
			paramRev.put("officeId", officeId);
			
			reviews	= reviewDao.getOfficeReviewList(paramRev, false);
		} else {
			paramRev.put("userId", userId);
			paramRev.put("officeId", officeId);

			reviews	= reviewDao.getOfficeReviewList(paramRev, true);
		}
		
		for(ReviewDataBean review : reviews) {
			strSearchResult	+= "			<div class=\"office_detail_review_item\">\n";
			strSearchResult	+= "				<div class=\"office_detail_review_content\">\n";
			strSearchResult	+= "					" + review.getReview_data() + "\n";
			strSearchResult	+= "				</div>\n";
			strSearchResult	+= "				<div class=\"office_detail_review_comm\">\n";
			strSearchResult	+= "					<div class=\"office_detail_user_nick\">\n";
			strSearchResult	+= "						<b>" + review.getUser_nick() + "</b>\n";
			strSearchResult	+= "					</div>\n";
			strSearchResult	+= "					<div class=\"office_detail_user_star\">\n";
			
			double	nStar	= review.getReview_star();
			
			if(nStar > 4) {
				strSearchResult	+= "						★★★★★\n";
			} else if(nStar > 3) {
				strSearchResult	+= "						★★★★☆\n";
			} else if(nStar > 2) {
				strSearchResult	+= "						★★★☆☆\n";
			} else if(nStar > 1) {
				strSearchResult	+= "						★★☆☆☆\n";
			} else {
				strSearchResult	+= "						★☆☆☆☆\n";
			}
			
			strSearchResult	+= "					</div>\n";
			strSearchResult	+= "					<div class=\"office_detail_review_date\">\n";
			
			SimpleDateFormat	sdf	= new SimpleDateFormat("yyyy-MM-dd");

			strSearchResult	+= "						" + sdf.format(review.getReview_reg()) + "\n";
			strSearchResult	+= "					</div>\n";
			strSearchResult	+= "				</div>\n";
			strSearchResult	+= "				</div>\n";
		}
		
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
