package fr.imie.appformusic.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import fr.imie.appformusic.configuration.constants.Routes;

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
	UserDetailsService userService;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/" + Routes.SIGNIN, "/" + Routes.SIGNUP, "/main", "/wro/*").permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin().permitAll().loginPage(Routes.SIGNIN)
			.defaultSuccessUrl("/" + Routes.SEARCH)
			.usernameParameter("username")
			.passwordParameter("password")
			.and()
			.logout()
			.and()
			.exceptionHandling().accessDeniedPage("/403")
			.and()
			.csrf();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
	
}
