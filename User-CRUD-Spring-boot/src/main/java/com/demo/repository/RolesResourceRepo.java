package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demo.entity.RoleResource;

public interface RolesResourceRepo extends JpaRepository<RoleResource, Long>{

	@Query("select u.resourceId from RoleResource u where u.roleId = :roleId and u.active = :active")
	List<Long> getListOfRoleResource(@Param("roleId") long roleId, @Param("active") boolean active);

}
