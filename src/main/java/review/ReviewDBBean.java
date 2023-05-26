package review;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.SqlMapClient;

public class ReviewDBBean implements ReviewDAO {
	private SqlSession session = SqlMapClient.getSession();
	
	public int deleteData(int review_id) {
		return session.delete("Review.deleteData", review_id);
	}
	
	public int getReviewCount() {
		return session.selectOne("Review.getCount");
	}
	
	public ReviewDataBean getData(int review_id) {
		return session.selectOne("Review.getData", review_id);
	}
	
	public List<ReviewDataBean> getReview(String user_id) {
		return session.selectList("Review.getReview", user_id);
	}
	
	public int modifyData(ReviewDataBean dto) {
		return session.update("Review.modifyData", dto);
	}
	
}
