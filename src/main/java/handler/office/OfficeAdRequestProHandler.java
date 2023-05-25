package handler.office;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import handler.CommandHandler;
import office.OfficeAdRequestDataBean;
import office.OfficeDAO;

@Controller
public class OfficeAdRequestProHandler implements CommandHandler {
	
	@Resource(name="officeDao")
	private OfficeDAO officeDao;
	
	@RequestMapping("/officeadrequestpro")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Exception {
				
		String user_id = (String) request.getSession().getAttribute("memId");
		
		OfficeAdRequestDataBean dto = officeDao.getOfficeAd(user_id);
		request.setAttribute("dto", dto);
		
		int office_id = dto.getOffice_id();
		dto.setOffice_id(office_id);
		
		
		String startDate = request.getParameter("ad_request_start");
		String endDate = request.getParameter("ad_request_end");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			Date start = sdf.parse(startDate);
			Date end = sdf.parse(endDate);
			Timestamp ad_start = new Timestamp(start.getTime());
			Timestamp ad_end = new Timestamp(end.getTime());
			
			dto.setAd_request_start(ad_start);
			dto.setAd_request_end(ad_end);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		dto.setAd_request_level(Integer.parseInt(request.getParameter("ad_request_level")));
		dto.setAd_request_submit(new Timestamp(System.currentTimeMillis()));
		
		int result = officeDao.requestAd(dto);
		request.setAttribute("result", result);
		
		return new ModelAndView("office/officeAdRequestPro");
	}

}