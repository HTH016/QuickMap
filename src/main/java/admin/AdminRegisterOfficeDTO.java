package admin;

import java.sql.Timestamp;

public class AdminRegisterOfficeDTO {

	private int regist_request_id;							
	private String user_id;							
	private String office_id;						
	private String office_regist_num ;				
	private String office_regist_num_img;			
	private Timestamp office_regist_submit;			
	private Timestamp office_regist_confirm;		
	private int grade_id;							
	private String office_name;						
	public int getRegist_request_id() {
		return regist_request_id;
	}
	public void setRegist_request_id(int regist_request_id) {
		this.regist_request_id = regist_request_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getOffice_id() {
		return office_id;
	}
	public void setOffice_id(String office_id) {
		this.office_id = office_id;
	}
	public String getOffice_regist_num() {
		return office_regist_num;
	}
	public void setOffice_regist_num(String office_regist_num) {
		this.office_regist_num = office_regist_num;
	}
	public String getOffice_regist_num_img() {
		return office_regist_num_img;
	}
	public void setOffice_regist_num_img(String office_regist_num_img) {
		this.office_regist_num_img = office_regist_num_img;
	}
	public Timestamp getOffice_regist_submit() {
		return office_regist_submit;
	}
	public void setOffice_regist_submit(Timestamp office_regist_submit) {
		this.office_regist_submit = office_regist_submit;
	}
	public Timestamp getOffice_regist_confirm() {
		return office_regist_confirm;
	}
	public void setOffice_regist_confirm(Timestamp office_regist_confirm) {
		this.office_regist_confirm = office_regist_confirm;
	}
	public int getGrade_id() {
		return grade_id;
	}
	public void setGrade_id(int grade_id) {
		this.grade_id = grade_id;
	}
	public String getOffice_name() {
		return office_name;
	}
	public void setOffice_name(String office_name) {
		this.office_name = office_name;
	}
	
	
	

}
