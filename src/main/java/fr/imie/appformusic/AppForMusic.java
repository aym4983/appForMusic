package fr.imie.appformusic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import fr.imie.appformusic.configuration.DataSourceConfig;
import fr.imie.appformusic.configuration.SecurityConfig;

@EnableAutoConfiguration
@ComponentScan
public class AppForMusic {

	public static void main(String[] args) {
		SpringApplication.run(AppForMusic.class, args);
	}

}
