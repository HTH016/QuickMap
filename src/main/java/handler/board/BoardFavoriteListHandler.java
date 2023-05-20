package handler.board;

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
	    List<BoardDataBean>	dtos	= null;
	    
	    if(boardDao.getCount() > 0) {
		    dtos = boardDao.getBookmark((String) request.getSession().getAttribute("memId"));
	    }
	    
	    request.setAttribute("dtos", dtos);
	    
	    return new ModelAndView("board/favoriteList");
	}

}
