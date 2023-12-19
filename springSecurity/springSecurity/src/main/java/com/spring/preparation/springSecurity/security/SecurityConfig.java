package com.spring.preparation.springSecurity.security;

//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter{
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("hemnath")
//			.password(new BCryptPasswordEncoder().encode("Welcome#1")).roles("USER")
//			.and()
//			.withUser("admin").password("Admin#1").roles("ADMIN");
//	}
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers("/secured/user").hasRole("USER")
//			.antMatchers("/secured/admin").hasRole("ADMIN").and().formLogin();
//	}
//	
//	
//	@Bean
//	public PasswordEncoder getPasswordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//	
//	
//
//}
