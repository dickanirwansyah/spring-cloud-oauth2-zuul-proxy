package com.micro.uizuulapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;

@SpringBootApplication
@EnableZuulProxy
@EnableOAuth2Sso
public class UiZuulAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(UiZuulAppApplication.class, args);
	}
	
	@Bean
	public OAuth2RestTemplate oauth2RestTemplate(OAuth2ClientContext context,
			OAuth2ProtectedResourceDetails resource) {
		
		OAuth2RestTemplate oauth2 = new OAuth2RestTemplate(resource, context);
		return oauth2;
	}
}
