package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demo.entity.RoleResource;

public interface RolesResourceRepo extends JpaRepository<RoleResource, Long> {

	@Query("select u.rsrcNm from RoleResource u where u.role.roleNm = :roleNm and u.actv = :actv")
	List<String> getListOfRoleResource(@Param("roleNm") String roleName, @Param("actv") boolean actv);

}
