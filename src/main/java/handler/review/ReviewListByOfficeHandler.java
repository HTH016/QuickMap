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
import member.MemberDao;
import member.MemberDataBean;
import office.OfficeDAO;
import office.OfficeDataBean;
import review.ReviewDAO;
import review.ReviewDataBean;

@Controller
public class ReviewListByOfficeHandler implements CommandHandler {
	
	@Resource(name="reviewDao")
	private ReviewDAO reviewDao;
	
	@Resource(name="memberDao")
	private MemberDao memberDao;
	
	@Resource(name="officeDao")
	private OfficeDAO officeDao;
	
	@RequestMapping("/reviewlistbyoffice")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String user_id = (String) request.getSession().getAttribute("memId");
		
		MemberDataBean userInfo	= memberDao.getMember(user_id);
		int office_id = 0;
		
		if(userInfo.getGrade_id()==3) {
			OfficeDataBean officeInfo	= officeDao.getOfficeInfo(user_id);
			office_id = officeInfo.getOffice_id();
		}
		
//		int office_id = Integer.parseInt(request.getParameter("office_id"));
		
		Map<String, Object> param = new HashMap<>();
		param.put("officeId", office_id);
		param.put("userId", user_id);
		
//		param.put("office_id", 26);
//		param.put("user_id", "bbb");
		
		
		// 로그인 X
		List<ReviewDataBean> review = reviewDao.getOfficeReviewList(param, false);
		request.setAttribute("review", review);
		
		// 로그인 O
		List<ReviewDataBean> reviewLogin = reviewDao.getOfficeReviewList(param, true);
		request.setAttribute("review", reviewLogin);
		
		
		return new ModelAndView("review/reviewListByOffice");
	}

}
