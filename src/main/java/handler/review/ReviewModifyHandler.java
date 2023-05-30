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
public class ReviewModifyHandler implements CommandHandler {
	
	@Resource
	private ReviewDAO reviewDao;
	
	@RequestMapping("/reviewmodify")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Exception {

		int review_id = Integer.parseInt(request.getParameter("review_id"));
		ReviewDataBean dto = reviewDao.getReview(review_id);
		request.setAttribute("dto", dto);
		
		return new ModelAndView("review/reviewModify");
	}

}
