package com.carloso.loginandregistration.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.carloso.loginandregistration.models.LoginUser;
import com.carloso.loginandregistration.models.User;
import com.carloso.loginandregistration.services.UserService;

@Controller
public class HomeController {
 
	@Autowired
	private UserService userService;
 
	@GetMapping("/")
		public String index(Model model) {
		// Bind empty User and LoginUser objects to the JSP to capture the form input
	     model.addAttribute("newUser", new User());
	     model.addAttribute("newLogin", new LoginUser());
	     return "index.jsp";
	}
	
	@GetMapping("/home")
	public String home(HttpSession session, Model model) {
		// If no userId is found, redirect to logout
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		// We get the userId from our session (we need to cast the result to a Long as the 'session.getAttribute("userId")' returns an object
		Long userId = (Long) session.getAttribute("userId");
		model.addAttribute("user", userService.findById(userId));
		// created user to obtain string user name and show capitalized name on welcome
		User user = (User) model.getAttribute("user");
		String name = user.getUsername().substring(0, 1).toUpperCase() + user.getUsername().substring(1);
		model.addAttribute("name", name);
	    return "home.jsp";  
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		// Set userId to null and redirect to login/register page
		session.setAttribute("userId", null);
	    return "redirect:/";
	}
 
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
		User user = userService.register(newUser, result);
		if(result.hasErrors()) {
			// Be sure to send in the empty LoginUser before re-rendering the page.
			model.addAttribute("newLogin", new LoginUser());
			return "index.jsp";
		} else {
			session.setAttribute("userId", user.getId()); 
			return "redirect:/home";
		}
	}
 
	 @PostMapping("/login")
	 public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
		 User user = userService.login(newLogin, result);
	     if(result.hasErrors() || user==null) {
	         model.addAttribute("newUser", new User());
	         return "index.jsp";
	     } else {
	    	 session.setAttribute("userId", user.getId());
	    	 return "redirect:/home";
	     }     
	 }
 
}

