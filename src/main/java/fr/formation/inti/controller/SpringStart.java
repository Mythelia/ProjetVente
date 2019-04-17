package fr.formation.inti.controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = SpringStart.class)
public class SpringStart implements WebApplicationInitializer {

	private static final Log log = LogFactory.getLog(SpringStart.class);

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		log.info("Starting....");
		// Init application context
		AnnotationConfigWebApplicationContext webCtx = new AnnotationConfigWebApplicationContext();
		webCtx.register(SpringStart.class);
		webCtx.setServletContext(servletContext);
		// Init dispatcher servlet
		ServletRegistration.Dynamic servlet = servletContext.addServlet("SpringDispatcher",
				new DispatcherServlet(webCtx));
		servlet.setLoadOnStartup(1);
		servlet.addMapping("*.htm");
//        servlet.addMapping("/Pages/*"); // Ici on peut mettre autre chose, ce n'est pas ésotérique

	}

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/Pages/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
}
