package example.spring.mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
@Configuration
@EnableWebMvc //Enables Web MVC support
public class SpringWebMvcConfigurer implements WebMvcConfigurer{
	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		String prefix = "/WEB-INF/views/";
		String suffix = ".jsp";
		viewResolver.setPrefix(prefix);
		viewResolver.setSuffix(suffix);
		return viewResolver;
	}
}
