package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.test.email.EmailUtil;
import com.test.model.Product;
import com.test.serviceimpl.ProductService;

@Controller
@RequestMapping("/admin")
public class ProductController {
	
	@Autowired
	private EmailUtil util;

	@Autowired
	private ProductService service;
	
	
	
	@RequestMapping("/register")
	public String reg(Model model ) {
		
		model.addAttribute("product",new Product());
		
		return "register";
	}
	
	//2.save
	
	@RequestMapping(value = "/adminsave",method =RequestMethod.POST )
	public String save(@ModelAttribute("product") Product product,@RequestParam MultipartFile fileOb,Model  model) {
		
		service.save(product);
		
		util.send(product.getEmail(), "Product added", "Hello User", fileOb);
		
	   model.addAttribute("msg","saved successfully");
		return "redirect:/admin/all";
		
	}
	
	//3.list
	@RequestMapping("/all")
	public String detials(Model model) {
		
		List<Product>list = service.findAll();
		model.addAttribute("lists", list);
		
		return "all-products";
	}
	
	//4.delete 
	 @RequestMapping(value="/delete/{id}",method = RequestMethod.GET)    
	    public String delete(@PathVariable("id") int id){    
	       service.delete(id);    
	        return "redirect:/admin/all"; 
	 }
	//5.getByid
	@RequestMapping(value = "/edit/{id}",method = RequestMethod.GET )
	public String id(@PathVariable int id, Model model) {
		Product product = service.findById(id);
	
		model.addAttribute("prod",product);
		
		return "edit-form";
	}
	//6.update
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public String update(@ModelAttribute("product") Product product) {
		
		service.update(product);
		
		return "redirect:/admin/all";
		
	}
	
}
