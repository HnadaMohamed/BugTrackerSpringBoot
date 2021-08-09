/*
 * Date : 30/07/2021
 * Author : Mohamed HNADA 
 */

package com.adanh.ws.websecurity;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.adanh.ws.controller.BaseController;

import io.jsonwebtoken.Jwts;

public class AuthorizationFilter extends BasicAuthenticationFilter {

	Logger logger = LoggerFactory.getLogger(BaseController.class);

	public AuthorizationFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		String header = request.getHeader(SecurityConstant.HEADER_STRING);
        
        if (header == null || !header.startsWith(SecurityConstant.TOKEN_PREFIX)) {
            chain.doFilter(request, response);
            return;
        }
        
        UsernamePasswordAuthenticationToken authentication = getAuthentication(request);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request, response);
		
		
		
	}

	private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
		String token = request.getHeader(SecurityConstant.HEADER_STRING);
        
        if (token != null) {
        	logger.debug(token);
            token = token.replace(SecurityConstant.TOKEN_PREFIX, "");
            logger.debug(token);
            String user = Jwts.parser()
                    .setSigningKey( SecurityConstant.TOKEN_SECRET )
                    .parseClaimsJws( token )
                    .getBody()
                    .getSubject();
            if (user != null) {
            	logger.debug(user.toString());
				return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
            }
            return null;
		}
        return null;
	}

}
