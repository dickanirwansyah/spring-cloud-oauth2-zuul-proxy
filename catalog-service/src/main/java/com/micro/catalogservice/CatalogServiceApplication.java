package com.micro.catalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
public class CatalogServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogServiceApplication.class, args);
	}
	
	/** rest template config **/
	@Bean
	public OAuth2RestTemplate oauth2RestTemplate(OAuth2ClientContext context, 
			OAuth2ProtectedResourceDetails resourceDetails) {
		
		OAuth2RestTemplate oauth2 = new OAuth2RestTemplate(resourceDetails, context);
		return oauth2;
	}
}
