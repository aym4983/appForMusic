package fr.imie.appformusic.configuration;

import java.util.Locale;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

import ro.isdc.wro.config.jmx.ConfigConstants;
import ro.isdc.wro.http.ConfigurableWroFilter;
import ro.isdc.wro.model.resource.processor.factory.ConfigurableProcessorsFactory;

@Configuration
@EnableWebMvc
public class DispatcherInitializer extends WebMvcConfigurerAdapter  {

	@Bean
	public UrlBasedViewResolver tilesResolver(){
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setViewClass(TilesView.class);
		return resolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css/**").addResourceLocations("/css/");
		registry.addResourceHandler("/js/**").addResourceLocations("/js/");
		registry.addResourceHandler("/fonts/**").addResourceLocations("/fonts/");
		registry.addResourceHandler("/img/**").addResourceLocations("/img/");
	}
	
	@Bean
	public TilesConfigurer tilesConfigurer(){
		TilesConfigurer tc = new TilesConfigurer();
		tc.setDefinitions("/WEB-INF/tiles.xml");
		return tc;
	}
	
//	@Bean
//	public MessageSource messageSource (){
//		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
//		messageSource.setBasenames("/i18n/fr.properties", "/i18n/en.properties");
//		messageSource.setDefaultEncoding("UTF-8");
//		return messageSource;
//	}
	
	@Bean
	    public LocaleResolver localeResolver(){
		CookieLocaleResolver resolver = new CookieLocaleResolver();
		resolver.setDefaultLocale(new Locale("fr"));
		resolver.setCookieName("myLocaleCookie");
		resolver.setCookieMaxAge(4800);
		return resolver;
    }
	
    @Override
	    public void addInterceptors(InterceptorRegistry registry) {
		LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
		interceptor.setParamName("mylocale");
		registry.addInterceptor(interceptor);
    }
    
    @Bean
    org.springframework.boot.web.servlet.FilterRegistrationBean webResourceOptimizer (Environment env){
    	org.springframework.boot.web.servlet.FilterRegistrationBean fr = new org.springframework.boot.web.servlet.FilterRegistrationBean();
    	ConfigurableWroFilter filter = new ConfigurableWroFilter();
    	filter.setProperties(buildWroProperties(env));
    	fr.setFilter(filter);
    	fr.addUrlPatterns("/wro/*");
    	return fr;
    }
    
    private static final String[] OTHER_WRO_PROP = new String[]{ ConfigurableProcessorsFactory.PARAM_PRE_PROCESSORS,
    		ConfigurableProcessorsFactory.PARAM_POST_PROCESSORS };
    
    private Properties buildWroProperties(Environment env){
    	Properties prop = new Properties();
    	for(ConfigConstants c : ConfigConstants.values()){
    		addProperty(env, prop, c.name());
    	}
    	for(String name : OTHER_WRO_PROP){
    		addProperty(env, prop, name);
    	}
    	return prop;
    }
 
    private void addProperty(Environment env, Properties to, String name){
    	String value = env.getProperty("wro." + name);
    	if (value != null){
    		to.put(name, value);
    	}
    }

}
