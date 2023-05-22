package handler.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import admin.AdminDAO;
import admin.AdminRegisterOfficeDTO;
import admin.AdminReviewDTO;
import handler.CommandHandler;

@Controller
public class AdminReviewFormHandler implements CommandHandler {
	
	private AdminDAO adminDAO = new AdminDAO();
	
	@RequestMapping("/adminreviewform")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Exception {

		int review_id = Integer.parseInt( request.getParameter( "review_id" ) );
		// 리뷰 id 불러오기
		
		AdminReviewDTO dto = adminDAO.adminReview( review_id );
		
		request.setAttribute( "dto", dto );
		// 보내기 
		
		return new ModelAndView("admin/adminReviewForm");
	}

}
