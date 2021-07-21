package com.test;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class App {

	public static void main(String[] args) {
		//System.out.println("done");
	
	String message ="hello,this springmail module";
	String subject="spring heloo************ ";
	String to ="ycr96183@gmail.com";
	String from ="yeshu96183@gmail.com";
	
	
	sendEmail(message,subject,to,from);
	
	}
//this method send email
	private static void sendEmail(String message, String subject, String to, String from) {
		
		//variable for gmail
		String host ="smtp.gmail.com";
	
		//get the  system properties
		
		Properties properties =System.getProperties();
	   System.out.println("properties"+properties);	
		//important properties
	   properties.put("mail.smtp.host", host);
	   properties.put("mail.smtp.port", "465");
	   properties.put("mail.smtp.ssl.enable", "true");
	   properties.put("mail.smtp.auth", "true");

	   //session object
	        Session session= Session.getInstance(properties,new  Authenticator() {

		@Override
		protected PasswordAuthentication getPasswordAuthentication() {
			
			return new PasswordAuthentication("yeshu96183@gmail.com", "yeshu@1999");
		}
	   });
	   session.setDebug(true);
	   //compose the message (text.image...)
	   
	  MimeMessage m = new MimeMessage(session);
	  try {
	  m.setFrom(from);
	   m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	   m.setSubject(subject);
	   m.setText(message);

	   //sender message by transport class
	   Transport.send(m);

	   System.out.println("success done....");
	  }catch (Exception e) {
		e.printStackTrace();
	}
	}
}
