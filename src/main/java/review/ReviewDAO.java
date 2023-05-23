package review;

import java.util.List;
public interface ReviewDao {
	public int deleteData(int review_id);
	public int getCount();
	public ReviewDataBean getData(int review_id);
	public List<ReviewDataBean> getReview(String user_id);
	public int modifyData(ReviewDataBean dto);
}
