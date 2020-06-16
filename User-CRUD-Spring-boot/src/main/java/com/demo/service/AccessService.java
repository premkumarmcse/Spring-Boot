package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.demo.Dto.ResourceDto;
import com.demo.Dto.RoleDto;
import com.demo.Dto.RoleResourceDto;
import com.demo.Dto.UserRoleDto;
import com.demo.entity.Resource;
import com.demo.entity.Role;
import com.demo.entity.RoleResource;
import com.demo.entity.UserRole;
import com.demo.models.AuthenticationRequest;
import com.demo.models.AuthenticationResponse;
import com.demo.repository.ResourceRepo;
import com.demo.repository.RolesRepo;
import com.demo.repository.RolesResourceRepo;
import com.demo.repository.UserRoleRepo;
import com.demo.util.JwtUtil;

@Service
public class AccessService {

	@Autowired
	private RolesRepo rolesRepo;

	@Autowired
	private ResourceRepo resourceRepo;

	@Autowired
	private RolesResourceRepo rolesResourceRepo;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private MyUserDetailsService userDetailsService;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private UserRoleRepo userRoleRepo;

	public ResponseEntity<AuthenticationResponse> createAuthenticationToken(AuthenticationRequest authenticationRequest) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String jwt = jwtUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));

	}

	public void addRole(RoleDto roleDto) {
		Role role = new Role(roleDto);
		rolesRepo.save(role);
	}

	public void addResource(ResourceDto resourceDto) {
		Resource resource = new Resource(resourceDto);
		resourceRepo.save(resource);
	}

	public void assignResourceToRole(RoleResourceDto roleResourceDto) {
		RoleResource roleResource = new RoleResource(roleResourceDto);
		roleResource.setActive(true);
		rolesResourceRepo.save(roleResource);
	}

	public void assignRoleToUser(UserRoleDto userRoleDto) {
		UserRole userRole = new UserRole(userRoleDto);
		userRoleRepo.save(userRole);

	}

}
