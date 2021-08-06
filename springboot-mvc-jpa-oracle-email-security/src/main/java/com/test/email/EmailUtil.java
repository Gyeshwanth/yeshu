package com.test.email;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class EmailUtil {

	@Autowired
	private JavaMailSender javaMailSender;
	
	public boolean send(String to,String subject,String text,MultipartFile file)
	{
	 boolean flag=false;
	 
	 try {
		 
		 MimeMessage message = javaMailSender.createMimeMessage();
		 
		 MimeMessageHelper h = new MimeMessageHelper(message, file!=null?true:false);
	          h.setTo(to);
		       h.setSubject(subject);
		       h.setText(text);
	           h.setFrom("yeshu96183@gmail.com");
	 
	           if(file!=null) 
	        	   h.addAttachment(file.getOriginalFilename(),file);
	         javaMailSender.send(message);
	 flag=true;
	 }
	 catch (Exception e) {
		e.printStackTrace();
		flag=false;
	}
	return flag;
	 
		 
		
		
	}
	
	
}
