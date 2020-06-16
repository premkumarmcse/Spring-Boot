package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.UserRole;

public interface UserRoleRepo extends JpaRepository<UserRole, Long> {

	UserRole findByUserId(long id);

}
