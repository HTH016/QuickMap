package handler.member;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import handler.CommandHandler;
import member.MemberDao;

@Controller
public class MemberConfirmIdHandler implements CommandHandler {
	
	@Resource(name="memberDao")
	private MemberDao memberDao;
	
	@RequestMapping("/memberconfirmid")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String user_id = request.getParameter("user_id");
		int result = memberDao.checkId(user_id);
		
		request.setAttribute("user_id", user_id);
		request.setAttribute("result", result);
		
		return new ModelAndView("member/confirmId");
	}

}
