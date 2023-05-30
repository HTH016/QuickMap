package review;

import java.util.List;
import java.util.Map;
public interface ReviewDAO {
	public int deleteReview(int review_id);
	public int getReviewCount();
	public int getReviewCount(Map<String, Object> param);
	public ReviewDataBean getReview(int review_id);
	public ReviewDataBean getOfficeReview(int office_id);
	public List<ReviewDataBean> getMyReviewList(String user_id);
	public List<ReviewDataBean> getOfficeReviewList(Map<String, Object> param, boolean hasUserId);
	public int insertReview(ReviewDataBean dto);
	public int modifyReview(ReviewDataBean dto);
}
