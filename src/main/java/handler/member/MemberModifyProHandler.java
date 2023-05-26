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
public class MemberModifyProHandler implements CommandHandler {
	
	@Resource(name="memberDao")
	private MemberDao memberDao;
	
	@RequestMapping("/membermodifypro")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		MemberDataBean dto = new MemberDataBean();
		dto.setUser_passwd(request.getParameter("user_passwd"));
		
		String tel1 = request.getParameter("tel1");
		String tel2 = request.getParameter("tel2");
		String tel3 = request.getParameter("tel3");
		String user_tel = null;
		if(! tel1.equals("") && ! tel2.equals("") && ! tel3.equals("")) {
			user_tel= tel1+ "-" +tel2+ "-" +tel3;
		}
		dto.setUser_tel(user_tel);
		
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String user_email = null;
		if (! email1.equals("") && ! email2.equals("")) {
			user_email = email1 + "@" + email2;
		}

		dto.setUser_email(user_email);
		dto.setUser_id((String) request.getSession().getAttribute("memId"));
		
		int result = memberDao.modifyMember(dto);
		request.setAttribute("result", result);
		
		return new ModelAndView("member/modifyPro");
	}

}
