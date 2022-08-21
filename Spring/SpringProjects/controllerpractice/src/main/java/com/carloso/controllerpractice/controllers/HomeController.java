package com.carloso.controllerpractice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
//	@RequestMapping("/")
//	public String index(Model pizza) {
//		pizza.addAttribute("Toppings", "Pepperoni and mushroom");
//		return "index.jsp";
//	}
	
//	@RequestMapping("/")
//	public String index(Model model) {
//		model.addAttribute("fruit", "banana");
//		return "index.jsp";
//	}
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("dojoName", "Burbank");
		return "index.jsp";
	}
}
