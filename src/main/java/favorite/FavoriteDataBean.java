package favorite;

import java.sql.Timestamp;

public class FavoriteDataBean {
	private String user_id;				// 회원 id
	private String user_nick;			// 회원 닉네임
	private int office_id;				// 업장 id
	private String office_name;			// 업장명
	private String office_address;		// 업장 주소
	private int office_star;			// 별점 평균
	private int office_review_num;			// 리뷰 수
	private Timestamp favorite_reg;		// 즐겨찾기 등록일
	private int favorite_id;			// 즐겨찾기 번호
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
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
	public String getOffice_address() {
		return office_address;
	}
	public void setOffice_address(String office_address) {
		this.office_address = office_address;
	}
	public int getOffice_star() {
		return office_star;
	}
	public void setOffice_star(int office_star) {
		this.office_star = office_star;
	}
	public int getOffice_review_num() {
		return office_review_num;
	}
	public void setOffice_review_num(int office_review_num) {
		this.office_review_num = office_review_num;
	}
	public Timestamp getFavorite_reg() {
		return favorite_reg;
	}
	public void setFavorite_reg(Timestamp favorite_reg) {
		this.favorite_reg = favorite_reg;
	}
	public int getFavorite_id() {
		return favorite_id;
	}
	public void setFavorite_id(int favorite_id) {
		this.favorite_id = favorite_id;
	}
	
}