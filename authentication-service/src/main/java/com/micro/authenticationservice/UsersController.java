package com.micro.authenticationservice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableResourceServer
public class UsersController {

	@RequestMapping(value = {"/userInfo"}, produces = "application/json")
	public Map<String, Object> getUsers(OAuth2Authentication user){
		Map<String, Object> userInfo = new HashMap<>();
		userInfo.put("user", user.getUserAuthentication().getPrincipal());
		userInfo.put("authorities", AuthorityUtils.authorityListToSet
				(user.getUserAuthentication().getAuthorities()));
		return userInfo;
	}
}
