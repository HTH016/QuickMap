package handler.admin;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import admin.AdminDAO;
import admin.AdminUserDTO;
import handler.CommandHandler;

@Controller
public class AdminUserInfoFormHandler implements CommandHandler {
	@Resource(name="adminDao")
	private AdminDAO adminDao;
	
	@RequestMapping("/adminuserinfoform")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String user_id = request.getParameter( "user_id" );

		AdminUserDTO dto = adminDao.getUserInfo( user_id );
	
		request.setAttribute( "dto", dto );
		request.setAttribute( "user_id", user_id );

		return new ModelAndView("admin/adminUserInfoForm");
	}
}
