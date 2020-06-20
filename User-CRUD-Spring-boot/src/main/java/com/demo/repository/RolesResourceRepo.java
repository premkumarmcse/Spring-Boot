package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demo.entity.RoleResource;

public interface RolesResourceRepo extends JpaRepository<RoleResource, Long>{

	@Query("select u.resourceName from RoleResource u where u.role.roleName = :roleName and u.active = :active")
	List<String> getListOfRoleResource(@Param("roleName") String roleName, @Param("active") boolean active);

}
