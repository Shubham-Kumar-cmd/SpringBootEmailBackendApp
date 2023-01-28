package com.spring.mvc.service;

import com.spring.mvc.model.EmailRequest;

public interface EmailService {
	
	boolean sendEmail(EmailRequest email);
}
