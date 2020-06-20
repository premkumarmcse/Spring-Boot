package com.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.Dto.UserDto;
import com.demo.entity.User;
import com.demo.exception.ResourceNotFoundException;
import com.demo.repository.UserServiceRepo;

@Service
public class UserService {

	@Autowired
	private UserServiceRepo userServiceRepo;

	public List<UserDto> getAllUsers() {
		List<User> usersList = userServiceRepo.findAll();
		System.out.println("Data : " + usersList);
		List<UserDto> userDtoList = new ArrayList<UserDto>();
		for (User user : usersList) {
			userDtoList.add(new UserDto(user));
		}
		return userDtoList;
	}

	public ResponseEntity<UserDto> getUser(long id) throws ResourceNotFoundException {
		User user = userServiceRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));
		UserDto userDto = new UserDto(user);
		return ResponseEntity.ok().body(userDto);
	}

	public void addUser(UserDto userDto) {
		User user = new User(userDto);
		userServiceRepo.save(user);
	}

	public void updateUser(UserDto userDto) {
		User user = new User(userDto);
		userServiceRepo.save(user);
	}

	public ResponseEntity<User> deleteUser(long id) throws ResourceNotFoundException {
		User entity = userServiceRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));
		userServiceRepo.deleteById(id);
		return ResponseEntity.ok(entity);
	}

}
