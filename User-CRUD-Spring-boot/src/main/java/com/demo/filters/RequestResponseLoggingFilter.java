package com.demo.filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

	Logger logger = LoggerFactory.getLogger(RequestResponseLoggingFilter.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		String requestParameter = null;

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();

		logger.info("Logging Request: " + req.getMethod() + "-" + req.getRequestURI());
		logger.info("Logging Response: " + res.getContentType());
		logger.info(currentPrincipalName);

		Enumeration<String> enumeration = request.getParameterNames();
		Map<String, Object> modelMap = new HashMap<>();
		while (enumeration.hasMoreElements()) {
			String parameterName = enumeration.nextElement();
			modelMap.put(parameterName, request.getParameter(parameterName));
		}

		for (String key : modelMap.keySet()) {
			logger.info(" Key : " + key);
			logger.info(" Value : " + (String) modelMap.get(key));
			requestParameter = (String) key;
			logger.info("Initial Value : " + requestParameter);
		}

		if (!SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")) {
			Optional<UserDto> user = userRepository.findByUsrNm(currentPrincipalName);
			user.orElseThrow(() -> new UsernameNotFoundException("Not found : " + currentPrincipalName));
			UserRole userRole = userRoleRepo.findById(user.get().getId());
			List<String> roleResource = new ArrayList<String>();

			roleResource = rolesResourceRepo.getListOfRoleResource(userRole.getRoleNm(), true);

			List<Resource> resourceList = new ArrayList<Resource>();
			resourceList = resourceRepo.getListOfResourceUrl(roleResource);

			if (resourceList.size() == 0) {
				((HttpServletResponse) response).sendError(HttpStatus.BAD_REQUEST.value(), "Invalid path");
			}
			for (int i = 0; i < resourceList.size(); i++) {
				if (requestParameter != null
						&& (req.getMethod().contains("GET") || req.getMethod().contains("DELETE"))) {
					requestParameter = req.getRequestURI() + "{" + requestParameter + "}";
					if (requestParameter.equals(resourceList.get(i).getUrl())) {
						logger.info("Updated Value : " + requestParameter);
						break;
					}
				}
				if (!resourceList.get(i).getActn().equals(req.getMethod())
						|| !resourceList.get(i).getUrl().equals(req.getRequestURI())) {
					if (i == resourceList.size() - 1) {
						((HttpServletResponse) response).sendError(HttpStatus.BAD_REQUEST.value(), "Invalid path");
					}
				} else {
					chain.doFilter(request, response);
					break;
				}
			}

			System.out.println(resourceList);
		} else {
			chain.doFilter(request, response);
		}

	}
}
