package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.Resource;

public interface ResourceRepo extends JpaRepository<Resource, Long> {

}
