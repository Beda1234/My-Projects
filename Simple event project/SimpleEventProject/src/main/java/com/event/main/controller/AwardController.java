package com.event.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.event.main.domain.Award;

import com.event.main.services.AwardService;


@Controller
public class AwardController {
	@Autowired
	private AwardService servicee;
	 
    @GetMapping("/home")
    public String viewHomePage(Model model) {
    	List<Award> listaward = servicee.listAll();
        model.addAttribute("listaward", listaward);  
        
        return "index";
    }
 
    @GetMapping("/newaward")
    public String addaward(Model model) {
    	model.addAttribute("award",new Award());
    	return "newaward";
    }
   
    @RequestMapping(value = "/saveee", method = RequestMethod.POST)
    public String saveAward(@ModelAttribute("award") Award std){
    	servicee.save(std);
    	return "redirect:/";
    }
 
    @RequestMapping("/edittt/{id}")
    public ModelAndView showEditAwardPage(@PathVariable(name = "id") int id) {
        ModelAndView mavv = new ModelAndView("newaward");
        Award awd = servicee.get(id);
        mavv.addObject("award", awd);
        return mavv;
        
    }
    @RequestMapping("/deleteee/{id}")
    public String deleteevent(@PathVariable(name = "id") int id) {
        servicee.delete(id);
        return "redirect:/";
    }

}
