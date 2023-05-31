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
public class AdminRegisterOfficeConfirmProHandler implements CommandHandler {
	@Resource(name="adminDao")
	private AdminDAO adminDao;
	
	@RequestMapping("/adminregisterofficeconfirmpro")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding( "utf-8" );

		int regist_request_id = Integer.parseInt( request.getParameter( "regist_request_id" ) );

		int result = adminDao.registUserInOffice( regist_request_id );

		request.setAttribute( "result", result );
		request.setAttribute( "regist_request_id", regist_request_id );
		
		return new ModelAndView("admin/adminRegisterOfficeConfirmPro");
	}
}
