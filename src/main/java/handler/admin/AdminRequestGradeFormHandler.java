package handler.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import admin.AdminDAO;
import admin.AdminRequestGradeDTO;
import handler.CommandHandler;

@Controller
public class AdminRequestGradeFormHandler implements CommandHandler {
	
	private AdminDAO adminDAO = new AdminDAO();
	
	@RequestMapping("/adminrequestgradeform")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Exception {

		/* 페이지 생략 */
		
		int count = adminDAO.getRequestGradeCount();
		// 승인 전 업장 카운트
		
		request.setAttribute( "count", count );
		// 카운트 보내기
		
		if( count > 0 ) {
			List<AdminRequestGradeDTO> dtos = adminDAO.getRequestGradeList( count );
		//dto에 selectList
			
			request.setAttribute( "dtos", dtos ); 
		// dtos 보내기
			
		}
		
		return new ModelAndView("admin/adminRequestGradeForm");
	}

}
