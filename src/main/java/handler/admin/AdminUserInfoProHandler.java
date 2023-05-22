package handler.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import admin.AdminDAO;
import handler.CommandHandler;

@Controller
public class AdminUserInfoProHandler implements CommandHandler {
	
	private AdminDAO adminDAO = new AdminDAO();;
	
	@RequestMapping("/adminuserinfopro")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String user_id = request.getParameter( "user_id" );
		int selectGrade = Integer.parseInt(request.getParameter("usersort"));
		int result = 0;
		
		/*
		if ( selectGrade == 0) {
			
			// 계정 삭제
			result = adminDAO.deleteUser( userId );
			
		} else if ( selectGrade == 1 ) {
			// 활동 정지
			result = adminDAO.freezeUser( userId );
			
		} else if ( selectGrade == 2) {
			// 일반
			result = adminDAO.normalUser( userId );
			
		} else if ( selectGrade == 3) {
			// 등록
			result = adminDAO.officeUser( userId );
			
		} else if ( selectGrade == 7) {
			// 그대로
		}
		*/
		
		result = adminDAO.changeUserGrade( user_id, selectGrade );

		request.setAttribute( "result", result );
		request.setAttribute( "user_id", user_id );
		
		return new ModelAndView("admin/adminUserInfoPro");
	}

}
