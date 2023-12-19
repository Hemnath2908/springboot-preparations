package com.spring.preparation.springSecurity.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigV1 {
	
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user1 = User.withUsername("hariharan").password("Welcome#1").roles("USER").build();
		UserDetails user2 = User.withUsername("hemnath").password("Welcome#2").roles("USER").build();
		UserDetails user3 = User.withUsername("siva").password("Welcome#3").roles("USER").build();
		
		UserDetails admin = User.withUsername("john").password("Admin#1").roles("ADMIN").build();

		List<UserDetails> userDetailsList = new ArrayList<>();
		userDetailsList.add(user1);
		userDetailsList.add(user2);
		userDetailsList.add(user3);
		userDetailsList.add(admin);
		
		return new InMemoryUserDetailsManager(userDetailsList);
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.authorizeRequests().requestMatchers("/secured/user").hasRole("USER")
			.requestMatchers("/secured/admin").hasRole("ADMIN")
			.and().formLogin().and().build();
		
	}
	
	
	
	

}
