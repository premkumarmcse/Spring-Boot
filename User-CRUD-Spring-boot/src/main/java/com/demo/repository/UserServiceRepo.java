package com.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.User;

@Repository
public interface UserServiceRepo extends JpaRepository<User, Long> {

	User getById(long id);

	Optional<User> findByUsername(String username);

}
