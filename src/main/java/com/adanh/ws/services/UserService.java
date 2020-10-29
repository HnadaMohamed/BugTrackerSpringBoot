package com.adanh.ws.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.adanh.ws.dto.UserDTO;


public interface UserService extends UserDetailsService {
	
	public UserDTO addUsers( UserDTO userDTO);
	
	public List<UserDTO> findAllUsers();
	
	public UserDTO getUserByEmail( String email );
}
