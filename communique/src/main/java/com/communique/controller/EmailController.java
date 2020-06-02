package com.communique.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.communique.model.EmailRequest;
import com.communique.service.SendGridEmailService;
import com.sendgrid.Response;

@RestController
public class EmailController {

	@Autowired
	SendGridEmailService sendGridEmailService;
	
	@GetMapping("/get")
	public String hello() {
		return ("<h1>Static home page...</h1>");
		
	}
	
	@PostMapping(value="/sendEmail")
	public void sendEmail(@RequestBody EmailRequest emailRequest) {
		sendGridEmailService.sendHTML(emailRequest.getUsername(), emailRequest.getFromAddress(), emailRequest.getToAddress(), emailRequest.getSubject(), emailRequest.getContent());
	}
	
	@PostMapping(value="/sendBulkEmail")
	public Response sendBulkEmail(@RequestBody EmailRequest emailRequest) {
		return sendGridEmailService.sendBulkEmail(emailRequest.getUsername(), emailRequest.getFromAddress(), emailRequest.getToAddress(), emailRequest.getSubject(), emailRequest.getContent());
	}
	
	@PutMapping(value="/updateEmailLimits")
	public String updateEmailLimits(@RequestParam String username, long newMaxLimit) {
		return sendGridEmailService.updateEmailLimits(username, newMaxLimit);
	}
}
