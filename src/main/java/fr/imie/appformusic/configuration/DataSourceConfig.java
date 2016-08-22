package fr.imie.appformusic.configuration;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DataSourceConfig {

	@Autowired
	private Environment env;
	
	@Bean
	public DriverManagerDataSource datasource(){
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(env.getProperty("db.driver"));
		ds.setUrl(env.getProperty("db.url"));
		ds.setUsername(env.getProperty("db.username"));
		ds.setPassword(env.getProperty("db.password"));
		return ds;
	}
	
	@Bean
	public SessionFactory sessionFactory(){
		LocalSessionFactoryBuilder sessionFactory = new LocalSessionFactoryBuilder(datasource());
		sessionFactory.scanPackages("fr.imie.appformusic.domain");
		sessionFactory.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL94Dialect");
		sessionFactory.setProperty("hibernate.show_sql", "true");
		sessionFactory.setProperty("hibernate.hbm2ddl.auto", "create-drop");
		return sessionFactory.buildSessionFactory();
	}
	
	@Bean
	public HibernateTransactionManager txManager(SessionFactory sessionFactory){
		HibernateTransactionManager tx = new HibernateTransactionManager();
		tx.setSessionFactory(sessionFactory);
		return tx;
	}
	
}
