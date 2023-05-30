package handler.review;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import handler.CommandHandler;
import office.OfficeDAO;
import review.ReviewDAO;
import review.ReviewDataBean;

@Controller
public class ReviewModifyProHandler implements CommandHandler {
	
	@Resource(name="reviewDao")
	private ReviewDAO reviewDao;
	
	@Resource(name="officeDao")
	private OfficeDAO officeDAO;
	
	@RequestMapping("/reviewmodifypro")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");
		
		int		reviewId	= Integer.parseInt(request.getParameter("review_id"));
		int		officeId	= Integer.parseInt(request.getParameter("officeId"));
//		String	userId		= (String) request.getSession().getAttribute("memId");
		String	reviewData	= request.getParameter("review_data");
		double	starPoint	= Double.parseDouble(request.getParameter("review_star"));

		ReviewDataBean dto = new ReviewDataBean();
		
		dto.setReview_id(reviewId);
		dto.setReview_star(starPoint);
		dto.setReview_data(reviewData);
		
		int		result			= reviewDao.modifyReview(dto);

		System.out.println(Thread.currentThread().getStackTrace()[1] + ">> result : " + result);
		
		int		reviewNum		= reviewDao.getReviewCount(officeId);
		double	avgStarPoint	= Math.round(reviewDao.getAvgStarPoint(officeId) * 10.0) / 10.0;
		
		Map<String, Object>	param	= new HashMap<>();
		
		param.put("officeId", officeId);
		param.put("starPoint", avgStarPoint);
		param.put("reviewNum", reviewNum);
		
		System.out.println(Thread.currentThread().getStackTrace()[1] + ">> starPoint : " + avgStarPoint);

		result	= officeDAO.updateReviewInfo(param);
		
		System.out.println(Thread.currentThread().getStackTrace()[1] + ">> result : " + result);

		request.setAttribute("nextPage", request.getParameter("nextPage"));
		request.setAttribute("result", result);
		
		return new ModelAndView("review/reviewModifyPro");
	}

}
