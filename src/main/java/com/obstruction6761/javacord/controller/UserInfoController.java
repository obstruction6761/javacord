package com.obstruction6761.javacord.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/api/v1/userInfo")
@RequestMapping("/")
public class UserInfoController {
	
	@Autowired
	private OAuth2AuthorizedClientService authorizedClientService;
	
	@GetMapping
	public String getUserName(OAuth2AuthenticationToken authentication) {
		
		OAuth2AuthorizedClient client = authorizedClientService
			      .loadAuthorizedClient(
			        authentication.getAuthorizedClientRegistrationId(), 
			          authentication.getName());
		
		System.out.println("authentication.getName() = " + authentication.getName());
		System.out.println("client.getPrincipalName() = " + client.getPrincipalName());
		return client.getPrincipalName();
		
	}
}
