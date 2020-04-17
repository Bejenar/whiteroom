package com.whiteroom.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		//in memory auth
		UserBuilder users = User.withDefaultPasswordEncoder();
	
		auth.inMemoryAuthentication()
			.withUser(users.username("admin").password("admin").roles("admin"));
		
		//auth.jdbcAuthentication().dataSource(securityDataSource);
	
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/**").hasRole("admin")
			.and()
			.formLogin()
				.loginPage("/login")
				.loginProcessingUrl("/authentithication")
				.permitAll()
			.and()
			.logout().permitAll()
			
			.and()
            .logout().deleteCookies("JSESSIONID")

            .and()
            .rememberMe().key("uniqueAndSecret")
            
			.and()
			.exceptionHandling().accessDeniedPage("/access-denied");
	}
	
}
