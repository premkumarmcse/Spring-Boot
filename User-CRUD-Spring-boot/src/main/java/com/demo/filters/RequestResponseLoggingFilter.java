package com.demo.filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.demo.Dto.UserDto;
import com.demo.entity.Resource;
import com.demo.entity.UserRole;
import com.demo.repository.ResourceRepo;
import com.demo.repository.RolesResourceRepo;
import com.demo.repository.UserRoleRepo;
import com.demo.repository.UserServiceRepo;

@Component
public class RequestResponseLoggingFilter implements Filter {

	@Autowired
	private UserServiceRepo userRepository;

	@Autowired
	private UserRoleRepo userRoleRepo;

	@Autowired
	private RolesResourceRepo rolesResourceRepo;

	@Autowired
	private ResourceRepo resourceRepo;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();

		System.out.println("Logging Request: " + req.getMethod() + "-" + req.getRequestURI());
		System.out.println("Logging Response: " + res.getContentType());
		System.out.println(currentPrincipalName);

		if (!SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")) {
			Optional<UserDto> user = userRepository.findByUsername(currentPrincipalName);
			user.orElseThrow(() -> new UsernameNotFoundException("Not found : " + currentPrincipalName));
			UserRole userRole = userRoleRepo.findByUserId(user.get().getId());
			List<Long> roleResource = new ArrayList<Long>();

			roleResource = rolesResourceRepo.getListOfRoleResource(userRole.getRoleId(), true);

			List<Resource> resourceList = new ArrayList<Resource>();
			resourceList = resourceRepo.getListOfResourceUrl(roleResource);

			if (resourceList.size() == 0) {
				((HttpServletResponse) response).sendError(HttpStatus.NOT_FOUND.value(), "Invalid path");
			}
			for (int i = 0; i < resourceList.size(); i++) {
				if (!resourceList.get(i).getAction().equals(req.getMethod())
						|| !resourceList.get(i).getUrl().equals(req.getRequestURI())) {
					if (i == resourceList.size() - 1) {
						((HttpServletResponse) response).sendError(HttpStatus.BAD_REQUEST.value(), "Invalid path");
					}
				} else {
					break;
				}
			}

			System.out.println(resourceList);
		}
		chain.doFilter(request, response);
	}
}
