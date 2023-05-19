package board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.SqlMapClient;

public class BoardDBBean implements BoardDao {
	
	private SqlSession session = SqlMapClient.getSession();
	
	public int getCount() {					// 해당 id가 즐겨찾기 설정한 업장이 있는지 확인
		return session.selectOne("Board.getCount");
	}
	
	public List<BoardDataBean> getBookmark (String user_id) {			// 해당 id가 북마크(즐겨찾기)한 (qm_office, qm_favorite 테이블 두개 조인해서 입력받은 user_id가 북마크한 정보 뽑아오기 - 평점순 정렬)
		return session.selectList("Board.getBookmark", user_id);
	}
	
	
}
