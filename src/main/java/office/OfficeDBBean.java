package office;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import mybatis.SqlMapClient;

public class OfficeDBBean implements OfficeDAO {
	public static SqlSession session = SqlMapClient.getSession();
	
	public OfficeDataBean getOfficeInfo(String user_id) {
		return session.selectOne("Office.getOfficeInfoByUserId", user_id);
	}
	
	public OfficeDataBean getOfficeInfo(int office_id) {
		return session.selectOne("Office.getOfficeInfoByOfficeId", office_id);
	}
	
	public OfficeRegisterDataBean getOfficeReg(int office_id) {
		return session.selectOne("Office.getOfficeReg", office_id);
	}
	
	public OfficeAdRequestDataBean getOfficeAd(String user_id) {
		return session.selectOne("Office.getOfficeAd", user_id);
	}
	
	public String getOfficeName(int office_id) {
		return session.selectOne("Office.getOfficeName", office_id);
	}
	
	public int gradeRequest(OfficeDataBean dto) {
		return session.insert("Office.gradeRequest", dto);
	}
	
	public int modifyOffice(OfficeDataBean dto) {
		return session.update("Office.modifyOffice", dto);
	}
	
	public int registerOffice(OfficeRegisterDataBean dto) {
		return session.insert("Office.registerOffice", dto);
	}
	
	public int requestAd(OfficeAdRequestDataBean dto) {
		return session.insert("Office.requestAd", dto);
	}
	
	public int updateReviewInfo(Map<String, Object> param) {
		return session.update("Office.updateReviewInfo", param);
	}
}
