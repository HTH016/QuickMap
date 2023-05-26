package map;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import mybatis.SqlMapClient;

public class MapOfficeDetailDAO implements MapDao {
	
	public static SqlSession session = SqlMapClient.getSession();
	
	public List<MapOfficeDetailDTO> searchOfficeList(Map<String, Object> param, boolean searchAd) {
		if(searchAd == true) {
			return session.selectList("Map.searchOfficeListAd", param);
		} else {
			return session.selectList("Map.searchOfficeListNormal", param);
		}
	}
	
	public List<String> searchServiceIdList(String[] searchWord) {
		return session.selectList("Map.searchServiceIdList", searchWord);
	}
	
	public MapOfficeDetailDTO getOfficeInfoByOfficeId(int officeId) {
		return session.selectOne("Map.getOfficeInfoByOfficeId", officeId);
	}
	
}
