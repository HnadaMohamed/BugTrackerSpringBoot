/*
 * Date : 30/07/2021
 * Author : Mohamed HNADA 
 */

package com.adanh.ws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adanh.ws.dto.UserDTO;
import com.adanh.ws.entity.UserApp;
import com.adanh.ws.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController extends BaseController {

	@Autowired
	UserService userService;

	@PostMapping("/signUp")
	public void signUpUsers(@RequestBody UserApp userRequest) {
		UserDTO createdUser = userService.addUsers(userRequest);
		logger.debug("User " + createdUser.toString() + " is created");
	}
	
	@PostMapping("/details")
	public UserDTO userDetailsByEmail(@RequestBody String email) {
		return userService.getUserByEmail(email);
	}

}
