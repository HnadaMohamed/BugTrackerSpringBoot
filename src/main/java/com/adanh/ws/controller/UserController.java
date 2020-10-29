package com.adanh.ws.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adanh.ws.dto.UserDTO;
import com.adanh.ws.dto.UserResponse;
import com.adanh.ws.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping
	public UserResponse addUsers(@RequestBody UserDTO userRequest) {
		
		UserDTO userDto = new UserDTO();
		
		BeanUtils.copyProperties(userRequest, userDto);
		
		UserDTO createdUser = userService.addUsers(userDto);
		
		UserResponse userResponse = new UserResponse();
		
		BeanUtils.copyProperties(createdUser, userResponse);
		
		return userResponse;
	}

}
