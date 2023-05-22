package admin;

import java.sql.Timestamp;

public class AdminRequestAdDTO {

	private int ad_request_id;				// 신청 번호									// 회원 아이디
	private int office_id;					// 업장 아이디
	private Timestamp ad_request_start;
	private Timestamp ad_request_end ;			// 사업자 등록 번호
	private int ad_request_level;		// 요청일
	private Timestamp ad_request_submit;
	private Timestamp ad_request_confirm;
	private String office_name;
	public int getAd_request_id() {
		return ad_request_id;
	}
	public void setAd_request_id(int ad_request_id) {
		this.ad_request_id = ad_request_id;
	}
	public int getOffice_id() {
		return office_id;
	}
	public void setOffice_id(int office_id) {
		this.office_id = office_id;
	}
	public Timestamp getAd_request_start() {
		return ad_request_start;
	}
	public void setAd_request_start(Timestamp ad_request_start) {
		this.ad_request_start = ad_request_start;
	}
	public Timestamp getAd_request_end() {
		return ad_request_end;
	}
	public void setAd_request_end(Timestamp ad_request_end) {
		this.ad_request_end = ad_request_end;
	}
	public int getAd_request_level() {
		return ad_request_level;
	}
	public void setAd_request_level(int ad_request_level) {
		this.ad_request_level = ad_request_level;
	}
	public Timestamp getAd_request_submit() {
		return ad_request_submit;
	}
	public void setAd_request_submit(Timestamp ad_request_submit) {
		this.ad_request_submit = ad_request_submit;
	}
	public Timestamp getAd_request_confirm() {
		return ad_request_confirm;
	}
	public void setAd_request_confirm(Timestamp ad_request_confirm) {
		this.ad_request_confirm = ad_request_confirm;
	}
	public String getOffice_name() {
		return office_name;
	}
	public void setOffice_name(String office_name) {
		this.office_name = office_name;
	}
	
	
}
