package handler.admin;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import admin.AdminDAO;
import handler.CommandHandler;

@Controller
public class AdminUserInfoProHandler implements CommandHandler {
	@Resource(name="adminDao")
	private AdminDAO adminDao;
	
	@RequestMapping("/adminuserinfopro")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String user_id = request.getParameter( "user_id" );
		int selectGrade = Integer.parseInt(request.getParameter("usergradesort"));
		int result = 0;

		result = adminDao.changeUserGrade( user_id, selectGrade );

		request.setAttribute( "result", result );
		request.setAttribute( "user_id", user_id );
		
		return new ModelAndView("admin/adminUserInfoPro");
	}
}
