package com.adanh.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adanh.ws.entity.BugType;

@Repository
public interface BugTypeRepository extends JpaRepository<BugType, Integer> {
	

}
