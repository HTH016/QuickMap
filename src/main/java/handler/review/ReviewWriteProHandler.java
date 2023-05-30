package handler.review;

import java.sql.Timestamp;
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
public class ReviewWriteProHandler implements CommandHandler {
	
	@Resource
	private ReviewDAO	reviewDao;
	
	@Resource
	private OfficeDAO	officeDAO;
	
	@RequestMapping("/reviewwritepro")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");
		
//		int		officeId	= 26;
//		String	userId		= "bbb";
		int		officeId	= Integer.parseInt(request.getParameter("officeId"));
		String	userId		= (String) request.getSession().getAttribute("memId");
		String	reviewData	= request.getParameter("review_data");
		double	starPoint	= Double.parseDouble(request.getParameter("review_star"));

		ReviewDataBean dto = new ReviewDataBean();

		dto.setOffice_id(officeId);
		dto.setUser_id(userId);
		dto.setReview_reg(new Timestamp(System.currentTimeMillis()));
		dto.setReview_data(reviewData);
		dto.setReview_star(starPoint);
		
		System.out.println(Thread.currentThread().getStackTrace()[1] + ">> officeId  : " + officeId);
		System.out.println(Thread.currentThread().getStackTrace()[1] + ">> userId    : " + userId);
		System.out.println(Thread.currentThread().getStackTrace()[1] + ">> starPoint : " + starPoint);

		int result = reviewDao.insertReview(dto);
		
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

		request.setAttribute("result", result);

		return new ModelAndView("review/reviewWritePro");
	}

}
