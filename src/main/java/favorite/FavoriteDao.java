package favorite;

import java.util.List;

public interface FavoriteDao {
	public int getCount();
	public List<FavoriteDataBean> getBookmark (String user_id);
}
