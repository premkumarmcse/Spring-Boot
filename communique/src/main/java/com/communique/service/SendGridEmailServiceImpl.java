package com.communique.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.communique.entity.EmailLimits;
import com.communique.entity.User;
import com.communique.repository.EmailLimitsRepository;
import com.communique.repository.UserRepository;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

@Service
public class SendGridEmailServiceImpl implements SendGridEmailService{
    
	long consumedEmailCount = 0;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private EmailLimitsRepository emailLimitsRepository;
	
    final private String sendGridApi = "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";
    
    @Override
    public void sendHTML(String username, String from, String to, String subject, String body) {

    	if(emailLimitValidation(username)) {
    		Response response = sendEmail(from, to, subject, new Content("text/html", body));
            if(response != null) {
            	System.out.println("Email sent successfully !!" + "Status Code: " + response.getStatusCode() + ", Body: " + response.getBody() + ", Headers: "
                        + response.getHeaders());
            } else {
            	System.out.println("Failed to send mail! ");
            }
    	}
    }
    
    private Response sendEmail(String from, String to, String subject, Content content) {
    	SendGrid sg = new SendGrid(sendGridApi);
        sg.addRequestHeader("X-Mock", "true");
        
        Mail mail = new Mail(new Email(from), subject, new Email(to), content);
        mail.setReplyTo(new Email("no-reply@communique.com"));

        Request request = new Request();
        Response response = null;
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            response = sg.api(request);
        } catch (IOException ex) {
        	ex.printStackTrace();
        }
        return response;
    }

	@Override
	public Response sendBulkEmail(String username, String from, String to, String subject, String body) {
		
		String[] strArray = to.split(";");
		
		List<String> groupEmailId = Arrays.asList(strArray);
		
		Content content = new Content("text/html", body);
		Mail mail = new Mail(new Email(from), subject, new Email(to), content);
		mail.setReplyTo(new Email("no-reply@communique.com"));
		
		for(int i=0; i < groupEmailId.size(); i++) {
			if(groupEmailId.get(i)!=null && groupEmailId.get(i).trim()!=null) {
				Email additional_email = new Email();
				additional_email.setName("");
				additional_email.setEmail(groupEmailId.get(i));
				mail.personalization.get(0).addTo(additional_email);
			}
		}
		
		SendGrid sg = new SendGrid(sendGridApi);
	    Request request = new Request();
	    Response response = null;
	    try {
	      request.setMethod(Method.POST);
	      request.setEndpoint("mail/send");
	      request.setBody(mail.build());
	      System.out.println(mail.build());
	      response = sg.api(request);
	      if(response != null) {
	        	System.out.println("Email sent successfully !!" + "Status Code: " + response.getStatusCode() + ", Body: " + response.getBody() + ", Headers: "
	                    + response.getHeaders());
	      } else {
	        	System.out.println("Failed to send mail! ");
	      }
	    } catch (IOException ex) {
	    	ex.printStackTrace();
	    }
		
		return response;
	}
	
	public String updateEmailLimits(String username, long newMaxLimit) {		
		User userDetails = userRepository.findByUserName(username).get();
		if(userDetails.getRoles().equalsIgnoreCase("ADMIN")){
			EmailLimits emailLimits = emailLimitsRepository.findByUserName(username);
			long prevConsumedLimit = emailLimits.getMaxEmailLimit() - emailLimits.getRemainingEmailLimit();
			emailLimits.setMaxEmailLimit(newMaxLimit);
			emailLimits.setRemainingEmailLimit(emailLimits.getMaxEmailLimit() - prevConsumedLimit);
			emailLimitsRepository.save(emailLimits);
			return "Email Limits Successfully Changed";
		}
		return "Access Denied - User not an Admin";
	}
	
	public boolean emailLimitValidation(String username) {
		EmailLimits emailLimits = emailLimitsRepository.findByUserName(username);
		if(emailLimits.getRemainingEmailLimit() >= emailLimits.getMaxEmailLimit()) {
			return true;
		}
		return false;
	}
	
	public boolean updateConsumedEmailLimits(String username, long consumedEmailCount) {
		EmailLimits emailLimits = emailLimitsRepository.findByUserName(username);
		if((emailLimits.getRemainingEmailLimit() - consumedEmailCount) > 0) {
			emailLimits.setRemainingEmailLimit(emailLimits.getRemainingEmailLimit() - consumedEmailCount);
			return true;
		}
		return false;
	}
}
