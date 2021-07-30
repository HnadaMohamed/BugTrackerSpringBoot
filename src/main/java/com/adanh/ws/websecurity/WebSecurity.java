/*
 * Date : 30/07/2021
 * Author : Mohamed HNADA 
 */

package com.adanh.ws.websecurity;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.adanh.ws.services.UserService;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
	
	private final UserService userDetailsService;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	public WebSecurity(UserService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userDetailsService = userDetailsService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	// The first methode that get the Request and handle it 
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		.cors().and() // Activate Cors 
		.csrf().disable() //Disable CSRF
		.authorizeRequests()
		.antMatchers(HttpMethod.POST , SecurityConstant.SINGN_UP_URL).permitAll() // SIGNUP : Authorise addition of new users, We go directly to the UserController then 
		.anyRequest().authenticated()
		.and()
		.addFilter(getAuthenticationFilter());   // SIGNIN :Checking the Login and Password and call teh attemptAuthentication() in AuthenticationFilter
		
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
	}
	
	protected AuthenticationFilter getAuthenticationFilter() throws Exception {
		AuthenticationFilter filter = new AuthenticationFilter(authenticationManager());
		filter.setFilterProcessesUrl(SecurityConstant.SINGN_IN_URL); // change the "login" url to the new one , by default in SptingSecurity its  "/login"
		return filter;
	}
	
}
