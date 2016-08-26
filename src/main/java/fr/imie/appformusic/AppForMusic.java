package fr.imie.appformusic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;

@SpringBootApplication
public class AppForMusic {

	public static void main(String[] args) {
		SpringApplication.run(AppForMusic.class, args);
	}
	
	// Pour instancier une session hibernate
	@Bean
	public HibernateJpaSessionFactoryBean sessionFactory(){
		return new HibernateJpaSessionFactoryBean();
	}

}
