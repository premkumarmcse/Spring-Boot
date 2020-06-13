package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.RoleResource;

public interface RolesResourceRepo extends JpaRepository<RoleResource, Long>{

}
