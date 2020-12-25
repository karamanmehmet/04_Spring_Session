package com.cybertek.controller;

import java.util.Stack;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("management")
public class ManagementController {

	@Autowired
	HttpSession httpSession;
	
    @GetMapping("index")
    public String index(){
    	
		Stack<String> visitedPages = (Stack<String>) httpSession.getAttribute("visitedPages");

		if (visitedPages == null) {
			visitedPages = new Stack<>();
		}
		visitedPages.push("--> management");

		httpSession.setAttribute("visitedPages", visitedPages);
    	
        return "management/index";
    }
}
