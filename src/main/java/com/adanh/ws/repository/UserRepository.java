package com.adanh.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adanh.ws.entity.UserApp;

@Repository
public interface UserRepository extends JpaRepository<UserApp, Integer> {

	UserApp findByFirstName(String name);

	UserApp findByEmail(String email);
	

}
