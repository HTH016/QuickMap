package handler.review;

import java.sql.Timestamp;

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
public class ReviewWriteProHandler implements CommandHandler {
	
	@Resource
	private ReviewDAO reviewDao;
	
	@RequestMapping("/reviewwritepro")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");
		
		ReviewDataBean dto = new ReviewDataBean();
		
//		int office_id = dto.getOffice_id();
		int office_id = 26;
		dto.setOffice_id(office_id);
		
//		String user_id = (String) request.getSession().getAttribute("memId");
		String user_id = "bbb";
		dto.setUser_id(user_id);
		
		dto.setReview_star(Integer.parseInt(request.getParameter("review_star")));
		dto.setReview_data(request.getParameter("review_data"));
		dto.setReview_reg(new Timestamp(System.currentTimeMillis()));
		
		int result = reviewDao.insertReview(dto);
		request.setAttribute("result", result);

		return new ModelAndView("review/reviewWritePro");
	}

}
