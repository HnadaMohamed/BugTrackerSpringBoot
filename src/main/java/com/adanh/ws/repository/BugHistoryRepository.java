package com.adanh.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adanh.ws.entity.BugHistory;

@Repository
public interface BugHistoryRepository extends JpaRepository<BugHistory, Integer> {
	

}
