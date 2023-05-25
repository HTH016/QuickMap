package office;

import org.apache.ibatis.session.SqlSession;

import mybatis.SqlMapClient;

public class OfficeDBBean implements OfficeDAO {
	public static SqlSession session = SqlMapClient.getSession();
	
	public OfficeDataBean getOffice(String user_id) {
		return session.selectOne("Office.getOffice", user_id);
	}
	
	public OfficeAdRequestDataBean getOfficeAd(String user_id) {
		return session.selectOne("Office.getOfficeAd", user_id);
	}
	public OfficeRegisterDataBean getOfficeById(int office_id) {
		return session.selectOne("Office.getOfficeById", office_id);
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
}
