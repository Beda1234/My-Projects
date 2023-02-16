package com.event.main.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.event.main.dao.UserRepository;
import com.event.main.entitiees.Event;
import com.event.main.entitiees.User;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@ModelAttribute        // This is help full for access the data all over the file(Helping to adding common data as a response)
	public void addComonData(Model model,Principal principal)
	{
        String userName=principal.getName();
		
		System.out.println("USERNAME  "+userName);
		
		//Get the user using username (username is Email)
		
		User user=userRepository.getUserByUserName(userName);
		
		System.out.println("USER  "+user);
		 
		model.addAttribute("user",user);
	}
	
	@RequestMapping("/index")
	public String dashboard(Model model,Principal principal)
	{
		model.addAttribute("title","This is my User dashboard ");
		return "normal/user_dashboard";
	}
	//Open add event handler
	@GetMapping("/add-event")
	public String openAddEventForm(Model model) 
	{
		model.addAttribute("title","This is my add contect form");
		model.addAttribute("event",new Event());
		return "normal/add_event_form";
	}

}
