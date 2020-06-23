package com.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.Dto.UserDto;
import com.demo.entity.User;

@Repository
public interface UserServiceRepo extends JpaRepository<User, Long> {

	User getById(long id);

	@Query("select u from User u where u.usrNm in (:usrNm)")
	Optional<UserDto> findByUsrNm(String usrNm);

}
