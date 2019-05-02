package fr.formation.inti.controller;

//@Configuration
//@EnableWebMvc
//@ComponentScan(basePackageClasses = SpringStart.class)
public class SpringStart {

//	private static final Log log = LogFactory.getLog(SpringStart.class);
//
//	@Override
//	public void onStartup(ServletContext servletContext) throws ServletException {
//		log.info("Starting....");
//		// Init application context
//		AnnotationConfigWebApplicationContext webCtx = new AnnotationConfigWebApplicationContext();
//		webCtx.register(SpringStart.class);
//		webCtx.setServletContext(servletContext);
//		// Init dispatcher servlet
//		ServletRegistration.Dynamic servlet = servletContext.addServlet("SpringDispatcher",
//				new DispatcherServlet(webCtx));
//		servlet.setLoadOnStartup(1);
//		servlet.addMapping("*.htm");
////        servlet.addMapping("/Pages/*"); // Ici on peut mettre autre chose, ce n'est pas ésotérique
//	}

//	@Bean
//	public ViewResolver viewResolver() {
//		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//		viewResolver.setViewClass(JstlView.class);
//		viewResolver.setPrefix("/Pages/");
//		viewResolver.setSuffix(".jsp");
//		return viewResolver;
//	}
}
