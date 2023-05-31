package handler.statistics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import handler.CommandHandler;
import statistics.StatisticsDAO;
import statistics.StatisticsDetailDTO;
import statistics.StatisticsFavoriteDTO;
import statistics.StatisticsReviewDTO;

@Controller
public class StatisticsOfficeRangeFormHandler implements CommandHandler {
	
	@Resource(name="statisticsDao")
	private StatisticsDAO statisticsDao;
	
	@RequestMapping("/statisticsofficerangeform")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//int office_id = Integer.parseInt(request.getParameter("office_id"));
		int office_id = 67;
		String str_id = Integer.toString(office_id);
		
		String detailStartDate = request.getParameter( "officestart" );
		String detailEndDate = request.getParameter( "officeend" );
		String favoriteStartDate = request.getParameter( "officestart" );
		String favoriteEndDate = request.getParameter( "officeend" );
		String reviewStartDate = request.getParameter( "officestart" );
		String reviewEndDate = request.getParameter( "officeend" );
	
		Map<String, String> mapDetail = new HashMap< String, String>();
		mapDetail.put( "start", detailStartDate );
		mapDetail.put( "end", detailEndDate );
		mapDetail.put( "office_id", str_id );
		List<StatisticsDetailDTO> dtosDetail = statisticsDao.getDetailByDay( mapDetail );
		request.setAttribute( "dtosDetail", dtosDetail ); 
		// 상세 정보 노출 (office_id, start_date, end_date)
	
		Map<String, String> mapFavorite = new HashMap< String, String>();
		mapFavorite.put( "start", favoriteStartDate );
		mapFavorite.put( "end", favoriteEndDate );
		mapFavorite.put( "office_id", str_id );
		List<StatisticsFavoriteDTO> dtosFavorite = statisticsDao.getFavoriteByDay( mapFavorite );
		request.setAttribute( "dtosFavorite", dtosFavorite ); 
		// 즐겨찾기 (office_id, start_date, end_date)

		Map<String, String> mapReview = new HashMap< String, String>();
		mapReview.put( "start", reviewStartDate );
		mapReview.put( "end", reviewEndDate );
		mapReview.put( "office_id", str_id );
		List<StatisticsReviewDTO> dtosReview = statisticsDao.getReviewByDay( mapReview );
		request.setAttribute( "dtosReview", dtosReview ); 
		// 리뷰 (office_id, start_date, end_date)
		/*
		List<StatisticsAdDTO> dtosAd = statisticsDao.getAdHistory(305);
		request.setAttribute( "dtosAd", dtosAd ); 
		*/
		// 광고 등록 내역 (office_id, start_date, end_date, ad_level)
	
		return new ModelAndView("statistics/statisticsOfficeForm");
	}

}

