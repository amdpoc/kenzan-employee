package com.kenzan.employee.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter  {

	//sets up an in-memory user store with a two users.		
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	  
		auth.inMemoryAuthentication().withUser("user1").password("password1").roles("USER");
		auth.inMemoryAuthentication().withUser("admin1").password("password1").roles("ADMIN");
		
	}		
		
	
	/*protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.inMemoryAuthentication()				
				.withUser("user1").password("secret1").roles("USER")
				.and()
				.withUser("admin1").password("secret1").roles("USER", "ADMIN");
	}*/

	//Defines which URL paths should be secured and which should not
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().and()
			.authorizeRequests()
				.antMatchers("/employee/delete/**").hasRole("USER")	//Order matters. Must be defined first to get higher priority			
				.antMatchers("/", "/employee/**").permitAll()
				//.antMatchers("/", "/kenzan/**").permitAll()	//For Testing
				//.antMatchers("/users/**").hasRole("USER")
				//.antMatchers("/**").hasRole("ADMIN")
				.anyRequest().authenticated()
				.and().csrf().disable()
				.headers().frameOptions().disable();
	}	

} 
