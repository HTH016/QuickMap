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
public class MemberConfirmNickHandler implements CommandHandler {
	@Resource(name="memberDao")
	private MemberDao memberDao;
	@RequestMapping("/memberconfirmnick")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String form		 = request.getParameter("form");
		String user_nick = request.getParameter("user_nick");
		int result = memberDao.checkNick(user_nick);
		request.setAttribute("form", form);
		request.setAttribute("user_nick", user_nick);
		request.setAttribute("result", result);
		return new ModelAndView("member/confirmNick");
	}

}
