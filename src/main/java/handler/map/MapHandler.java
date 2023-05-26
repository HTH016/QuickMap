package handler.map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import handler.CommandHandler;
import member.MemberDao;

@Controller
public class MapHandler implements CommandHandler {
	@Resource(name="memberDao")
	private MemberDao memberDao;

	@RequestMapping("/main")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String	user_id		= (String)request.getSession().getAttribute("memId");
		String	user_nick	= null;
		
		if(user_id != null) {
			user_nick	= memberDao.getMember(user_id).getUser_nick();
		}

		request.setAttribute("user_id", user_id);
		request.setAttribute("user_nick", user_nick);

		return new ModelAndView("map/map");
	}

}
