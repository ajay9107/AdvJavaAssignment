package example.spring.mvc.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;

public class SpringWebApplicationInitializer implements WebApplicationInitializer{
	private WebApplicationContext getContext() {
		AnnotationConfigWebApplicationContext ctx = 
				new AnnotationConfigWebApplicationContext();
		ctx.setConfigLocation("example");
		//This is equivalent to @ComponentScan(basePackages = {"example"})
		return ctx;
	}
	@Override
	public void onStartup(ServletContext servletContextRef) throws ServletException {
		System.out.println("Application is starting up...");
		WebApplicationContext webCtx = getContext();
		
		DispatcherServlet frontController = new DispatcherServlet(webCtx);
		ServletRegistration.Dynamic registration = 
				servletContextRef.addServlet("myFrontController", frontController);
		registration.addMapping("/");//Accepting all requests
	}

}
