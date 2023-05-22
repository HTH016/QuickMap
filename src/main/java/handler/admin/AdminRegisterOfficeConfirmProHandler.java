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
public class AdminRegisterOfficeConfirmProHandler implements CommandHandler {
	
	private AdminDAO adminDAO = new AdminDAO();
	
	@RequestMapping("/adminregisterofficeconfirmpro")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding( "utf-8" );
		
		/*
		 	사업자 등록 번호 저장
		 	회원 등급 변경
		 	회원 id 추가
		 */
		
		int regist_request_id = Integer.parseInt( request.getParameter( "regist_request_id" ) );
		//AdminRegisterOfficeDTO dto = new AdminRegisterOfficeDTO();

		/*
		int resultOffice = adminDAO.registUserInOffice( registRequestId );
		int resultNumber = adminDAO.registOfficeNumber( registRequestId  );
		int resultDate = adminDAO.updateRegistConfirmDate( registRequestId  );
		int resultGrade = adminDAO.modifyUserGrade( registRequestId  );
		*/ 
		
		int result = adminDAO.registUserInOffice( regist_request_id );
		
		/*
		request.setAttribute( "resultOffice", resultOffice );
		request.setAttribute( "resultNumber", resultNumber );
		request.setAttribute( "resultDate", resultDate );
		request.setAttribute( "resultGrade", resultGrade );
		*/ 
		request.setAttribute( "result", result );
		request.setAttribute( "regist_request_id", regist_request_id );
		
		
		return new ModelAndView("admin/adminRegisterOfficeConfirmPro");
	}

}
