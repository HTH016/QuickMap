package favorite;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import mybatis.SqlMapClient;

public class FavoriteDBBean implements FavoriteDao {
	private SqlSession session = SqlMapClient.getSession();
	
	// favorite list
	//  : user_id가 등록한 favorite 목록 
	//  : qm_office, qm_favorite 테이블 두개 조인해서 입력받은 user_id가 북마크한 정보
	public List<FavoriteDataBean> getFavoriteList(String user_id) {
		return session.selectList("Favorite.getFavoriteList", user_id);
	}
	
	// favorite 수 : 전체
	public int getFavoriteCount() {					
		return session.selectOne("Favorite.getFavoriteCount");
	}
	
	// favorite 수 : userId, officeId 가 일치하는 항목
	public int getFavoriteCount(Map<String, Object> param) {
		return session.selectOne("Favorite.getFavoriteCountByParam", param);
	}
	
	// favorite 등록 : parameter - userId, officeId
	public int insertFavorite(Map<String, Object> param) {
		return session.selectOne("Favorite.insertFavorite", param);
	}
	
	// favorite 삭제 : parameter - userId, officeId
	public int deleteFavorite(Map<String, Object> param) {
		return session.selectOne("Favorite.deleteFavorite", param);
	}
}
