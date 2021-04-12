package com.test;

import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
public class Controller {

	@RequestMapping("/")
public String heelo()
{
		return "helloworld";
		}
@RequestMapping("/wel")
public String welcom()
{
	return "welcome";
	}
}

