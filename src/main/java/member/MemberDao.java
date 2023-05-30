package member;

public interface MemberDao {
	public int check(String user_id, String user_passwd);
	public int checkId(String user_id);
	public int checkNick(String user_nick);
	public int deleteMember(String user_id);
	public MemberDataBean getMember(String user_id);
	public String getMemberNick(String user_id);
	public int insertMember(MemberDataBean dto);
	public int modifyMember(MemberDataBean dto);
}
