package com.adanh.ws.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.adanh.ws.dto.UserDTO;
import com.adanh.ws.entity.UserApp;
import com.adanh.ws.repository.UserRepository;
import com.adanh.ws.services.UserService;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	
	@Autowired
	BCryptPasswordEncoder bCriptPassswordEncoder;
	
	@Override
	public UserDTO addUsers(UserDTO userDTO) {
		
		UserApp userEntity = new UserApp();
		
		BeanUtils.copyProperties(userDTO, userEntity);
			
		UserApp userExisted = userRepository.findByEmail(userEntity.getEmail());
		
		if(userExisted!=null) { throw new RuntimeException("User Duplicated");}
		
		userEntity.setPassword(bCriptPassswordEncoder.encode(userEntity.getPassword()));
		
		UserApp userCreated = userRepository.save(userEntity);
		
		UserDTO createdUserDTO = new UserDTO();
		
		BeanUtils.copyProperties(userCreated, createdUserDTO);
		
		return createdUserDTO;
	}

	@Override
	public List<UserDTO> findAllUsers() {
		
		List<UserDTO> userDTOList =new ArrayList<UserDTO>();
		
		userRepository.findAll().forEach( (user) -> {
			UserDTO userDto = new UserDTO();
			BeanUtils.copyProperties(user, userDto);
			userDTOList.add(userDto);	
		});
		
		return userDTOList;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		UserApp userEntity = userRepository.findByEmail(email);
		
		if(userEntity == null) throw new UsernameNotFoundException(email);
		
		return new User( userEntity.getEmail(),userEntity.getPassword(),new ArrayList<>());
		
	}

	@Override
	public UserDTO getUserByEmail(String email) {
		
		UserApp userEntity = userRepository.findByEmail(email);
		
		if(userEntity == null) throw new UsernameNotFoundException(email);
		
		UserDTO userDTO = new UserDTO();
		
		BeanUtils.copyProperties(userEntity, userDTO);
		
		return userDTO;
	}

}
