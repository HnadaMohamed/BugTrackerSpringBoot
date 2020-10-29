package com.adanh.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class BugTrackerWsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BugTrackerWsApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public BugTrackerApplicationContext BugTrackerApplicationContext() {
		return new BugTrackerApplicationContext();
	}
	
}
