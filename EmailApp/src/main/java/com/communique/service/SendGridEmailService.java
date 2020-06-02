package com.communique.service;

import com.communique.model.EmailRequest;

public interface SendGridEmailService {
	String sendHTML(EmailRequest emailRequest);
	String sendBulkEmail(EmailRequest emailRequest);
    String updateEmailLimits(String username, long newMaxLimit);
}
