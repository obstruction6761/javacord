package com.obstruction6761.javacord.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


/*
 * Spring OAuth2 Client security configuration
 * https://www.baeldung.com/spring-security-5-oauth2-login#setup
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.anyRequest().authenticated()
			.and()
			.oauth2Login();
	}

	
	
}
