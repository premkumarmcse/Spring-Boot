package com.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.Dto.UserDto;
import com.demo.entity.Role;
import com.demo.entity.UserRole;
import com.demo.models.MyUserDetails;
import com.demo.repository.RolesRepo;
import com.demo.repository.UserRoleRepo;
import com.demo.repository.UserServiceRepo;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserServiceRepo userRepository;

	@Autowired
	private UserRoleRepo userRoleRepo;

	@Autowired
	private RolesRepo rolesRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserDto> user = userRepository.findByUsername(username);
		user.orElseThrow(() -> new UsernameNotFoundException("Not found : " + username));
		UserRole userRole = userRoleRepo.findByUserId(user.get().getId());
		Role role = rolesRepo.findById(userRole.getRoleId());
		user.get().setRole(role.getRoleName());
		return user.map(MyUserDetails::new).get();

	}

}
