package com.communique;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SuppressWarnings("deprecation")
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.httpBasic()
		.and()
		.authorizeRequests()
			.antMatchers(HttpMethod.PUT, "/updateEmailLimits/**").hasRole("ADMIN")
			.antMatchers(HttpMethod.POST, "/sendEmail/**").hasAnyRole("ADMIN", "USER")
			.antMatchers(HttpMethod.POST, "/sendBulkEmail/**").hasAnyRole("ADMIN", "USER")
			.antMatchers(HttpMethod.GET, "/get/**").permitAll()
			.and()
			.csrf().disable()
			.formLogin().disable();
	}
		
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
