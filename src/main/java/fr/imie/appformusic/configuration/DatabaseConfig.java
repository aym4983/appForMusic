package fr.imie.appformusic.configuration;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.ActiveProfiles;

/**
 * 
 * Classe de conf particulière utilisée uniquement pour la prod
 * 
 * @author Loïc
 *
 */

@Configuration
@ActiveProfiles("prod")
public class DatabaseConfig {

	@Bean
	@Primary
	@ConfigurationProperties(prefix="spring.datasource")
	public javax.sql.DataSource datasource(){
		return DataSourceBuilder.create().build();
	}
	
}
