package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Dto.UserDto;
import com.demo.entity.User;
import com.demo.exception.ResourceNotFoundException;
import com.demo.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/users/")
	public List<UserDto> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/users/getById/{id}")
	public ResponseEntity<UserDto> getUser(@PathVariable long id) throws ResourceNotFoundException {
		return userService.getUser(id);
	}

	@PostMapping("/users/")
	public void addUser(@RequestBody UserDto userDto) {
		userService.addUser(userDto);
	}

	@PutMapping("/users/")
	public void updateUser(@RequestBody UserDto userDto) {
		userService.updateUser(userDto);
	}

	@DeleteMapping("/users/deleteById/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable long id) throws ResourceNotFoundException {
		return userService.deleteUser(id);
	}
}
