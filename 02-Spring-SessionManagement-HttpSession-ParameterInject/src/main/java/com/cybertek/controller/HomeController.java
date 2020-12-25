package com.cybertek.controller;

import java.util.Stack;

import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")

public class HomeController {

	@GetMapping("index")
	public String index(HttpSession httpSession) {

		Stack<String> visitedPages = (Stack<String>) httpSession.getAttribute("visitedPages");

		if (visitedPages == null) {
			visitedPages = new Stack<>();
		}
		visitedPages.push("--> index");

		httpSession.setAttribute("visitedPages", visitedPages);

		return "index";
	}

	@GetMapping("clearSession")
	public String clearSession(HttpSession httpSession) {

		
		 httpSession.invalidate();
			
		    //   httpSession.removeAttribute("visitedPages");
		return "index";
	}
}
