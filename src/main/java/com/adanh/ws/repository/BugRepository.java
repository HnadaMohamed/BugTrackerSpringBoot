package com.adanh.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adanh.ws.entity.Bug;

@Repository
public interface BugRepository extends JpaRepository<Bug, Integer> {
	

}
