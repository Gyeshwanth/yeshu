package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.powermock.api.mockito.PowerMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.test.daoI.ProductDao;
import com.test.model.Product;
import com.test.serviceimpl.ProductService;

@SpringBootTest
class SpringbootMvcJpaOracleApplicationTests {

	
	
//
//	@Test
//	public void testSaveProduct() {
//		
//		Product product = new Product(1,"yuns12","cell",123654,"5%","good","yeshu96183@gmail.com");
//		
//		ProductDao mockDao = PowerMockito.mock(ProductDao.class);
//		
//		PowerMockito.doReturn(product).when(mockDao).save(product);
//		
//		ProductService productService = new ProductService(mockDao); 
//     
//      assertEquals(product, productService);
//	
//	}

	
	
	
	
	
	
	
	@Disabled
	void contextLoads() {
	System.setProperty("webdriver.chrome.driver", "E:/seleniumdriver92version/chromedriver.exe");

	WebDriver driver = new ChromeDriver();
	driver.get("http://localhost:2021/user/home");
	driver.manage().window().maximize();
	driver.findElement(By.linkText("Signup")).click();
	
	}

}
