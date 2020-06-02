package com.communique.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.communique.entity.EmailLimits;

public interface EmailLimitsRepository extends JpaRepository<EmailLimits, Long>{

	EmailLimits findByUserName(String username);
	
}
