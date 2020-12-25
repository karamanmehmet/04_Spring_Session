package com.cybertek.model;

import java.io.Serializable;
import java.util.Stack;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;


public class VisitedPagePojo {
	
	
	private Stack<String> pages;

	public Stack<String> getPages() {
		return pages;
	}

	public void setPages(Stack<String> pages) {
		this.pages = pages;
	}


	
	
	

}
