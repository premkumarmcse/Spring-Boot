package com.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Employee;
import com.demo.exception.ResourceNotFoundException;
import com.demo.models.AuthenticationRequest;
import com.demo.service.EmployeeService;

import io.swagger.annotations.ApiOperation;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {
		return employeeService.createAuthenticationToken(authenticationRequest);
	}

	@GetMapping("/employees/")
	@ApiOperation(value = "Finds All Employees")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@GetMapping("/employees/{employeeId}")
	@ApiOperation(value = "Finds Employee by id")
	public ResponseEntity<Employee> getEmployee(@PathVariable Long employeeId) throws ResourceNotFoundException {
		return employeeService.getEmployee(employeeId);
	}

	@PostMapping("/employees/")
	@ApiOperation(value = "Creates an Employee")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeService.createEmployee(employee);
	}

	@PutMapping("/employees/{employeeId}")
	@ApiOperation(value = "Updates Employee Details by id")
	public ResponseEntity<Employee> UpdateEmployee(@RequestBody Employee employee, @PathVariable Long employeeId)
			throws ResourceNotFoundException {
		return employeeService.UpdateEmployee(employee, employeeId);
	}

	@DeleteMapping("/employees/{employeeId}")
	@ApiOperation(value = "Deletes Employee by id")
	public Map<String, Boolean> deleteEmployee(@PathVariable Long employeeId) throws ResourceNotFoundException {
		return employeeService.deleteEmployee(employeeId);
	}

}
