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
public class AdminReviewProHandler implements CommandHandler {
	
	@Resource(name="adminDao")
	private AdminDAO adminDao;
	
	@RequestMapping("/adminreviewpro")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Exception {

		int review_id = Integer.parseInt( request.getParameter( "review_id" ) );
		String user_id =  request.getParameter( "user_id" );

		int result = adminDao.adminDeleteReview( review_id );
				
		request.setAttribute( "result", result );
		request.setAttribute( "user_id", user_id );
		
		return new ModelAndView("admin/adminReviewPro");
	}

}
