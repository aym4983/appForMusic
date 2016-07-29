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
			.usersByUsernameQuery("select userName, password, enabled from Users where userName=?")
			.authoritiesByUsernameQuery("select userName, role from Users_authorization where userName=?");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/css/**", "/js/**").permitAll()
			.antMatchers("sign-in", "/sign-up").permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin().permitAll()
			.loginPage("/index.jsp") 
			.defaultSuccessUrl("/home")
			.usernameParameter("username")
			.passwordParameter("password")
			.and()
			.logout()
			.and()
			.exceptionHandling().accessDeniedPage("/403")
			.and()
			.csrf();
	}
	
}
