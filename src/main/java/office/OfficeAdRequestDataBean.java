package office;

import java.sql.Timestamp;

public class OfficeAdRequestDataBean {
	private int request_id;						// 광고요청id
	private String user_id;						// 사용자id
	private int office_id;						// 업장id
	private Timestamp ad_request_start;			// 광고시작일
	private Timestamp ad_request_end;			// 광고종료일
	private int ad_request_level;				// 광고 레벨(높을수록 돈많이)
	private Timestamp ad_request_submit;		// 요청일
	private Timestamp ad_request_confirm;		// 요청일
	
	public int getRequest_id() {
		return request_id;
	}
	public void setRequest_id(int request_id) {
		this.request_id = request_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
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
	
	
}
