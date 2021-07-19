package com.test.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.log.UserDataHelper.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.dao.ProductDao;
import com.test.model.Product;

@Controller
public class MainController {

	@Autowired
	private ProductDao productDao;
	
	
	@RequestMapping("/")
	public String home(Model model)
	{
	 List<Product> products  =	productDao.getProducts();
	
	  model.addAttribute("products",products);
	 
		return "index";
	}
	
	//insert 
	
	@RequestMapping("add-product")
	public String addProduct(Model model) {
		
		model.addAttribute("title","Add Product");
		return"add_product_form";
	}
	
	//handle product form
	
	@RequestMapping(value = "/handle-product",method = RequestMethod.POST)
	public String handleProduct(@ModelAttribute("product") Product product) {
		
		System.out.println(product);
		
		productDao.createProduct(product);
		
		return "redirect:/";
	}
	
//handle delete	
	@RequestMapping("/delete-product/{productId}")
	public String delete(@PathVariable("productId") int productId) {
		
		productDao.deleteProduct(productId);
		
		
		return "redirect:/";
	}
	
	@RequestMapping("/update/{productId}")
	public String update(@PathVariable("productId") int pid,Model model) {
		
		 Product product=productDao.getProductId(pid);
		
		 model.addAttribute("product",product);
		return "update-form";
	}
	
	
	
}
