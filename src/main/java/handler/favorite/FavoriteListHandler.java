package handler.favorite;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import favorite.FavoriteDao;
import favorite.FavoriteDataBean;
import handler.CommandHandler;

@Controller
public class FavoriteListHandler implements CommandHandler {
	
	@Resource(name="favoriteDao")
	private FavoriteDao favoriteDao;
	
	@RequestMapping("/favoritelist")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Exception {

	    List<FavoriteDataBean>	dtos = null;
	    
	    if(favoriteDao.getFavoriteCount() > 0) {
		    dtos = favoriteDao.getFavoriteList((String) request.getSession().getAttribute("memId"));
	    }
	    
	    request.setAttribute("dtos", dtos);
	    
	    return new ModelAndView("favorite/favoriteList");
	}

}
