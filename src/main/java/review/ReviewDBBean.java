package review;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import mybatis.SqlMapClient;

public class ReviewDBBean implements ReviewDAO {
	private SqlSession session = SqlMapClient.getSession();
	
	public int deleteReview(int review_id) {
		return session.delete("Review.deleteReview", review_id);
	}
	
	public int getReviewCount() {
		return session.selectOne("Review.getReviewCountAll");
	}
	
	// map : userId, officeId
	public int getReviewCount(Map<String, Object> param) {
		return session.selectOne("Review.getReviewCountById", param);
	}
	
	public ReviewDataBean getReview(int review_id) {
		return session.selectOne("Review.getReview", review_id);
	}
	
	public ReviewDataBean getOfficeReview(int office_id) {
		return session.selectOne("Review.getOfficeReview", office_id);
	}
	// 내가 쓴 리뷰 확인 (user_id당 리뷰 리스트)
	public List<ReviewDataBean> getMyReviewList(String user_id) {
		return session.selectList("Review.getMyReviewList", user_id);
	}
	
	// 특정 업장 리뷰 확인 (office_id당 리뷰 리스트)
	// user_id O / user_id X
	public List<ReviewDataBean> getOfficeReviewList(Map<String, Object> param, boolean hasUserId) {
		if(hasUserId) {
			return session.selectList("Review.getOfficeReviewList", param);
		} else {
			return session.selectList("Review.getOfficeReviewListNoLogin", param);
		}
	}
	
	public int insertReview(ReviewDataBean dto) {
		return session.insert("Review.insertReview", dto);
	}
	
	public int modifyReview(ReviewDataBean dto) {
		return session.update("Review.modifyReview", dto);
	}
	
}
