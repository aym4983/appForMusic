package fr.imie.appformusic.configuration;

import java.util.Locale;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
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

import ro.isdc.wro.http.ConfigurableWroFilter;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@Import(SecurityConfig.class)
@ComponentScan(basePackages = {"fr.imie.appformusic.controller", "fr.imie.appformusic.dao", "fr.imie.appformusic.service"})
public class DispatcherInitializer extends WebMvcConfigurerAdapter  {

//	@Bean
//	public InternalResourceViewResolver viewResolver (){
//		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//		resolver.setPrefix("/WEB-INF/jsp/");
//		resolver.setSuffix(".jsp");
//		return resolver;
//	}
	
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
	}
	
	@Bean
	public BasicDataSource datasource(){
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("org.postgresql.Driver");
		ds.setUrl("jdbc:postgresql://192.168.99.100:32770/appformusic");
		ds.setUsername("loic");
		ds.setPassword("loic");
		ds.setInitialSize(4);
		return ds;
	}
	
	@Bean
	public DataSourceTransactionManager txManager(){
		DataSourceTransactionManager tx = new DataSourceTransactionManager();
		tx.setDataSource(this.datasource());
		return tx;
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
    public ConfigurableWroFilter wroFilter (){
    	ConfigurableWroFilter filter = new ConfigurableWroFilter();
    	filter.setDebug(true);
    	return filter;
    }
}
