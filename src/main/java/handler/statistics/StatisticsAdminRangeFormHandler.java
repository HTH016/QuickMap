package handler.statistics;

import java.text.DecimalFormat;
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
import statistics.StatisticsAdIncomeDTO;
import statistics.StatisticsSearchDTO;
import statistics.StatisticsDAO;
import statistics.StatisticsDetailDTO;
import statistics.StatisticsFavoriteDTO;
import statistics.StatisticsReviewDTO;

@Controller
public class StatisticsAdminRangeFormHandler implements CommandHandler {
	
	@Resource(name="statisticsDao")
	private StatisticsDAO statisticsDao;
	
	@RequestMapping("/statisticsadminrangeform")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int AD_LEVEL_MONEY[] = {1, 2, 4, 8, 16, 32, 64};
		int adIncome = 0;
		
		String startDate = request.getParameter( "rangestart" );
		String endDate = request.getParameter( "rangeend" );

		DecimalFormat decFormat = new DecimalFormat("###,###");
		
		int numGeneralUser = statisticsDao.countUserByGrade(2);			// grade=2 인 회원 수
	
		int numRegistOffice = statisticsDao.countOfficeByGrade(0);		// grade=0 인 업장 수
		int numPremiumOffice = statisticsDao.countOfficeByGrade(1);		// grade=1 인 업장 수 
	
		int numAdOffice = statisticsDao.countOfficeByAd();				// ad=1 인 업장 수
		
		request.setAttribute( "numGeneralUser", numGeneralUser ); 
		request.setAttribute( "numRegistOffice", numRegistOffice ); 
		request.setAttribute( "numPremiumOffice", numPremiumOffice ); 
		request.setAttribute( "numAdOffice", numAdOffice ); 	
		
		Map<String, String> mapAd = new HashMap< String, String>();
		mapAd.put( "end", endDate );
		mapAd.put( "start", startDate );
		List<StatisticsAdIncomeDTO> dtosAd = statisticsDao.getAdIncome( mapAd );
		
		for ( int i = 0 ; i < 5 ; i++) {
			adIncome += AD_LEVEL_MONEY[i] * dtosAd.get(i).getS();
		}
	
		String strAdIncome = decFormat.format(adIncome);
		
		
		request.setAttribute( "dtosAd", dtosAd ); 
		request.setAttribute( "strAdIncome", strAdIncome ); 
		
		
		Map<String, String> map = new HashMap< String, String>();
		map.put( "start", startDate );
		map.put( "end", endDate );
		List<StatisticsSearchDTO> dtosSearch = statisticsDao.getSearchRank( map );
		request.setAttribute( "dtosSearch", dtosSearch ); 
		
		 //group by search_word, order by desc
	
	
		Map<String, String> mapDetail = new HashMap< String, String>();
		mapDetail.put( "start", startDate );
		mapDetail.put( "end", endDate );
		//mapDetail.put( "office_id", str_id );
		List<StatisticsDetailDTO> dtosDetail = statisticsDao.getDetailByDay( mapDetail );
		request.setAttribute( "dtosDetail", dtosDetail ); 
		// 상세 정보 노출 (office_id, start_date, end_date)
	
		Map<String, String> mapFavorite = new HashMap< String, String>();
		mapFavorite.put( "start", startDate );
		mapFavorite.put( "end", endDate );
		//mapFavorite.put( "office_id", str_id );
		List<StatisticsFavoriteDTO> dtosFavorite = statisticsDao.getFavoriteByDay( mapFavorite );
		request.setAttribute( "dtosFavorite", dtosFavorite ); 
		// 즐겨찾기 (office_id, start_date, end_date)
	
		Map<String, String> mapReview = new HashMap< String, String>();
		mapReview.put( "start", startDate );
		mapReview.put( "end", endDate );
		//mapReview.put( "office_id", str_id );
		List<StatisticsReviewDTO> dtosReview = statisticsDao.getReviewByDay( mapReview );
		request.setAttribute( "dtosReview", dtosReview ); 
		// 리뷰 (office_id, start_date, end_date)
	
		/*
		List<StatisticsAdDTO> dtosAd = statisticsDao.getAdHistory(305);
		request.setAttribute( "dtosAd", dtosAd ); */
		// 광고 등록 내역 (office_id, start_date, end_date, ad_level)
		
		return new ModelAndView("statistics/statisticsAdminForm");
	}

}
