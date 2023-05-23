package handler.office;

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
public class OfficeModifyProHandler implements CommandHandler {
	
	@Resource(name="officeDao")
	private OfficeDAO officeDao;
	
	@RequestMapping("/officemodifypro")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		OfficeDataBean dto = new OfficeDataBean();
		dto.setService_id(Integer.parseInt(request.getParameter("service_id")));
		dto.setOffice_tel(request.getParameter("office_tel"));
		
		String image1 = request.getParameter("image1");
		String image2 = request.getParameter("image2");
		String image3 = request.getParameter("image3");
		String office_image = null;
		office_image = image1 + "," + image2 + "," + image3;
		dto.setOffice_image(office_image);
			
		String keyword1 = request.getParameter("keyword1");
		String keyword2 = request.getParameter("keyword2");
		String keyword3 = request.getParameter("keyword3");
		String keyword4 = request.getParameter("keyword4");
		String office_keyword = null;
		office_keyword = keyword1 + "," + keyword2 + "," + keyword3 + "," + keyword4;
		dto.setOffice_keyword(office_keyword);
		
		dto.setOffice_business_hours_noti(request.getParameter("office_business_hours_noti"));
		dto.setOffice_start_mon(request.getParameter("office_start_mon"));
		dto.setOffice_end_mon(request.getParameter("office_end_mon"));
		
		dto.setOffice_start_tue(request.getParameter("office_start_tue"));
		dto.setOffice_end_tue(request.getParameter("office_end_tue"));
		
		dto.setOffice_start_wed(request.getParameter("office_start_wed"));
		dto.setOffice_end_wed(request.getParameter("office_end_wed"));
		
		dto.setOffice_start_thu(request.getParameter("office_start_thu"));
		dto.setOffice_end_thu(request.getParameter("office_end_thu"));
		
		dto.setOffice_start_fri(request.getParameter("office_start_fri"));
		dto.setOffice_end_fri(request.getParameter("office_end_fri"));
		
		dto.setOffice_start_sat(request.getParameter("office_start_sat"));
		dto.setOffice_end_sat(request.getParameter("office_end_sat"));
		
		dto.setOffice_start_sun(request.getParameter("office_start_sun"));
		dto.setOffice_end_sun(request.getParameter("office_end_sun"));
		
		dto.setUser_id((String) request.getSession().getAttribute("memId"));
		
		int result = officeDao.modifyOffice(dto);
		request.setAttribute("result", result);
					
		return new ModelAndView("office/officeModifyPro");
	}

}
