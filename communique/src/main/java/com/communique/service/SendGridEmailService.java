package com.communique.service;

import com.sendgrid.Response;

public interface SendGridEmailService {
    void sendHTML(String username, String from, String to, String subject, String body);
    Response sendBulkEmail(String username, String from, String to, String subject, String body);
    String updateEmailLimits(String username, long newMaxLimit);
}
