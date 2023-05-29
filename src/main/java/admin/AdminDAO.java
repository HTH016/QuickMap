package admin;

import java.util.List;

public interface AdminDAO {

	public int adminDeleteReview( int review_id );
	public AdminReviewDTO adminReview( int review_id );
	public int changeUserGrade( String user_id, int selectGrade );
	public AdminRegisterOfficeDTO confirmRegistOffice( int regist_request_id );
	public int getRegistOfficeCount();
	public List<AdminRegisterOfficeDTO> getRegistOfficeList( int count );
	public int getRequestAdCount();
	public List<AdminRequestAdDTO> getRequestAdList(  int count  );
	public int getRequestGradeCount();
	public List<AdminRequestGradeDTO> getRequestGradeList(  int count  );
	public int getReviewCount( String user_id );
	public List<AdminReviewDTO> getReviewList( String user_id );
	public int getUserCount();
	public AdminUserDTO getUserInfo( String user_id );
	public List<AdminUserDTO> getUserList();
	public List<AdminUserDTO> getUserListByOptionSort( int userSort );
	public List<AdminUserDTO> getUserListByOptionSelect( int userSelect, String search_word );
	public int registAd( int checkedId );
	public int registUserInOffice( int regist_request_id );
	public int updateOfficeGrade( int checkedId );
	
	
	
	
}
