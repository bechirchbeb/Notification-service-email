package org.sid.controller;

import org.sid.resource.EmailMessage;
import org.sid.service.EmailSenderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class EmailSenderController {
	public EmailSenderController(EmailSenderService emailsendersercice) {
		super();
		this.emailsendersercice = emailsendersercice;
	}
	private final EmailSenderService emailsendersercice;
	@PostMapping("/send-email")
	public  ResponseEntity sendEmail(@RequestBody EmailMessage email) 
	{
		this.emailsendersercice.sendEmail(email.getTo(),email.getSubject(),email.getText());
		return ResponseEntity.ok("Success");
		
	}

}
