package review;

import java.util.List;
import java.util.Map;
public interface ReviewDAO {
	public int deleteData(int review_id);
	public int getReviewCount();
	public int getReviewCount(Map<String, Object> param);
	public ReviewDataBean getData(int review_id);
	public ReviewDataBean getOffice(int office_id);
	public List<ReviewDataBean> getReview(String user_id);
	public List<ReviewDataBean> getReviewByOffice(Map<String, Object> param, boolean hasUserId);
	public int insertReview(ReviewDataBean dto);
	public int modifyData(ReviewDataBean dto);
}
