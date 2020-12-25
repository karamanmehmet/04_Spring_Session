package com.cybertek.controller;

import java.util.Stack;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

	@GetMapping("index")
	public String index(Model model, HttpServletRequest request) {

		Stack<String> visitedPages = (Stack<String>) request.getSession().getAttribute("VISITOR_SESSION");

		if (visitedPages == null) {
			visitedPages = new Stack<>();
		}
		visitedPages.push("--> index");

		request.getSession().setAttribute("VISITOR_SESSION", visitedPages);
		
		 model.addAttribute("VISITOR_SESSION", visitedPages);
		return "index";
	}

	@GetMapping("clearSession")
	public String clearSession(HttpServletRequest request) {

		request.getSession().invalidate();
		return "index";
	}

}
