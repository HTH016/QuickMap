package handler.office;

import java.io.File;
import java.sql.Timestamp;

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
import office.OfficeRegisterDataBean;

@Controller
public class OfficeRegisterProHandler implements CommandHandler {
	
	@Resource(name="officeDao")
	private OfficeDAO officeDao;
	
	@RequestMapping("/officeregisterpro")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
		OfficeRegisterDataBean dto = new OfficeRegisterDataBean();
	
		// 사진경로 
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
		
		/*
		Enumeration<?> e = multi.getParameterNames();
		while(e.hasMoreElements()) {
			String name = (String) e.nextElement();
			System.out.println("name : " + name);
		}
		*/
		
		String originName1 = multi.getOriginalFileName("office_regist_num_img");
		String systemName1 = multi.getFilesystemName("office_regist_num_img");
		String filePath = dirPath + "/" + systemName1;

		System.out.println("originName1 : " + originName1);
		System.out.println("systemName1 : " + systemName1);
		System.out.println("filePath : " + filePath);
		
		String user_id = (String) request.getSession().getAttribute("memId");
		int office_id = Integer.parseInt(multi.getParameter("office_id"));
		
		dto.setUser_id(user_id);
		dto.setOffice_id(office_id);
		
		// db
		dto.setOffice_regist_num(multi.getParameter("office_regist_num"));
		dto.setOffice_regist_num_img(filePath);	
		dto.setOffice_regist_submit(new Timestamp(System.currentTimeMillis()));
		
		int result = officeDao.registerOffice(dto);
		request.setAttribute("result", result);
		
		
		return new ModelAndView("office/officeRegisterPro");
	}

}