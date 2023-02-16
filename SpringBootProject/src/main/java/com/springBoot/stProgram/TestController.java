package com.springBoot.stProgram;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//@Controller
@ResponseBody
public class TestController 
{
	@RequestMapping("/test")
	public String firstHandler()
	{
		
	   return "This is my 1st handler";
	}

}
