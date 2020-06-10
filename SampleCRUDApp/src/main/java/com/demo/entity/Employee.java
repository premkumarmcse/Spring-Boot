package com.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "employees")
@ApiModel(description = "Details about the Employee")
public class Employee {

	private long employeeId;
	@ApiModelProperty(notes = "The employee's first name")
	private String firstName;
	
	@ApiModelProperty(notes = "The employee's last name")
	private String lastName;
	
	@ApiModelProperty(notes = "The employee's email address")
	private String emailId;

	public Employee() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", emailId=" + emailId + "]";
	}
}
