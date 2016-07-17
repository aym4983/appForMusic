package fr.imie.appformusic.configuration;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;

@Configuration
//@Import(DispatcherInitializer.class)
@ComponentScan(basePackages={"fr.imie.appformusic.dao"})
public class TestDispatcherConfig {

	@Bean
	public BasicDataSource datasource(){
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("org.hsqldb.jdbcDriver");
		ds.setUrl("jdbc:hsqldb:mem:test_base");
		ds.setUsername("sa");
		ds.setPassword("");
		return ds;
	}
	
	@Bean
	public SessionFactory sessionFactory(){
		LocalSessionFactoryBuilder sessionFactory = new LocalSessionFactoryBuilder(datasource());
		sessionFactory.scanPackages("fr.imie.appformusic.domain");
		sessionFactory.setProperty("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
		sessionFactory.setProperty("hibernate.show_sql", "true");
		return sessionFactory.buildSessionFactory();
	}
	
	@Autowired
	@Bean
	public HibernateTransactionManager txManager(SessionFactory sessionFactory){
		HibernateTransactionManager tx = new HibernateTransactionManager();
		tx.setSessionFactory(sessionFactory);
		return tx;
	}
	
	@Bean
	public DataSourceTransactionManager txManager(){
		DataSourceTransactionManager tx = new DataSourceTransactionManager();
		tx.setDataSource(this.datasource());
		return tx;
	}
	
}
