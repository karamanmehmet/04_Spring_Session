package com.cybertek.controller;

import java.util.Stack;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cybertek.bean.VisitedPageBean;

@Controller
@RequestMapping("management")
public class ManagementController {

	@Autowired
	VisitedPageBean visitedPageBean;
	
	@GetMapping("index")
	public String index(Model model) {

		Stack<String> visitedPages = visitedPageBean.getPages();

		if (visitedPages == null) {
			visitedPages = new Stack<>();
		}
		visitedPages.push("--> management");

		visitedPageBean.setPages(visitedPages);
		
		model.addAttribute("visitor", visitedPageBean);

		return "management/index";
	}
}
