package com.uralsaluk.smtp.client.config;



import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableConfigurationProperties
@ConfigurationProperties("project-constants")
public class YAMLConfig {

		
	private String[] mailAddressTo;
	private String[] mailAdressForEba;
	public String[] getMailAddressTo() {
		return mailAddressTo;
	}
	public void setMailAddressTo(String[] mailAddressTo) {
		this.mailAddressTo = mailAddressTo;
	}
	public String[] getMailAdressForEba() {
		return mailAdressForEba;
	}
	public void setMailAdressForEba(String[] mailAdressForEba) {
		this.mailAdressForEba = mailAdressForEba;
	}
	public YAMLConfig(String[] mailAddressTo, String[] mailAdressForEba) {
		super();
		this.mailAddressTo = mailAddressTo;
		this.mailAdressForEba = mailAdressForEba;
	}
	
	
	
	
	


	
}
