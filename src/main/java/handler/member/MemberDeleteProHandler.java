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
public class MemberDeleteProHandler implements CommandHandler {
	
	@Resource(name="memberDao")
	private MemberDao memberDao;
	
	@RequestMapping("/memberdeletepro")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String user_id = (String) request.getSession().getAttribute("memId");
		String user_passwd = (String) request.getSession().getAttribute("user_passwd");
		
		int resultCheck = memberDao.check(user_id, user_passwd);
		request.setAttribute("resultCheck", resultCheck);
		
		if(resultCheck == 1) {
			int result = memberDao.deleteMember(user_id);
			request.setAttribute("result", result);
		}
		
		return new ModelAndView("member/deletePro");
	}

}
