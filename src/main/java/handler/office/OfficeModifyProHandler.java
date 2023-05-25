package handler.office;

import java.io.File;
import java.util.ArrayList;
import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

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
		
		
		OfficeDataBean dto = new OfficeDataBean();
		
		// 홍보사진 업로드
		request.setCharacterEncoding("UTF-8");
		ServletContext context = request.getServletContext();
		String dirPath	= "/image_reg";
		String realPath = context.getRealPath(dirPath);
		new File(realPath).mkdir();
		String encType = "UTF-8";
		int sizeLimit = 20 * 1024 * 1024;
		
		MultipartRequest multi = new MultipartRequest(
				request, 
				realPath, 
				sizeLimit, 
				encType, 
				new DefaultFileRenamePolicy()
		);
		ArrayList<String> arrNames = new ArrayList<>();
		String systemName1 = multi.getFilesystemName("office_image1");
		String systemName2 = multi.getFilesystemName("office_image2");
		String systemName3 = multi.getFilesystemName("office_image3");
		if(systemName1 != null ) {
			arrNames.add(systemName1);
		}
		if(systemName2 != null) {
			arrNames.add(systemName2);
		}
		if(systemName3 != null) {
			arrNames.add(systemName3);
		}
		String filePath = "";

		for(String name : arrNames) {
 			filePath += dirPath + "/" + name + ";" ;	
 		}
		if(!filePath.isEmpty()) {
			filePath = filePath.substring(0, filePath.length()-1);
		}
		System.out.println("filePath : " + filePath);
		dto.setOffice_image(filePath);	
			
		String keyword1 = multi.getParameter("keyword1");
		String keyword2 = multi.getParameter("keyword2");
		String keyword3 = multi.getParameter("keyword3");
		String keyword4 = multi.getParameter("keyword4");
		String office_keyword = null;
		office_keyword = keyword1 + ";" + keyword2 + ";" + keyword3 + ";" + keyword4;
		dto.setOffice_keyword(office_keyword);
		
		dto.setService_id(Integer.parseInt(multi.getParameter("service_id")));
		dto.setOffice_tel(multi.getParameter("office_tel"));
		dto.setOffice_business_hours_noti(multi.getParameter("office_business_hours_noti"));
		dto.setOffice_start_mon(multi.getParameter("office_start_mon"));
		dto.setOffice_end_mon(multi.getParameter("office_end_mon"));
		
		dto.setOffice_start_tue(multi.getParameter("office_start_tue"));
		dto.setOffice_end_tue(multi.getParameter("office_end_tue"));
		
		dto.setOffice_start_wed(multi.getParameter("office_start_wed"));
		dto.setOffice_end_wed(multi.getParameter("office_end_wed"));
		
		dto.setOffice_start_thu(multi.getParameter("office_start_thu"));
		dto.setOffice_end_thu(multi.getParameter("office_end_thu"));
		
		dto.setOffice_start_fri(multi.getParameter("office_start_fri"));
		dto.setOffice_end_fri(multi.getParameter("office_end_fri"));
		
		dto.setOffice_start_sat(multi.getParameter("office_start_sat"));
		dto.setOffice_end_sat(multi.getParameter("office_end_sat"));
		
		dto.setOffice_start_sun(multi.getParameter("office_start_sun"));
		dto.setOffice_end_sun(multi.getParameter("office_end_sun"));
		
		dto.setUser_id((String) request.getSession().getAttribute("memId"));
		
		int result = officeDao.modifyOffice(dto);
		request.setAttribute("result", result);
					
		return new ModelAndView("office/officeModifyPro");
	}

}
