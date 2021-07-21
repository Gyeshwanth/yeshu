package com.test;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
@ComponentScan(basePackages = "com.test")
public class Appconfig {
	@Bean
	public JavaMailSenderImpl mail() {
	JavaMailSenderImpl mail = new JavaMailSenderImpl();
	mail.setHost("smtp.gmail.com");
	mail.setPort(465);
	mail.setUsername("yeshu96183@gmail.com");//enter you emailId.
	mail.setPassword("yeshu@1999");//enter ur password.
	mail.setJavaMailProperties(props());
	return mail;
	}
	private Properties props() {
	Properties p = new Properties();
	p.put("mail.smtp.auth", "true");
	p.put("mail.smtp.ssl.enable", "true");
	return p;
	}

}
