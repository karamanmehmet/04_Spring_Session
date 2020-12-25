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
@RequestMapping("admin")
@SessionAttributes("visitorPojo")
public class AdminController {

	
	@GetMapping("index")
	public String index(@ModelAttribute("visitorPojo") VisitedPagePojo visitorPojo, Model model) {

		Stack<String> visitedPages = visitorPojo.getPages();

		if (visitedPages == null) {
			visitedPages = new Stack<>();
		}
		visitedPages.push("--> admin");

		visitorPojo.setPages(visitedPages);
		
		model.addAttribute("visitor", visitorPojo);

		return "admin/index";
	}
}
