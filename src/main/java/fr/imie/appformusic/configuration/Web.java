package fr.imie.appformusic.configuration;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class Web extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class []{DispatcherInitializer.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[]{"/"};
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		FilterRegistration.Dynamic fr = servletContext.addFilter("webResourceOptimizer", new DelegatingFilterProxy());
		fr.setInitParameter("targetBeanName", "wroFilter");
		fr.setInitParameter("targetFilterLifecycle", "true");
		fr.addMappingForUrlPatterns(null, true, "/wro/*");
		super.onStartup(servletContext);
	}
}
