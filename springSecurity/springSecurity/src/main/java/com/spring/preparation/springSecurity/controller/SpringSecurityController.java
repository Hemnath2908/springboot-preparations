package com.spring.preparation.springSecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secured")
public class SpringSecurityController {
	
	@GetMapping("/user")
	public String loginWithUser() {
		return "Login With User";
	}
	
	@GetMapping("/admin")
	public String loginWithAdmin() {
		return "Login With Admin";
	}
	
	

}
