package statistics;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import mybatis.SqlMapClient;

public class StatisticsDBBean implements StatisticsDAO {

	public static SqlSession session = SqlMapClient.getSession();
	
	public int countOfficeByAd() {
		return session.selectOne( "Statistics.statisticsOfficeAd" );
	}
	
	public int countOfficeByGrade( int grade ) {
		return session.selectOne( "Statistics.statisticsOfficeGrade", grade );
	}
	
	public int countUserByGrade( int grade ) {
		return session.selectOne( "Statistics.statisticsUserGrade", grade );
	}

	public List<StatisticsAdIncomeDTO> getAdIncome( Map<String, String> map ) {
		return session.selectList( "Statistics.statisticsAdIncome", map );
	}
	
	public List<StatisticsDetailDTO> getDetailByDay( Map<String, String> map ) {
		return session.selectList( "Statistics.statisticsDetail", map );
	}
	
	public List<StatisticsFavoriteDTO> getFavoriteByDay( Map<String, String> map ) {
		return session.selectList( "Statistics.statisticsFavorite", map );
	}
	
	public List<StatisticsReviewDTO> getReviewByDay( Map<String, String> map ) {
		return session.selectList( "Statistics.statisticsReview", map );
	}
	
	public List<StatisticsSearchDTO> getSearchRank( Map<String, String> map ) {
		return session.selectList( "Statistics.statisticsSearchWord", map );
	}
	
	public int insertStatisticsSearch(StatisticsSearchDTO dto) {
		return session.insert( "Statistics.insertStatisticsSearch", dto );
	}
	
	public int insertStatisticsDetail(StatisticsDetailDTO dto) {
		return session.insert( "Statistics.insertStatisticsDetail", dto );
	}
	
	/*
	
	public List<StatisticsOfficeDetailDTO> getDetailByDay(  int office_id ) {
		return session.selectList( "Statistics.statisticsDetail", office_id );
	}
	
	public List<StatisticsOfficeFavoriteDTO> getFavoriteByDay(  int office_id ) {
		return session.selectList( "Statistics.statisticsFavorite", office_id );
	}
	
	public List<StatisticsOfficeReviewDTO> getReviewByDay(  int office_id ) {
		return session.selectList( "Statistics.statisticsReview", office_id );
	}
	
	*/
}
