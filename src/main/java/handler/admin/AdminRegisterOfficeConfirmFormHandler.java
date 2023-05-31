package handler.admin;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import admin.AdminDAO;
import admin.AdminRegisterOfficeDTO;

import handler.CommandHandler;

@Controller
public class AdminRegisterOfficeConfirmFormHandler implements CommandHandler {
	@Resource(name="adminDao")
	private AdminDAO adminDao;
	
	@RequestMapping("/adminregisterofficeconfirmform")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int regist_request_id = Integer.parseInt( request.getParameter( "regist_request_id" ) );
			
		AdminRegisterOfficeDTO dto = adminDao.confirmRegistOffice( regist_request_id );
		request.setAttribute( "dto", dto );
		
		request.setAttribute( "user_id", dto.getUser_id() );
		request.setAttribute( "office_regist_num", dto.getOffice_regist_num() );
		request.setAttribute( "office_regist_num_img", dto.getOffice_regist_num_img() );
		request.setAttribute( "regist_request_id", dto.getRegist_request_id() );
		request.setAttribute( "office_name", dto.getOffice_name() );

		return new ModelAndView("admin/adminRegisterOfficeConfirmForm");
	}
}
