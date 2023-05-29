package handler.admin;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import admin.AdminDAO;
import admin.AdminUserDTO;
import handler.CommandHandler;

@Controller
public class AdminUserListOptionSortFormHandler implements CommandHandler {
	
	@Resource(name="adminDao")
	private AdminDAO adminDao;
	
	@RequestMapping("/adminuserlistoptionsortform")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding( "utf-8" );
		
		int userSort = 0;
		userSort = Integer.parseInt(request.getParameter("usersort"));

		int count = adminDao.getUserCount();
		request.setAttribute( "count", count );

		if( count > 0 ) {
			List<AdminUserDTO> dtos = adminDao.getUserListByOptionSort( userSort );
			request.setAttribute( "dtos", dtos ); 
			
		}
		
		return new ModelAndView("admin/adminUserListForm");
	}

}
