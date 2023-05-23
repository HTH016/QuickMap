package favorite;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.SqlMapClient;

public class FavoriteDBBean implements FavoriteDao {
	private SqlSession session = SqlMapClient.getSession();
	
	public List<FavoriteDataBean> getBookmark (String user_id) {			// 해당 id가 북마크(즐겨찾기)한 (qm_office, qm_favorite 테이블 두개 조인해서 입력받은 user_id가 북마크한 정보 뽑아오기)
		return session.selectList("Favorite.getBookmark", user_id);
	}
	
	public int getCount() {					
		return session.selectOne("Favorite.getCount");
	}
	
	
}
