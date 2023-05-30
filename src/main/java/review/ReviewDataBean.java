package review;

import java.sql.Timestamp;

public class ReviewDataBean {
	private int review_id;
	private int office_id;
	private String user_id;
	private Timestamp review_reg;
	private String review_data;
	private double review_star;
	private String office_name;
	private String user_nick;
	
	public String getUser_nick() {
		return user_nick;
	}
	public void setUser_nick(String user_nick) {
		this.user_nick = user_nick;
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
	public String getReview_data() {
		return review_data;
	}
	public void setReview_data(String review_data) {
		this.review_data = review_data;
	}
	public int getReview_id() {
		return review_id;
	}
	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}
	public Timestamp getReview_reg() {
		return review_reg;
	}
	public void setReview_reg(Timestamp review_reg) {
		this.review_reg = review_reg;
	}
	public double getReview_star() {
		return review_star;
	}
	public void setReview_star(double review_star) {
		this.review_star = review_star;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
}
