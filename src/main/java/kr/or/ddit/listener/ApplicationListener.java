package kr.or.ddit.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// contextPath -> js, css 경로 설정
// ${cp}/js/jquery.js
// ${cp}/js/jquery.js
// application cp 속성에 contextPath 값을 넣어주면
public class ApplicationListener implements ServletContextListener{

	private static final Logger logger = LoggerFactory
			.getLogger(ApplicationListener.class);
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext application = sce.getServletContext();
		application.setAttribute("cp", application.getContextPath());
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	} 

}
