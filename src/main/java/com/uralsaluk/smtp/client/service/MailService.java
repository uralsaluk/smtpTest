package com.uralsaluk.smtp.client.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.mail.MessagingException;

public interface MailService {
	
	void sendmail () throws MessagingException, FileNotFoundException, IOException;

}
