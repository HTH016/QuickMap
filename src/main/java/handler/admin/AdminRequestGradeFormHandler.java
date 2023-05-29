package handler.admin;

import java.util.List;

import javax.annotation.Resource;
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
	
	@Resource(name="adminDao")
	private AdminDAO adminDao;
	
	@RequestMapping("/adminrequestgradeform")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Exception {

		int count = adminDao.getRequestGradeCount();	
		request.setAttribute( "count", count );
		
		if( count > 0 ) {
			List<AdminRequestGradeDTO> dtos = adminDao.getRequestGradeList( count );	
			request.setAttribute( "dtos", dtos ); 	
		}
		
		return new ModelAndView("admin/adminRequestGradeForm");
	}

}
