package review;

import java.util.List;
public interface ReviewDAO {
	public int deleteData(int review_id);
	public int getReviewCount();
	public ReviewDataBean getData(int review_id);
	public List<ReviewDataBean> getReview(String user_id);
	public int modifyData(ReviewDataBean dto);
}
