package handler.office;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import handler.CommandHandler;
import office.OfficeDao;
import office.OfficeDataBean;

@Controller
public class OfficeModifyFormHandler implements CommandHandler {
	
	@Resource(name="officeDao")
	private OfficeDao officeDao;
	
	@RequestMapping("/officemodifyform")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String user_id = (String) request.getSession().getAttribute("memId");
		
		if(user_id != null) {
			OfficeDataBean dto = officeDao.getOffice(user_id);
			request.setAttribute("dto", dto);
			
			return new ModelAndView("office/officeModifyForm");
			
		} else {
			return new ModelAndView("member/loginForm");
		}

	}

}
