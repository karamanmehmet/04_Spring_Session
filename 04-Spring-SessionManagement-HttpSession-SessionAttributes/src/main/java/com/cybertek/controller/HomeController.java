package com.cybertek.controller;

import java.util.Stack;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cybertek.model.VisitedPagePojo;

@Controller
@RequestMapping("/")
@SessionAttributes("visitorPojo")
public class HomeController {


	
	@GetMapping("index")
	public String index(Model model, @ModelAttribute("visitorPojo") VisitedPagePojo visitorPojo) {

		Stack<String> visitedPages = visitorPojo.getPages();

		if (visitedPages == null) {
			visitedPages = new Stack<>();
		}
		visitedPages.push("--> index");

		visitorPojo.setPages(visitedPages);
		
		model.addAttribute("visitor", visitorPojo);

		return "index";
	}

	@GetMapping("clearSession")
	public String clearSession(@ModelAttribute("visitorPojo") VisitedPagePojo visitorPojo, Model model) {



			visitorPojo.setPages(new Stack<String>());
			
			model.addAttribute("visitor", visitorPojo);

		return "index";
	}
	
	
	 @ModelAttribute("visitorPojo")
	 public VisitedPagePojo visitedPagePojo() {
	  return new VisitedPagePojo();
	 }
}
