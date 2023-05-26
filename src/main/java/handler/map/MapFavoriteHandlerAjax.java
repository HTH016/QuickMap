package handler.map;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import favorite.FavoriteDao;

@Controller
public class MapFavoriteHandlerAjax {
	@Resource(name="favoriteDao")
	private FavoriteDao favoriteDao;

	@RequestMapping("/map_favorite_ajax")
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");

		String	userId		= request.getParameter("userId");
		int		officeId	= Integer.parseInt(request.getParameter("officeId"));

		Map<String, Object>	paramFav	= new HashMap<>();
		
		paramFav.put("userId", userId);
		paramFav.put("officeId", officeId);

		System.out.println(Thread.currentThread().getStackTrace()[1] + ">> userId   : " + userId);
		System.out.println(Thread.currentThread().getStackTrace()[1] + ">> officeId : " + officeId);

		String	strSearchResult	= "";

		if(favoriteDao.getFavoriteCount(paramFav) == 0) {
			System.out.println(Thread.currentThread().getStackTrace()[1] + ">> call favoriteDao.insertFavorite");
			favoriteDao.insertFavorite(paramFav);
			strSearchResult	= "/quickmap/images/fav_sol.png";
		} else {
			System.out.println(Thread.currentThread().getStackTrace()[1] + ">> call favoriteDao.deleteFavorite");
			favoriteDao.deleteFavorite(paramFav);
			strSearchResult	= "/quickmap/images/fav_emp.png";
		}

		request.setAttribute("resulthtml", strSearchResult);
		
		return new ModelAndView("map/map_favorite_result");
	}

}
