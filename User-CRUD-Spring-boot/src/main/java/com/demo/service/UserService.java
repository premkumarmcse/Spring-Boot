package com.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Dto.UserDto;
import com.demo.entity.User;
import com.demo.repository.UserServiceRepo;

@Service
public class UserService {

	@Autowired
	private UserServiceRepo userServiceRepo;

	public List<UserDto> getAllUsers() {
		List<User> usersList = userServiceRepo.findAll();
		List<UserDto> userDtoList = new ArrayList<UserDto>();
		for (User user : usersList) {
			userDtoList.add(new UserDto(user));
		}
		return userDtoList;
	}

	public UserDto getUser(long id) {
		User user = userServiceRepo.getById(id);
		if(user != null) {
			UserDto userDto = new UserDto(user);
			return userDto;
		}
		return null;
	}

	public void addUser(UserDto userDto) {
		User user = new User(userDto);
		userServiceRepo.save(user);
	}

	public void updateUser(UserDto userDto) {
		User user = new User(userDto);
		userServiceRepo.save(user);
	}

	public void deleteUser(long id) {
		userServiceRepo.deleteById(id);
	}

}
