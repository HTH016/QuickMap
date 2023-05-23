package handler.review;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import handler.CommandHandler;
import review.ReviewDao;
import review.ReviewDataBean;

@Controller
public class ReviewListHandler implements CommandHandler {
	
	@Resource(name="reviewDao")
	private ReviewDao reviewDao;
	
	@RequestMapping("/reviewlist")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<ReviewDataBean> dtos = null;
		
		if(reviewDao.getCount() > 0) {
			dtos = reviewDao.getReview((String) request.getSession().getAttribute("memId"));
		}
		
		request.setAttribute("dtos", dtos);
		
		return new ModelAndView("review/reviewList");
	}

}
