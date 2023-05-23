package office;

import org.apache.ibatis.session.SqlSession;

import mybatis.SqlMapClient;

public class OfficeDBBean implements OfficeDao {
	public static SqlSession session = SqlMapClient.getSession();
	
	public OfficeDataBean getOffice(String user_id) {
		return session.selectOne("Office.getOffice", user_id);
	}
	
	public int modifyOffice(OfficeDataBean dto) {
		return session.update("Office.modifyOffice", dto);
	}
}
