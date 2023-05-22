package map;

import java.util.List;
import java.util.Map;

public interface MapDao {
	public List<MapOfficeDetailDTO> searchOfficeList(Map<String, Object> param, boolean searchAd);
	public List<String> searchServiceIdList(String[] searchWord);
}
