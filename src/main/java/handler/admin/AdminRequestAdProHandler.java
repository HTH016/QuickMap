package handler.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import admin.AdminDAO;
import handler.CommandHandler;

@Controller
public class AdminRequestAdProHandler implements CommandHandler {
	
	private AdminDAO adminDAO = new AdminDAO();
	
	@RequestMapping("/adminrequestadpro")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String[] getCheckedId = request.getParameterValues("adselect");
		int[] checkedId = new int[getCheckedId.length];
		int[] resultArr = new int[getCheckedId.length];
		int result = 1;
		for (int i = 0 ; i < getCheckedId.length ; i++) {
			checkedId[i] = Integer.parseInt(getCheckedId[i]);
			resultArr[i] = adminDAO.registAd( checkedId[i] );
			result *= resultArr[i];
		}

		

		request.setAttribute( "result", result );
		
		
		
		return new ModelAndView("admin/adminRequestAdPro");
	}

}
