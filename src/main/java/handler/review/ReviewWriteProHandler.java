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
import office.OfficeDataBean;
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
		double	starPoint	= Integer.parseInt(request.getParameter("review_star"));

		ReviewDataBean dto = new ReviewDataBean();

		dto.setOffice_id(officeId);
		dto.setUser_id(userId);
		dto.setReview_reg(new Timestamp(System.currentTimeMillis()));
		dto.setReview_data(reviewData);
		dto.setReview_star(starPoint);
		
		int result = reviewDao.insertReview(dto);
		
		OfficeDataBean	office	= officeDAO.getOfficeInfo(officeId);
		
		int reviewNum	= office.getOffice_review_num()+1;
		double	tempStar	= (starPoint + office.getOffice_star()) / reviewNum;
		
		Map<String, Object>	param	= new HashMap<>();
		
		param.put("officeId", officeId);
		param.put("starPoint", tempStar);
		param.put("reviewNum", reviewNum);
		
		officeDAO.updateReviewInfo(param);
		
		request.setAttribute("result", result);

		return new ModelAndView("review/reviewWritePro");
	}

}
