package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Dto.UserDto;
import com.demo.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users/")
	public List<UserDto> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/users/{id}")
	public UserDto getUser(@PathVariable long id) {
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
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable long id) {
		userService.deleteUser(id);
	}
}
