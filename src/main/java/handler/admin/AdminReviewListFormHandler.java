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
import admin.AdminRequestGradeDTO;
import admin.AdminReviewDTO;
import admin.AdminUserDTO;
import handler.CommandHandler;

@Controller
public class AdminReviewListFormHandler implements CommandHandler {
	
	private AdminDAO adminDAO = new AdminDAO();
	
	@RequestMapping("/adminreviewlistform")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Exception {

/* 페이지 생략 */
		
		String user_id = request.getParameter( "user_id" );
		int count = adminDAO.getReviewCount( user_id );
		 //회원 카운트
		
		request.setAttribute( "count", count );
		 //카운트 보내기
		
		if( count > 0 ) {
			
			List<AdminReviewDTO> dtos = adminDAO.getReviewList( user_id );

			
			request.setAttribute( "dtos", dtos ); 
			request.setAttribute( "user_id", user_id ); 
		// dtos 보내기
			
		}
		
		return new ModelAndView("admin/adminReviewListForm");
	}

}
