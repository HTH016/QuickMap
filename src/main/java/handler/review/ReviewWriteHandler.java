package handler.review;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import handler.CommandHandler;
import review.ReviewDAO;
import review.ReviewDataBean;

@Controller
public class ReviewWriteHandler implements CommandHandler {
	
	@Resource
	private ReviewDAO reviewDao;
	
	@RequestMapping("/reviewwrite")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Exception {

//		int office_id = Integer.parseInt(request.getParameter("office_id"));
		int office_id = 26;
		
		ReviewDataBean dto = reviewDao.getOffice(office_id);
		request.setAttribute("dto", dto);
		

		return new ModelAndView("review/reviewWrite");
	}

}
