/*
 * Date : 30/07/2021
 * Author : Mohamed HNADA 
 */

package com.adanh.ws.websecurity;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.adanh.ws.BugTrackerApplicationContext;
import com.adanh.ws.dto.UserDTO;
import com.adanh.ws.utils.JwtUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private final AuthenticationManager authenticationManager;

	public AuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}
	// This methode called from the addFilter in the WebSeurity
	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
			throws AuthenticationException {
		try {
			// Get the auth : username and password 
			UserDTO user = new ObjectMapper().readValue(req.getInputStream(), UserDTO.class);
			
			// Authenticate and check the Email and Password 
			return authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
			// If the users exist and password is OK the we go to the  successfulAuthentication()
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	 @Override
	 protected void successfulAuthentication(HttpServletRequest req,
	                                            HttpServletResponse res,
	                                            FilterChain chain,
	                                            Authentication auth) throws IOException, ServletException {
		 // So the user and password are OK, we generate the token and send it back.
		 JwtUtils jwtUtils = (JwtUtils) BugTrackerApplicationContext.getBean("jwtUtils");
		 UserDetails userDetails = (UserDetails)auth.getPrincipal();
	     String token = jwtUtils.generateToken(userDetails);
	          
	     res.addHeader(SecurityConstant.HEADER_STRING, SecurityConstant.TOKEN_PREFIX + token);
	     
	 } 
	 
	 @Override
     protected void unsuccessfulAuthentication(HttpServletRequest req, 
           HttpServletResponse res, AuthenticationException failed) throws IOException, ServletException {
		 res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
     }

	 
	 
	 
	 
	
}
