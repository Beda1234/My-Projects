package com.springBoot.stProgram.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController 
{
	@RequestMapping("/home")
	public String home() 
	{
		System.out.println("This is the home page ");
		return "home";
		
	}

}