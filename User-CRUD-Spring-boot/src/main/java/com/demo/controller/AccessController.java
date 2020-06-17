package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Dto.ResourceDto;
import com.demo.Dto.RoleDto;
import com.demo.Dto.RoleResourceDto;
import com.demo.Dto.UserRoleDto;
import com.demo.models.AuthenticationRequest;
import com.demo.models.AuthenticationResponse;
import com.demo.service.AccessService;

@RestController
public class AccessController {

	@Autowired
	private AccessService accessService;

	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> createAuthenticationToken(
			@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
		return accessService.createAuthenticationToken(authenticationRequest);
	}

	@PostMapping("/access/role")
	public void addRole(@RequestBody RoleDto roleDto) {
		accessService.addRole(roleDto);
	}

	@PostMapping("/access/resource")
	public void addResource(@RequestBody ResourceDto resourceDto) {
		accessService.addResource(resourceDto);
	}

	@PostMapping("/access/roleofresource")
	public void assignResourceToRole(@RequestBody RoleResourceDto roleResourceDto) {
		accessService.assignResourceToRole(roleResourceDto);
	}

	@PostMapping("/access/userrole")
	public void assignRoleToUser(@RequestBody UserRoleDto userRoleDto) {
		accessService.assignRoleToUser(userRoleDto);
	}

}
