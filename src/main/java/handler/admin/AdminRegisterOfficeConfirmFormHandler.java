package handler.admin;

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
	
	private AdminDAO adminDAO = new AdminDAO();
	
	@RequestMapping("/adminregisterofficeconfirmform")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		int regist_request_id = Integer.parseInt( request.getParameter( "regist_request_id" ) );
		// 신청 id 불러오기
		
		AdminRegisterOfficeDTO dto = adminDAO.confirmRegistOffice( regist_request_id );
		// 회원아이디, 사업자등록, 사업자등록증 선택
		
		request.setAttribute( "user_id", dto.getUser_id() );
		request.setAttribute( "office_regist_num", dto.getOffice_regist_num() );
		request.setAttribute( "office_regist_num_img", dto.getOffice_regist_num_img() );
		request.setAttribute( "dto", dto );
		request.setAttribute( "regist_request_id", dto.getRegist_request_id() );
		request.setAttribute( "office_name", dto.getOffice_name() );
		// 보내기 
		
		return new ModelAndView("admin/adminRegisterOfficeConfirmForm");
	}

}
