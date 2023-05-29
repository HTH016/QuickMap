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
import statistics.StatisticsAdminSearchWordDTO;
import statistics.StatisticsDAO;

@Controller
public class StatisticsAdminSearchFormHandler implements CommandHandler {
	
	@Resource(name="statisticsDao")
	private StatisticsDAO statisticsDao;
	
	@RequestMapping("/statisticsadminsearchform")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Exception {

	int AD_LEVEL[] = {1, 10, 100, 1000, 10000};
	int adIncome = 0;
	
	
	String adSearchStartDate = "2023-01-01";
	String adSearchEndDate = "2023-12-31";
	String searchWordStartDate = request.getParameter( "searchstart" );
	String searchWordEndDate = request.getParameter( "searchend" );
	
	DecimalFormat decFormat = new DecimalFormat("###,###");
	
	/*
	  if( count > 0 ) {
			Map<String, Integer> map = new HashMap<String, Integer>();
			map.put( "start", start );
			map.put( "end", end );
			List<BoardDataBean> dtos = boardDao.getArticles( map );
			request.setAttribute( "dtos", dtos ); 
		}	 
	 */
	
	int numGeneralUser = statisticsDao.countUserByGrade(2);
	// grade=2 인 회원 수
	int numRegistUser = statisticsDao.countUserByGrade(3);
	// grade=3 인 회원 수
	int numRegistOffice = statisticsDao.countOfficeByGrade(0);
	// grade=0 인 업장 수
	int numPremiumOffice = statisticsDao.countOfficeByGrade(1);
	// grade=1 인 업장 수 
	int numAdOffice = statisticsDao.countOfficeByAd(1);
	// ad=1 인 업장 수 
	
	request.setAttribute( "numGeneralUser", numGeneralUser ); 
	request.setAttribute( "numRegistUser", numRegistUser ); 
	request.setAttribute( "numRegistOffice", numRegistOffice ); 
	request.setAttribute( "numPremiumOffice", numPremiumOffice ); 
	request.setAttribute( "numAdOffice", numAdOffice ); 	
	
	Map<String, String> mapAd = new HashMap< String, String>();
	mapAd.put( "end", adSearchEndDate );
	mapAd.put( "start", adSearchStartDate );
	List<StatisticsAdIncomeDTO> dtosAd = statisticsDao.getAdIncome( mapAd );
	
	for ( int i = 0 ; i < 5 ; i++) {
		adIncome += AD_LEVEL[i] * dtosAd.get(i).getS();
	}

	String strAdIncome = decFormat.format(adIncome);
	
	
	request.setAttribute( "dtosAd", dtosAd ); 
	request.setAttribute( "strAdIncome", strAdIncome ); 
	
	
	Map<String, String> map = new HashMap< String, String>();
	map.put( "start", searchWordStartDate );
	map.put( "end", searchWordEndDate );
	List<StatisticsAdminSearchWordDTO> dtosSearch = statisticsDao.getSearchRank( map );
	request.setAttribute( "dtosSearch", dtosSearch ); 
	
	 //group by search_word, order by desc
	
	

	
	
	return new ModelAndView("statistics/statisticsAdminForm");
}

}
