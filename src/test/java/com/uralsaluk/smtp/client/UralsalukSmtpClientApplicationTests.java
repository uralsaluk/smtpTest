package com.uralsaluk.smtp.client;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.mail.MessagingException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.uralsaluk.smtp.client.service.MailService;
import com.uralsaluk.smtp.client.service.NewMailService;

@SpringBootTest
class UralsalukSmtpClientApplicationTests {
	
	@Autowired
	MailService mail;
	
	@Autowired
	NewMailService newMail;

	@Test
	void contextLoads() throws MessagingException, IOException {
		
		
		
		
		newMail.sendmail();
	}

}
