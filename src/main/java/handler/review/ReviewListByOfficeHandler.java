package handler.review;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class ReviewListByOfficeHandler implements CommandHandler {
	
	@Resource(name="reviewDao")
	private ReviewDAO reviewDao;
	
	@RequestMapping("/reviewlistbyoffice")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
//		int office_id = Integer.parseInt(request.getParameter("office_id"));
//		String user_id = (String) request.getSession().getAttribute("memId");
		
		
		Map<String, Object> param = new HashMap<>();
//		param.put("office_id", office_id);
//		param.put("user_id", user_id);
		
		param.put("office_id", 26);
		param.put("user_id", "bbb");
		
		
		// 로그인 X
		List<ReviewDataBean> review = reviewDao.getReviewByOffice(param, false);
		request.setAttribute("review", review);
		
		// 로그인 O
		List<ReviewDataBean> reviewLogin = reviewDao.getReviewByOffice(param, true);
		request.setAttribute("review", reviewLogin);
		
		
		return new ModelAndView("review/reviewListByOffice");
	}

}
