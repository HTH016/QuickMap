package handler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import favorite.FavoriteDBBean;
import favorite.FavoriteDao;
import map.MapDao;
import map.MapOfficeDetailDAO;
import member.MemberDBBean;
import member.MemberDao;
import office.OfficeDBBean;
import office.OfficeDao;
import review.ReviewDBBean;
import review.ReviewDao;

@Configuration
public class JavaBeans {
	@Bean
	public ReviewDao reviewDao() {
		return new ReviewDBBean();
	}
	@Bean
	public FavoriteDao favoriteDao() {
		return new FavoriteDBBean();
	}

	@Bean
	public MemberDao memberDao() {
		return new MemberDBBean();
	}
	
	@Bean
	public MapDao mapDao() {
		return new MapOfficeDetailDAO();
	}
	
	@Bean
	public OfficeDao officeDao() {
		return new OfficeDBBean();
	}
	@Bean
	public ViewResolver	getViewResolver() {
		UrlBasedViewResolver	viewResolver	= new UrlBasedViewResolver();
		
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
}
