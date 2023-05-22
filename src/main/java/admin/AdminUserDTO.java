package admin;

import java.sql.Timestamp;

public class AdminUserDTO {
	
	
	private String user_id;						// 회원 아이디
	private int grade_id;					// 업장 아이디
	private String user_nick ;			// 사업자 등록 번호
	private String user_name;			// 사업자 등록 사진
	private String user_passwd;		// 요청일
	private Timestamp user_reg;		// 승인일
	private String user_tel;
	private String user_email;
	private String grade_name;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getGrade_id() {
		return grade_id;
	}
	public void setGrade_id(int grade_id) {
		this.grade_id = grade_id;
	}
	public String getUser_nick() {
		return user_nick;
	}
	public void setUser_nick(String user_nick) {
		this.user_nick = user_nick;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_passwd() {
		return user_passwd;
	}
	public void setUser_passwd(String user_passwd) {
		this.user_passwd = user_passwd;
	}
	public Timestamp getUser_reg() {
		return user_reg;
	}
	public void setUser_reg(Timestamp user_reg) {
		this.user_reg = user_reg;
	}
	public String getUser_tel() {
		return user_tel;
	}
	public void setUser_tel(String user_tel) {
		this.user_tel = user_tel;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getGrade_name() {
		return grade_name;
	}
	public void setGrade_name(String grade_name) {
		this.grade_name = grade_name;
	}
	
	
	
	
		
}
