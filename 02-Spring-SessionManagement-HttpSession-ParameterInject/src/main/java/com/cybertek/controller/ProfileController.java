package com.cybertek.controller;

import java.util.Stack;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("profile")
public class ProfileController {


	
    @GetMapping("index")
    public String index(HttpSession httpSession){
    	
		Stack<String> visitedPages = (Stack<String>) httpSession.getAttribute("visitedPages");

		if (visitedPages == null) {
			visitedPages = new Stack<>();
		}
		visitedPages.push("--> profile");

		httpSession.setAttribute("visitedPages", visitedPages);
		
        return "profile/index";
    }
}
