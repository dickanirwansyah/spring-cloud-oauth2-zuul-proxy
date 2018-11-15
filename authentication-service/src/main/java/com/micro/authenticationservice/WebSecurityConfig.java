package com.micro.authenticationservice;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
//@EnableWebSecurity
@Order(-5)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity security) throws Exception{
		security.requestMatchers()
		.antMatchers("/login", "/oauth/authorize", "/oauth/confirm_access")
		.and().authorizeRequests().anyRequest().authenticated()
		.and().formLogin().loginPage("/login").permitAll();
	}
	
}
