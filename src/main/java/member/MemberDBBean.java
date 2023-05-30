package member;

import org.apache.ibatis.session.SqlSession;

import mybatis.SqlMapClient;

public class MemberDBBean implements MemberDao {
	
	public static SqlSession session = SqlMapClient.getSession();
	
	public int check(String user_id, String user_passwd) {
		int result = 0;
		if(checkId(user_id) != 0) {
			// id O pw O : 1, id O pw X : 0, id X pw X : -1
			MemberDataBean dto = getMember(user_id);
			if(user_passwd.equals(dto.getUser_passwd())) {
				result = 1;
			} else {
				result = 0;
			}
		} else {
			result = -1;
		}
		return result;
	}
	
	public int checkId(String user_id) {
		return session.selectOne("User.checkId", user_id);
	}
	
	public int checkNick(String user_nick) {
		return session.selectOne("User.checkNick", user_nick);
	}
	
	public int deleteMember(String user_id) {
		return session.delete("User.deleteMember", user_id);
	}
	
	public MemberDataBean getMember(String user_id) {
		return session.selectOne("User.getMember", user_id);
	}
	
	public String getMemberNick(String user_id) {
		return session.selectOne("User.getMemberNick", user_id);
	}
	
	public int insertMember(MemberDataBean dto) {
		return session.insert("User.insertMember", dto);
	}
	
	public int modifyMember(MemberDataBean dto) {
		return session.update("User.modifyMember", dto);
	}
	
	
}
