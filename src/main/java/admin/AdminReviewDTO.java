package admin;

import java.sql.Timestamp;

public class AdminReviewDTO {

	private int review_id;						// 회원 아이디
	private String user_id;					// 업장 아이디
	private int office_id ;			// 사업자 등록 번호
	private String review_data;			// 사업자 등록 사진
	private Double review_star;		// 요청일
	private Timestamp review_reg;
	private String user_nick;
	private String review_shorten;			// 승인일
	private String office_name;
	
	
	public String getOffice_name() {
		return office_name;
	}
	public void setOffice_name(String office_name) {
		this.office_name = office_name;
	}
	public String getReview_shorten() {
		return review_shorten;
	}
	public void setReviewShorten(String review_data) {
		review_shorten = review_data.substring(0, 9) + "......";
	}
	public int getReview_id() {
		return review_id;
	}
	public void setReview_id(int review_id) {
		this.review_id = review_id;
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
	public String getReview_data() {
		return review_data;
	}
	public void setReview_data(String review_data) {
		this.review_data = review_data;
	}
	public Double getReview_star() {
		return review_star;
	}
	public void setReview_star(Double review_star) {
		this.review_star = review_star;
	}
	public Timestamp getReview_reg() {
		return review_reg;
	}
	public void setReview_reg(Timestamp review_reg) {
		this.review_reg = review_reg;
	}
	public String getUser_nick() {
		return user_nick;
	}
	public void setUser_nick(String user_nick) {
		this.user_nick = user_nick;
	}
	
		
}
