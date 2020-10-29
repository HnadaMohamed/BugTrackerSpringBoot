package com.adanh.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adanh.ws.entity.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer> {
	

}
