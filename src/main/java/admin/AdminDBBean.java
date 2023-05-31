package admin;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.SqlMapClient;

public class AdminDBBean implements AdminDAO{

	public static SqlSession session = SqlMapClient.getSession();
	
	public int adminDeleteReview( int review_id ) {
		return session.delete( "Admin.adminDeleteReview", review_id );
	}
	
	public AdminReviewDTO adminReview( int review_id ) {
		return session.selectOne( "Admin.adminReview", review_id );
	}
	
	public int changeUserGrade( String user_id, int selectGrade ) {
		
		if ( selectGrade == 0) {	
			// 계정 삭제
			return session.update( "Admin.deleteUser", user_id );
		} else if ( selectGrade == 1 ) {
			// 활동 정지
			return session.update( "Admin.freezeUser", user_id );
		} else if ( selectGrade == 2) {
			// 일반
			return session.update( "Admin.normalUser", user_id );			
		} else if ( selectGrade == 3) {
			// 등록
			return session.update( "Admin.officeUser", user_id );	
		} else {
			return 1;
		} 
	}
	
	public AdminRegisterOfficeDTO confirmRegistOffice( int regist_request_id ) {
		return session.selectOne( "Admin.confirmRegistOffice", regist_request_id );
	}
	
	public int getRegistOfficeCount() {
		return session.selectOne( "Admin.getRegistOfficeCount" );
	}
	
	public List<AdminRegisterOfficeDTO> getRegistOfficeList( int count ) {
		return session.selectList( "Admin.getRegistOfficeList", count );
	}
	
	public int getRequestAdCount() {
		return session.selectOne( "Admin.getRequestAdCount");
	}
	
	public List<AdminRequestAdDTO> getRequestAdList(  int count  ) {
		return session.selectList( "Admin.getRequestAdList", count  );
	}
	
	public int getRequestGradeCount() {
		return session.selectOne( "Admin.getRequestGradeCount");
	}
	
	public List<AdminRequestGradeDTO> getRequestGradeList(  int count  ) {
		return session.selectList( "Admin.getRequestGradeList", count  );
	}
	
	public int getReviewCount( String user_id ) {
		return session.selectOne( "Admin.getReviewCount", user_id );
	}
	
	public List<AdminReviewDTO> getReviewList( String user_id ) {
		return session.selectList( "Admin.getReviewList", user_id  );
	}
	
	public int getUserCount() {
		return session.selectOne( "Admin.getUserCount" );
	}
	
	public AdminUserDTO getUserInfo( String user_id ) {
		return session.selectOne( "Admin.getUserInfo", user_id );	
	}
	
	public List<AdminUserDTO> getUserList( ) {	
		return session.selectList( "Admin.getUserList" );
	}
	
	public List<AdminUserDTO> getUserListByOptionSort( int userSort ) {	
		
		if ( userSort == 2) {
			return session.selectList( "Admin.getUserListByRegAsc" );
		} else if (userSort == 3 ) {
			return session.selectList( "Admin.getUserListGeneral" );
		} else if (userSort == 4 ) {
			return session.selectList( "Admin.getUserListOffice" );
		} else {
			return session.selectList( "Admin.getUserListByRegDesc" );
		}
		
	}
	
	public List<AdminUserDTO> getUserListByOptionSelect( int userSelect, String search_word ) {	
		
		if ( userSelect == 5 ) {
			return session.selectList( "Admin.getUserListId", search_word );
		} else if ( userSelect == 6 ) {
			return session.selectList( "Admin.getUserListNick", search_word );
		} else {
			return session.selectList( "Admin.getUserList");
		}
		
	}
	
	public int registAd( int checkedId ) {
		int requestAdResult = 0;
		int requestAdConfirmResult = 0;
		
		requestAdResult = session.update( "Admin.requestAd", checkedId );
		requestAdConfirmResult = session.update( "Admin.requestAdConfirm", checkedId );
		
		return  requestAdResult * requestAdConfirmResult ;	
	}
	
	public int registUserInOffice( int regist_request_id ) {	
		int idInOfficeResult = 0;
		int changeUserGradeResult = 0;
		int registConfirmResult = 0;
		
		idInOfficeResult = session.update( "Admin.idInOffice", regist_request_id );
		changeUserGradeResult = session.update( "Admin.changeUserGrade", regist_request_id );
		registConfirmResult = session.update( "Admin.registConfirm", regist_request_id );
		
		return  idInOfficeResult * changeUserGradeResult * registConfirmResult;		
	}
	
	public int updateOfficeGrade( int checkedId ) {
		int changeOfficeGradeResult = 0;
		int changeOfficeGradeConfirmResult = 0;
	
		changeOfficeGradeResult = session.update( "Admin.changeOfficeGrade", checkedId );
		changeOfficeGradeConfirmResult = session.update( "Admin.changeOfficeGradeConfirm", checkedId );
		
		return  changeOfficeGradeResult * changeOfficeGradeConfirmResult ;
	}
}
