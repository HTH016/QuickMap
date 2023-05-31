package handler.admin;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import admin.AdminDAO;
import admin.AdminReviewDTO;
import handler.CommandHandler;

@Controller
public class AdminReviewFormHandler implements CommandHandler {
	@Resource(name="adminDao")
	private AdminDAO adminDao;
	
	@RequestMapping("/adminreviewform")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Exception {

		int review_id = Integer.parseInt( request.getParameter( "review_id" ) );

		AdminReviewDTO dto = adminDao.adminReview( review_id );		
		request.setAttribute( "dto", dto );

		return new ModelAndView("admin/adminReviewForm");
	}
}
