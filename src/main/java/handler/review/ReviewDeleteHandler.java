package handler.review;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import handler.CommandHandler;
import review.ReviewDAO;

@Controller
public class ReviewDeleteHandler implements CommandHandler {
	
	@Resource(name="reviewDao")
	private ReviewDAO reviewDao;
	
	@RequestMapping("/reviewdelete")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int review_id = Integer.parseInt(request.getParameter("review_id"));
		int result = reviewDao.deleteReview(review_id);
		
		request.setAttribute("result", result);
		request.setAttribute("review_id", review_id);

		return new ModelAndView("review/reviewDelete");
	}

}
