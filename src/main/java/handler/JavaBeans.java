package handler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

//import board.BoardDBBean;
//import board.BoardDao;
//import logon.LogonDBBean;
//import logon.LogonDao;

@Configuration
public class JavaBeans {
/*
	@Bean
	public LogonDao logonDao() {
		return new LogonDBBean();
	}
	
	@Bean
	public BoardDao boardDao() {
		return new BoardDBBean();
	}
*/

	@Bean
	public ViewResolver	getViewResolver() {
		UrlBasedViewResolver	viewResolver	= new UrlBasedViewResolver();
		
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
}
