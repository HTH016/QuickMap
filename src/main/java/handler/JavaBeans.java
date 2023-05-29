package handler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import admin.AdminDAO;
import admin.AdminDBBean;
import favorite.FavoriteDBBean;
import favorite.FavoriteDao;
import map.MapDao;
import map.MapOfficeDetailDAO;
import member.MemberDBBean;
import member.MemberDao;
import office.OfficeDAO;
import office.OfficeDBBean;
import review.ReviewDAO;
import review.ReviewDBBean;
import statistics.StatisticsDAO;
import statistics.StatisticsDBBean;

@Configuration
public class JavaBeans {
	@Bean
	public ReviewDAO reviewDao() {
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
	public OfficeDAO officeDao() {
		return new OfficeDBBean();
	}
	
	@Bean
	public AdminDAO adminDao() {
		return new AdminDBBean();
	}
	
	@Bean
	public StatisticsDAO statisticsDao() {
		return new StatisticsDBBean();
	}
	
	@Bean
	public ViewResolver	getViewResolver() {
		UrlBasedViewResolver 	viewResolver 	= new UrlBasedViewResolver();
		
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
}
