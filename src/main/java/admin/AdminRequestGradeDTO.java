package admin;

import java.sql.Timestamp;

public class AdminRequestGradeDTO {

	private int grade_request_id;				
	private int office_id;					
	private String office_name;
	private String office_grade_id ;		
	private Timestamp grade_request_submit;		
	private Timestamp grade_request_confirm;		
	public int getGrade_request_id() {
		return grade_request_id;
	}
	public void setGrade_request_id(int grade_request_id) {
		this.grade_request_id = grade_request_id;
	}
	public int getOffice_id() {
		return office_id;
	}
	public void setOffice_id(int office_id) {
		this.office_id = office_id;
	}
	public String getOffice_name() {
		return office_name;
	}
	public void setOffice_name(String office_name) {
		this.office_name = office_name;
	}
	public String getOffice_grade_id() {
		return office_grade_id;
	}
	public void setOffice_grade_id(String office_grade_id) {
		this.office_grade_id = office_grade_id;
	}
	public Timestamp getGrade_request_submit() {
		return grade_request_submit;
	}
	public void setGrade_request_submit(Timestamp grade_request_submit) {
		this.grade_request_submit = grade_request_submit;
	}
	public Timestamp getGrade_request_confirm() {
		return grade_request_confirm;
	}
	public void setGrade_request_confirm(Timestamp grade_request_confirm) {
		this.grade_request_confirm = grade_request_confirm;
	}
	
	
	

}
