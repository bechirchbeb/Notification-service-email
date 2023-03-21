package org.sid.service.impl;

import org.sid.service.EmailSenderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Configuration
 class Config {

    @Bean
    public JavaMailSender javaMailSender() {
        return new JavaMailSenderImpl();
    }

}

@Service
public class EmailSenderimpl implements EmailSenderService {
	
	private final JavaMailSender mailSender;
   public  EmailSenderimpl(JavaMailSender mailSender)
   {
	   this.mailSender=mailSender;
   }

	
     
	@Override
	public void sendEmail(String to, String subject, String text) {
		// TODO Auto-generated method stub
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom("bechirchbeb168@gmail.com");
		simpleMailMessage.setTo(to);
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(text);
		this.mailSender.send(simpleMailMessage);
		
	}

}
