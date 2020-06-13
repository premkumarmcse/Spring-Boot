package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Dto.ResourceDto;
import com.demo.Dto.RoleDto;
import com.demo.Dto.RoleResourceDto;
import com.demo.Dto.UserRoleDto;
import com.demo.entity.Resource;
import com.demo.entity.Role;
import com.demo.entity.RoleResource;
import com.demo.entity.UserRole;
import com.demo.repository.ResourceRepo;
import com.demo.repository.RolesRepo;
import com.demo.repository.RolesResourceRepo;
import com.demo.repository.UserRoleRepo;

@Service
public class AccessService {

	@Autowired
	private RolesRepo rolesRepo;

	@Autowired
	private ResourceRepo resourceRepo;

	@Autowired
	private RolesResourceRepo rolesResourceRepo;

	@Autowired
	private UserRoleRepo userRoleRepo;

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
