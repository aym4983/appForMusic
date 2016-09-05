package fr.imie.appformusic;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;

import fr.imie.appformusic.domain.AppUser;

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
