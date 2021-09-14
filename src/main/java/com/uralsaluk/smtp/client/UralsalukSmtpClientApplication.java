package com.uralsaluk.smtp.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uralsaluk.smtp.client.service.MailService;

@SpringBootApplication
public class UralsalukSmtpClientApplication  {

	public static void main(String[] args) {
		SpringApplication.run(UralsalukSmtpClientApplication.class, args);
	}
	
	

}
