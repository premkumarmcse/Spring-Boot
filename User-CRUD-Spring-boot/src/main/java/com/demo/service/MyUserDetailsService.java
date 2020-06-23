package com.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.Dto.UserDto;
import com.demo.entity.UserRole;
import com.demo.models.MyUserDetails;
import com.demo.repository.UserRoleRepo;
import com.demo.repository.UserServiceRepo;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserServiceRepo userRepository;

	@Autowired
	private UserRoleRepo userRoleRepo;

//	@Autowired
//	private RolesRepo rolesRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserDto> user = userRepository.findByUsrNm(username);
		user.orElseThrow(() -> new UsernameNotFoundException("Not found : " + username));
		UserRole userRole = userRoleRepo.findById(user.get().getId());
//		Role role = rolesRepo.findById(userRole.getRoleName());
		user.get().setRole(userRole.getRoleNm());
		return user.map(MyUserDetails::new).get();

	}

}
