package review;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import mybatis.SqlMapClient;

public class ReviewDBBean implements ReviewDAO {
	private SqlSession session = SqlMapClient.getSession();
	
	public int deleteData(int review_id) {
		return session.delete("Review.deleteData", review_id);
	}
	
	public int getReviewCount() {
		return session.selectOne("Review.getReviewCount");
	}
	
	public ReviewDataBean getData(int review_id) {
		return session.selectOne("Review.getData", review_id);
	}
	
	public ReviewDataBean getOffice(int office_id) {
		return session.selectOne("Review.getOffice", office_id);
	}
	public List<ReviewDataBean> getReview(String user_id) {
		return session.selectList("Review.getReview", user_id);
	}
	
	public List<ReviewDataBean> getReviewByOffice(Map<String, Object> param, boolean hasUserId) {
		if(! hasUserId) {
			return session.selectList("Review.getReviewByOfficeNoLogin", param);
		} else {
			return session.selectList("Review.getReviewByOffice", param);
		}
	}
	public int insertReview(ReviewDataBean dto) {
		return session.insert("Review.insertReview", dto);
	}
	public int modifyData(ReviewDataBean dto) {
		return session.update("Review.modifyData", dto);
	}
	
}
