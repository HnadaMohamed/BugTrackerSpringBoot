package com.adanh.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adanh.ws.entity.Priority;

@Repository
public interface PriorityRepository extends JpaRepository<Priority, Integer> {
	

}
