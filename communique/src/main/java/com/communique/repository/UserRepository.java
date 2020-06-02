package com.communique.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.communique.entity.UserDetails;

public interface EmailRepository extends JpaRepository<UserDetails, Long> {

	UserDetails findByUsername(String username);

}