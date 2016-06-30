package fr.imie.appformusic.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 
 * @author Loïc
 *
 * Class de configuration spring security
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource datasource;
	
	@Autowired
	public void configAuthentification(AuthenticationManagerBuilder auth)throws Exception{
		auth.jdbcAuthentication().dataSource(datasource)
			.usersByUsernameQuery("select identifiant, mdp, enabled from utilisateur where identifiant=?");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/register").permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.usernameParameter("identifiant")
			.passwordParameter("mdp")
			.and()
			.logout()
			.and()
			.exceptionHandling().accessDeniedPage("/403")
			.and()
			.csrf();
	}
	
}
