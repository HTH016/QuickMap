package handler.admin;

import java.util.List;

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
public class AdminReviewListFormHandler implements CommandHandler {
	
	@Resource(name="adminDao")
	private AdminDAO adminDao;
	
	@RequestMapping("/adminreviewlistform")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String user_id = request.getParameter( "user_id" );
		
		int count = adminDao.getReviewCount( user_id );
		request.setAttribute( "count", count );		
		if( count > 0 ) {	
			List<AdminReviewDTO> dtos = adminDao.getReviewList( user_id );
					
		request.setAttribute( "dtos", dtos ); 
		request.setAttribute( "user_id", user_id ); 

		}
		
		return new ModelAndView("admin/adminReviewListForm");
	}

}
