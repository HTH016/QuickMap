package handler.review;

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

@Controller
public class ReviewWriteHandler implements CommandHandler {
	
	@Resource
	private ReviewDAO reviewDao;
	
	@Resource
	private OfficeDAO officeDao;
	
	@Resource
	private MemberDao memberDao;
	
	@RequestMapping("/reviewwrite")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String	userId		= request.getParameter("userId"); 
		int		officeId	= Integer.parseInt(request.getParameter("officeId"));
		
		request.setAttribute("officeId", officeId);
//		request.setAttribute("userId", officeId);
		request.setAttribute("officeName", officeDao.getOfficeName(officeId));
		request.setAttribute("userNick", memberDao.getMemberNick(userId));
		
		return new ModelAndView("review/reviewWrite");
	}

}
