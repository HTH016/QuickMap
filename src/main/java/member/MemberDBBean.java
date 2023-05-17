package member;

import org.apache.ibatis.session.SqlSession;

import mybatis.SqlMapClient;

public class MemberDBBean implements MemberDao {
	
	public static SqlSession session = SqlMapClient.getSession();
	
	public int checkId(String user_id) {
		return session.insert("Member.checkId", user_id);
	}
	
	public int checkNick(String user_nick) {
		return session.insert("Member.checkNick", user_nick);
	}
	
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
	
	public int insertMember(MemberDataBean dto) {
		return session.insert("Member.insertMember", dto);
	}
	
	public MemberDataBean getMember(String user_id) {
		return session.selectOne("Member.getMember", user_id);
	}
	
	public int deleteMember(String user_id) {
		return session.delete("Member.deleteMember", user_id);
	}
	
	
	
	
	
	
	
	
}
