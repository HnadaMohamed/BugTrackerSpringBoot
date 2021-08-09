/*
 * Date : 30/07/2021
 * Author : Mohamed HNADA 
 */

package com.adanh.ws.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.adanh.ws.dto.UserDTO;
import com.adanh.ws.entity.UserApp;


public interface UserService extends UserDetailsService {
	
	public UserDTO addUsers( UserApp userReq);
	
	public List<UserDTO> findAllUsers();
	
	public UserDTO getUserByEmail( String email );
}
