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
import com.event.main.domain.Event;
import com.event.main.services.EventService;
import com.event.main.services.AwardService;
@Controller
public class EventController {
	@Autowired
	private EventService service;
	 
	@Autowired
	private AwardService servicee;
    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<Event> listevent = service.listAll();
        model.addAttribute("listevent", listevent);
        List<Award> listaward = servicee.listAll();
        model.addAttribute("listaward", listaward); 
        
        return "index";
    }
 
    @GetMapping("/new")
    public String add(Model model) {
        model.addAttribute("event", new Event());
        return "new";
    }
 
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveEvent(@ModelAttribute("event") Event std) {
        service.save(std);
        return "redirect:/";
    }
 
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditEventPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("new");
        Event std = service.get(id);
        mav.addObject("event", std);
        return mav;
        
    }
    @RequestMapping("/delete/{id}")
    public String deleteevent(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/";
    }
}
