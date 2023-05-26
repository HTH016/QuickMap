package handler.member;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import handler.CommandHandler;
import member.MemberDao;
import member.MemberDataBean;

@Controller
public class MemberModifyViewHandler implements CommandHandler {
	
	@Resource(name="memberDao")
	private MemberDao memberDao;
	
	@RequestMapping("/membermodifyview")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String user_id = (String) request.getSession().getAttribute("memId");
//		String user_passwd = request.getParameter("user_passwd");
		
//		int result = memberDao.check(user_id, user_passwd);
//		int result = memberDao.check(user_id);
//		request.setAttribute("result", result);
		
		if(user_id != null) {
			MemberDataBean dto = memberDao.getMember(user_id);
			request.setAttribute("dto", dto);

		return new ModelAndView("member/modifyView");
		} else {
			return new ModelAndView("member/loginForm");
		}
	}

}
