package statistics;

import java.util.List;
import java.util.Map;

public interface StatisticsDAO {

	public int countOfficeByAd( int ad );
	public int countOfficeByGrade( int grade );
	public int countUserByGrade( int grade );
	//public List<StatisticsAdDTO> getAdHistory( int office_id );
	public List<StatisticsAdIncomeDTO> getAdIncome( Map<String, String> map );
	public List<StatisticsDetailDTO> getDetailByDay( Map<String, String> map );
	public List<StatisticsFavoriteDTO> getFavoriteByDay( Map<String, String> map );
	public List<StatisticsReviewDTO> getReviewByDay( Map<String, String> map );
	public List<StatisticsSearchDTO> getSearchRank( Map<String, String> map );
	
	public int insertSearch(StatisticsSearchDTO dto);
	
}
