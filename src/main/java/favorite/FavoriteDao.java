package favorite;

import java.util.List;
import java.util.Map;

public interface FavoriteDao {
	public int getFavoriteCount();
	public int getFavoriteCount(Map<String, Object> param);
	public List<FavoriteDataBean> getFavoriteList(String user_id);
	public int insertFavorite(Map<String, Object> param);
	public int deleteFavorite(Map<String, Object> param);
}
