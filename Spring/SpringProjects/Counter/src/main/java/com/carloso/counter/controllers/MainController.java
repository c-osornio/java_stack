package com.carloso.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/your_server")
public class MainController {
	
	@RequestMapping("")
	public String index(HttpSession session) {
				
    	// If the count is not already in session
		if (session.getAttribute("count") == null) {
		// Use setAttribute to initialize the count in session
			session.setAttribute("count", 0);
		}
		else {
		// increment the count by 1 using getAttribute and setAttribute
			Integer currentCount = (Integer)session.getAttribute("count");
			currentCount++;
			session.setAttribute("count", currentCount);
		}
		return "index.jsp";
	}
	

	@RequestMapping("/counter")
	public String counter(HttpSession session, Model model) {
		Integer currentCount = 0;
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		} else {
			currentCount = (Integer)session.getAttribute("count");
		}
		model.addAttribute("countToShow", currentCount);
		return "counter.jsp";
	}
	
	@RequestMapping("/counterTwo")
	public String counterTwo(HttpSession session, Model model) {
		Integer currentCount = 0;
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", currentCount);
		}else {
			currentCount = (Integer) session.getAttribute("count");
			currentCount++;
			session.setAttribute("count", currentCount);
		}
		model.addAttribute("countToShow", currentCount);
		return "counterTwo.jsp";
	}
	
	@RequestMapping("/resetCounter")
	public String resetCounter(HttpSession session) {
		session.setAttribute("count", 0);
		return "redirect:/your_server/";
	}
	
}
