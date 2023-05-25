package office;

import java.sql.Timestamp;

public class OfficeRegisterDataBean {
	private int regist_request_id;				// 등록신청 id
	private String user_id;						// 사용자 id
	private String office_regist_num;			// 사업자등록번호
	private String office_regist_num_img; 		// 사업자등록증 경로 (이거 필요한가?
	private String office_name;					// 업장명
	private int office_id;						// 업장 id
	private String office_address;				// 주소
	private Timestamp office_regist_submit;		// 신청일
	private Timestamp office_regist_confirm;	// 승인일
	
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
	public String getOffice_name() {
		return office_name;
	}
	public void setOffice_name(String office_name) {
		this.office_name = office_name;
	}
	public int getOffice_id() {
		return office_id;
	}
	public void setOffice_id(int office_id) {
		this.office_id = office_id;
	}
	public String getOffice_address() {
		return office_address;
	}
	public void setOffice_address(String office_address) {
		this.office_address = office_address;
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
	
}
