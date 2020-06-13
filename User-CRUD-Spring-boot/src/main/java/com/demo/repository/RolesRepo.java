package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.Role;

public interface RolesRepo extends JpaRepository<Role, Long>{

}
