package com.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.demo.entity.Employee;
import com.demo.exception.ResourceNotFoundException;
import com.demo.models.AuthenticationRequest;
import com.demo.models.AuthenticationResponse;
import com.demo.repository.EmployeeRepo;
import com.demo.util.JwtUtil;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private MyUserDetailsService userDetailsService;

	@Autowired
	private JwtUtil jwtUtil;

	public ResponseEntity<?> createAuthenticationToken(AuthenticationRequest authenticationRequest) throws Exception {
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

	public List<Employee> getAllEmployees() {
		return employeeRepo.findAll();
	}

	public ResponseEntity<Employee> getEmployee(Long employeeId) throws ResourceNotFoundException {
		Employee employee = employeeRepo.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
		return ResponseEntity.ok().body(employee);
	}

	public Employee createEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}

	public ResponseEntity<Employee> UpdateEmployee(Employee employee, Long employeeId)
			throws ResourceNotFoundException {
		Employee entity = employeeRepo.findById(employee.getEmployeeId())
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
		entity.setFirstName(employee.getFirstName());
		entity.setLastName(employee.getLastName());
		entity.setEmailId(employee.getEmailId());
		final Employee updatedEmployee = employeeRepo.save(entity);
		return ResponseEntity.ok(updatedEmployee);
	}

	public Map<String, Boolean> deleteEmployee(Long employeeId) throws ResourceNotFoundException {
		Employee entity = employeeRepo.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
		employeeRepo.delete(entity);
		Map<String, Boolean> response = new HashMap<String, Boolean>();
		response.put("Employee Deleted", Boolean.TRUE);
		return response;
	}
}
