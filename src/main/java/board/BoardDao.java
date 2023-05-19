package board;

import java.util.List;

public interface BoardDao {
	public int getCount();
	public List<BoardDataBean> getBookmark (String user_id);
}
