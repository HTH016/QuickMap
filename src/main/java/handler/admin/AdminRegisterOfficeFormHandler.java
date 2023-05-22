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
import admin.AdminRegisterOfficeDTO;

import handler.CommandHandler;

@Controller
public class AdminRegisterOfficeFormHandler implements CommandHandler {
	
	
	private AdminDAO adminDAO = new AdminDAO();
	
	
	@RequestMapping("/adminregisterofficeform")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Exception {

		/* 페이지 생략 */
		
		
		int count = adminDAO.getRegistOfficeCount();
		 //승인 전 회원 카운트
		
		request.setAttribute( "count", count );
		 //카운트 보내기
		
		if( count > 0 ) {
			List<AdminRegisterOfficeDTO> dtos = adminDAO.getRegistOfficeList( count );
		//dto에 selectList
			
			request.setAttribute( "dtos", dtos ); 
		// dtos 보내기
			
		}
		
		return new ModelAndView("admin/adminRegisterOfficeForm");
	}

}
