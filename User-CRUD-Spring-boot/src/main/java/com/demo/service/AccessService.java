package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

	public ResponseEntity<AuthenticationResponse> createAuthenticationToken(AuthenticationRequest authenticationRequest)
			throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsrNm(), authenticationRequest.getPwd()));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsrNm());
		final String jwt = jwtUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));

	}

	public void addRole(RoleDto roleDto) {
		Role role = new Role(roleDto);
		rolesRepo.save(role);
	}

	public void addResource(List<ResourceDto> resourceDto) {
		for (ResourceDto resource : resourceDto) {
			Resource resourceEntity = new Resource(resource);
			resourceRepo.save(resourceEntity);
		}

	}

	public String assignResourceToRole(RoleResourceDto roleResourceDto) {
		try {
			RoleResource roleResource = new RoleResource(roleResourceDto);
			roleResource.setActv(true);
			rolesResourceRepo.save(roleResource);
		}catch (DataIntegrityViolationException divEX) {
			if(divEX.getMostSpecificCause().toString().toUpperCase().contains("UK_ROLEID_RESOURCEID")){
					return "Resource Id and Role Id Unique";
			}
		}
		return "Resource successfully assigned to the Roles";
	}

	public void assignRoleToUser(UserRoleDto userRoleDto) {
		UserRole userRole = new UserRole(userRoleDto);
		userRoleRepo.save(userRole);

	}

}
