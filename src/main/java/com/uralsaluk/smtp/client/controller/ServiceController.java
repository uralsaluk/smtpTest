package com.uralsaluk.smtp.client.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uralsaluk.smtp.client.service.MailService;
import com.uralsaluk.smtp.client.service.NewMailService;
import com.uralsaluk.smtp.client.service.model.RequestDTO;

@RestController
@RequestMapping("/mailer")
@CrossOrigin(origins = "http://localhost:8080",allowedHeaders = "*" ,exposedHeaders="X-CSRF-TOKEN")
public class ServiceController {
	
	
	@Autowired
	NewMailService mailService;
	
	
	@RequestMapping(value = "sendMail",method= {RequestMethod.POST,RequestMethod.OPTIONS})
	public void sendMail(@RequestBody RequestDTO request ) {
		
		try {
			mailService.sendmail();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
