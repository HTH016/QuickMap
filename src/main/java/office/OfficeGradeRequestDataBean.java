package office;

import java.sql.Timestamp;

public class OfficeGradeRequestDataBean {
	private int grade_request_id;
	private int office_id;
	private int grade_id;
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
	public int getGrade_id() {
		return grade_id;
	}
	public void setGrade_id(int grade_id) {
		this.grade_id = grade_id;
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
