package com.carloso.omikujiform.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	@RequestMapping("/")
	public String index() {
		return "homepage.jsp";
	}
	
	@PostMapping("/processForm")
	public String processForm(
		HttpSession session,
		@RequestParam(value="number") int number,
		@RequestParam(value="city") String city,
		@RequestParam(value="person") String person,
		@RequestParam(value="hobby") String hobby,
		@RequestParam(value="thing") String thing,
		@RequestParam(value="somethingNice") String somethingNice) {
		String omikuji = String.format(
				"In %s years you will live in %s with %s as your roommate, %s. The next time you see a %s, you will have good luck. Also, %s.",
				number, city, person, hobby, thing, somethingNice);
		session.setAttribute("omikuji", omikuji);
		return "redirect:/omikuji/show";	
	}
	
	@RequestMapping("/omikuji/show")
	public String showOmikiji(Model model, HttpSession session) {
		String omikuji = (String) session.getAttribute("omikuji");
		model.addAttribute("omikuji", omikuji);
		return "fortune.jsp";
	}
		
}
