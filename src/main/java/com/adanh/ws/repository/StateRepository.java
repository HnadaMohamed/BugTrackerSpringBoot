package com.adanh.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adanh.ws.entity.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {
	

}
