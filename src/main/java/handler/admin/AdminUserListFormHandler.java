package handler.admin;

import java.util.List;

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
public class AdminUserListFormHandler implements CommandHandler {
	
	private AdminDAO adminDAO = new AdminDAO();
	
	@RequestMapping("/adminuserlistform")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		
		// 검색 옵션
		
		/* 페이지 생략 */
		
		
		int count = adminDAO.getUserCount();
		 //회원 카운트
		
		request.setAttribute( "count", count );
		 //카운트 보내기
		
		if( count > 0 ) {
			List<AdminUserDTO> dtos = adminDAO.getUserList();
		//dto에 selectList
			
			request.setAttribute( "dtos", dtos ); 
		// dtos 보내기
			
		}
		
		
		return new ModelAndView("admin/adminUserListForm");
	}

}
