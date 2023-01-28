package com.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mvc.model.EmailRequest;
import com.spring.mvc.model.EmailResponse;
import com.spring.mvc.service.EmailService;

@RestController
@CrossOrigin
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	
	@PostMapping("welcome")
	public String welcome() {
		return "this is testing purpose only";
	}
	
	//api to send email
	@PostMapping("/sendemail")
	public ResponseEntity<?> sendEmail(@RequestBody EmailRequest request){
		System.out.println(request);
		boolean flag=emailService.sendEmail(request);
		//return ResponseEntity.ok("Done");
		if(flag) {
			return ResponseEntity.ok(new EmailResponse("Email Send Successfully"));
		}else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new EmailResponse("Email not sent"));	
		}
		
	}
}
