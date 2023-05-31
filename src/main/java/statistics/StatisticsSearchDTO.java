package statistics;

import java.sql.Timestamp;

public class StatisticsSearchDTO {

	private int			search_id;		// 검색 통계 ID
	private String		user_id;		// 회원 ID
	private String		search_word;	// 검색어
	private int			search_class;	// 분류
	private	Timestamp	search_date;	// 검색시각
	private int			rank;			// 순위
	private int			count;			// 검색 회수
	
	public int getSearch_id() {
		return search_id;
	}
	public void setSearch_id(int search_id) {
		this.search_id = search_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getSearch_word() {
		return search_word;
	}
	public void setSearch_word(String search_word) {
		this.search_word = search_word;
	}
	public int getSearch_class() {
		return search_class;
	}
	public void setSearch_class(int search_class) {
		this.search_class = search_class;
	}
	public Timestamp getSearch_date() {
		return search_date;
	}
	public void setSearch_date(Timestamp search_date) {
		this.search_date = search_date;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
