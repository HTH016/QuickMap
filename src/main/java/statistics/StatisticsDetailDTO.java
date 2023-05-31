package statistics;

public class StatisticsDetailDTO {
	
	private int		detail_id;
	private String	user_id;
	private int		office_id;
	private String	detail_date;
	private int		count;
	
	public int getDetail_id() {
		return detail_id;
	}
	public void setDetail_id(int detail_id) {
		this.detail_id = detail_id;
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
	public String getDetail_date() {
		return detail_date;
	}
	public void setDetail_date(String detail_date) {
		this.detail_date = detail_date;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
