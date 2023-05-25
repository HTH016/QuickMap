package statistics;

import java.sql.Timestamp;

public class StatisticsAdDTO {

	private int ad_request_id;				// 신청 번호									
	private Timestamp ad_request_start;
	private Timestamp ad_request_end ;			// 사업자 등록 번호
	private int ad_request_level;		// 요청일
	public int getAd_request_id() {
		return ad_request_id;
	}
	public void setAd_request_id(int ad_request_id) {
		this.ad_request_id = ad_request_id;
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

	
	
	
}
