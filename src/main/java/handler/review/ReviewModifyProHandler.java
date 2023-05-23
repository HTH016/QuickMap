package handler.review;

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
public class ReviewModifyProHandler implements CommandHandler {
	
	@Resource(name="reviewDao")
	private ReviewDao reviewDao;
	
	@RequestMapping("/reviewmodifypro")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");
		
		ReviewDataBean dto = new ReviewDataBean();
		dto.setReview_id(Integer.parseInt(request.getParameter("review_id")));
		dto.setReview_star(Integer.parseInt(request.getParameter("review_star")));
		dto.setReview_data(request.getParameter("review_data"));
		
		int result = reviewDao.modifyData(dto);
		
		request.setAttribute("result", result);
		
		return new ModelAndView("review/reviewModifyPro");
	}

}
