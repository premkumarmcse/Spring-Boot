package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demo.entity.Resource;

public interface ResourceRepo extends JpaRepository<Resource, Long> {

	@Query("select u from Resource u where u.id in (:resourceId)")
	List<Resource> getListOfResourceUrl(@Param("resourceId") List<Long> resourceId);

}
