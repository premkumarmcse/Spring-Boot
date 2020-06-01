package com.communique.service;

import com.sendgrid.Response;

public interface SendGridEmailService {
    void sendText(String from, String to, String subject, String body);
    void sendHTML(String username, String from, String to, String subject, String body);
    Response sendBulkEmail(String from, String to, String subject, String body);
}
