package handler.office;

import java.sql.Timestamp;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import handler.CommandHandler;
import office.OfficeDAO;
import office.OfficeDataBean;
import office.OfficeGradeRequestDataBean;

@Controller
public class OfficeGradeRequestHandler implements CommandHandler {

	@Resource(name="officeDao")
	private OfficeDAO officeDao;
	
	@RequestMapping("/officegraderequest")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String user_id = (String) request.getSession().getAttribute("memId");
		
		OfficeDataBean officeInfo = officeDao.getOfficeInfo(user_id);
		OfficeGradeRequestDataBean requestInfo = new OfficeGradeRequestDataBean();
		
		requestInfo.setOffice_id(officeInfo.getOffice_id());
		requestInfo.setGrade_id(1);
		requestInfo.setGrade_request_submit(new Timestamp(System.currentTimeMillis()));
		
		int result = officeDao.gradeRequest(requestInfo);

		request.setAttribute("result", result);
		
		
		return new ModelAndView("office/officeGradeRequest");
	}

}