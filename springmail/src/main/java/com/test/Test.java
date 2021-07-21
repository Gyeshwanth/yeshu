package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class Test {
	public static void main(String[] args) {
		
	
	//ApplicationContext ac = new ClassPathXmlApplicationContext(Appconfig.class);
			ApplicationContext act = new AnnotationConfigApplicationContext(Appconfig.class);
			AppMailSender mail = act.getBean("appMailSender", AppMailSender.class);
			FileSystemResource file = new FileSystemResource("C:/Users/G YESHWANTH/Pictures/3.jpg");
			boolean flag = mail.sendEmail("ycr96183@gmail.com", "Hello", "Welcome To Spring Email", file);
			if(flag) {
			System.out.println("Done!!!");
			}else {
			System.out.println("Sorry!!!!");
			}
			}
}
