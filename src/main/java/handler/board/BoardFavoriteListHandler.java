package handler.board;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import board.BoardDao;
import board.BoardDataBean;
import handler.CommandHandler;

@Controller
public class BoardFavoriteListHandler implements CommandHandler {
	
	@Resource(name="boardDao")
	private BoardDao boardDao;
	
	@RequestMapping("/boardfavoritelist")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String user_id = (String) request.getSession().getAttribute("memId");
	    int count = boardDao.getCount();

	    List<BoardDataBean>	dtos = null;
	    
//	    if(count > 0) {
	    	dtos = boardDao.getBookmark("aaa");
//	    	System.out.println(count);
//	    }
	    
	    request.setAttribute("dtos", dtos);
	    
	    return new ModelAndView("board/favoriteList");
	}

}
