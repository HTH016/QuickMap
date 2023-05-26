package handler.statistics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import handler.CommandHandler;
import statistics.StatisticsAdDTO;
import statistics.StatisticsAdminSearchWordDTO;
import statistics.StatisticsDAO;
import statistics.StatisticsDetailDTO;
import statistics.StatisticsFavoriteDTO;
//import statistics.StatisticsOfficeDetailDTO;
//import statistics.StatisticsOfficeFavoriteDTO;
//import statistics.StatisticsOfficeReviewDTO;
import statistics.StatisticsReviewDTO;

@Controller
public class StatisticsOfficeFormHandler implements CommandHandler {
	@RequestMapping("/statisticsofficeform")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Exception {

		StatisticsDAO statisticsDAO = new StatisticsDAO();
		//int office_id = Integer.parseInt(request.getParameter("office_id"));
		int office_id = 67;
		String str_id = Integer.toString(office_id);
		
		String detailStartDate = "2023-01-01";
		String detailEndDate = "2023-01-15";
		String favoriteStartDate = "2023-01-01";
		String favoriteEndDate = "2023-01-15";
		String reviewStartDate = "2023-01-01";
		String reviewEndDate = "2023-01-15";
	
	



	
		Map<String, String> mapDetail = new HashMap< String, String>();
		mapDetail.put( "start", detailStartDate );
		mapDetail.put( "end", detailEndDate );
		mapDetail.put( "office_id", str_id );
		List<StatisticsDetailDTO> dtosDetail = statisticsDAO.getDetailByDay( mapDetail );
		request.setAttribute( "dtosDetail", dtosDetail ); 
	// 상세 정보 노출 (office_id, start_date, end_date)
	
		Map<String, String> mapFavorite = new HashMap< String, String>();
		mapFavorite.put( "start", favoriteStartDate );
		mapFavorite.put( "end", favoriteEndDate );
		mapFavorite.put( "office_id", str_id );
		List<StatisticsFavoriteDTO> dtosFavorite = statisticsDAO.getFavoriteByDay( mapFavorite );
		request.setAttribute( "dtosFavorite", dtosFavorite ); 
	// 즐겨찾기 (office_id, start_date, end_date)

		Map<String, String> mapReview = new HashMap< String, String>();
		mapReview.put( "start", reviewStartDate );
		mapReview.put( "end", reviewEndDate );
		mapReview.put( "office_id", str_id );
		List<StatisticsReviewDTO> dtosReview = statisticsDAO.getReviewByDay( mapReview );
		request.setAttribute( "dtosReview", dtosReview ); 
	// 리뷰 (office_id, start_date, end_date)
	
		List<StatisticsAdDTO> dtosAd = statisticsDAO.getAdHistory(305);
		request.setAttribute( "dtosAd", dtosAd ); 
	// 광고 등록 내역 (office_id, start_date, end_date, ad_level)
	
	return new ModelAndView("statistics/statisticsOfficeForm");
}

}

