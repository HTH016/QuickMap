package handler.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import admin.AdminDAO;
import admin.AdminRegisterOfficeDTO;
import admin.AdminUserDTO;
import handler.CommandHandler;

@Controller
public class AdminUserInfoFormHandler implements CommandHandler {

	private AdminDAO adminDAO = new AdminDAO();
	
	@RequestMapping("/adminuserinfoform")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String user_id = request.getParameter( "user_id" );
		// 회원 id 불러오기
		
		AdminUserDTO dto = adminDAO.getUserInfo( user_id );
		// 회원 정보들 선택 
		
		request.setAttribute( "dto", dto );
		request.setAttribute( "user_id", user_id );
		
		// 보내기 
		
		return new ModelAndView("admin/adminUserInfoForm");
	}

}
