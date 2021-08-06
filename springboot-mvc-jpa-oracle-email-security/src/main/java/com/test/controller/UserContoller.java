package com.test.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.model.Role;
import com.test.model.User;
import com.test.repository.UserRespositry;

@Controller
@RequestMapping("/user")
public class UserContoller {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRespositry res;
	
	@RequestMapping("/home")
	public String home() {
		
		return "home";
	}
	
	
	@RequestMapping("/signup")
	public String form(Model model) {
		
		model.addAttribute("user",new User());
		return "signup";
	}
	
	
	@RequestMapping(value="/usersave" ,method = RequestMethod.POST)
	public String save(@ModelAttribute User user) {
		
	user.setRole("ROLE_ADMIN");
	user.setPassword(passwordEncoder.encode(user.getPassword()));
		
     res.save(user);
		
		System.out.println(user);
		return "signup";
	}
	
	
	
	
}
