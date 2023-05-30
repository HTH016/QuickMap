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

@Controller
public class OfficeGradeRequestHandler implements CommandHandler {
	
	@Resource(name="officeDao")
	private OfficeDAO officeDao;
	
	@RequestMapping("/officegraderequest")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String user_id = (String) request.getSession().getAttribute("memId");
		
		OfficeDataBean dto = officeDao.getOfficeInfo(user_id);
		request.setAttribute("dto", dto);
		
		int office_id = dto.getOffice_id();
		dto.setOffice_id(office_id);
		
		int grade_id = dto.getGrade_id();
		dto.setGrade_id(grade_id);
		
		dto.setGrade_request_submit(new Timestamp(System.currentTimeMillis()));
		
		int result = officeDao.gradeRequest(dto);
		request.setAttribute("result", result);
		
		
		return new ModelAndView("office/officeGradeRequest");
	}

}