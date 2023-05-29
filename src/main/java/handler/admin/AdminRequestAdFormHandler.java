package handler.admin;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import admin.AdminDAO;
import admin.AdminRequestAdDTO;
import handler.CommandHandler;

@Controller
public class AdminRequestAdFormHandler implements CommandHandler {
	
	@Resource(name="adminDao")
	private AdminDAO adminDao;
	
	@RequestMapping("/adminrequestadform")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Exception {

		int count = adminDao.getRequestAdCount();	
		request.setAttribute( "count", count );

		if( count > 0 ) {
			List<AdminRequestAdDTO> dtos = adminDao.getRequestAdList( count );
			request.setAttribute( "dtos", dtos ); 
		}
		
		return new ModelAndView("admin/adminRequestAdForm");
	}

}
