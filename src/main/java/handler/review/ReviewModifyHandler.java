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
import member.MemberDao;
import office.OfficeDAO;
import review.ReviewDAO;
import review.ReviewDataBean;

@Controller
public class ReviewModifyHandler implements CommandHandler {
	
	@Resource
	private ReviewDAO reviewDao;
	
	@Resource
	private OfficeDAO officeDao;
	
	@Resource
	private MemberDao memberDao;
	
	@RequestMapping("/reviewmodify")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String	nextPage		= request.getParameter("nextPage");
		String	userId			= request.getParameter("userId");
		String	strOfficeId		= request.getParameter("officeId");
		String	strReviewId		= request.getParameter("reviewId");
		String	strUserNick		= null;
		String	strOfficeName	= null;
		int		officeId		= -1;
		int		reviewId		= -1;
		
		if(userId != null) {
			strUserNick	= memberDao.getMemberNick(userId);
		}
		
		if(strOfficeId != null) {
			officeId		= Integer.parseInt(strOfficeId);
			strOfficeName	= officeDao.getOfficeName(officeId);
		}
		
		if(strReviewId != null) {
			reviewId	= Integer.parseInt(strReviewId);
		}
		
		ReviewDataBean	dto	= null;
		
		if(strReviewId == null) {
			Map<String, Object>	param	= new HashMap<>();
			
			param.put("userId", userId);
			param.put("officeId", officeId);

			dto = reviewDao.getReview(param);
		} else {
			dto			= reviewDao.getReview(reviewId);
			officeId	= dto.getOffice_id();
		}
		
		request.setAttribute("nextPage", nextPage);
//		request.setAttribute("userId", officeId);
		request.setAttribute("officeId", officeId);
		request.setAttribute("officeName", strOfficeName);
		request.setAttribute("userNick", strUserNick);
		request.setAttribute("dto", dto);
		
		return new ModelAndView("review/reviewModify");
	}

}
