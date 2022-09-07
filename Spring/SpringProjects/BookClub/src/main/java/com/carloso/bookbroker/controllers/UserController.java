package com.carloso.bookbroker.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.carloso.bookbroker.models.LoginUser;
import com.carloso.bookbroker.models.User;
import com.carloso.bookbroker.services.UserService;

@Controller
public class UserController {
 
	@Autowired
	private UserService userService;
 
	@GetMapping("/")
		public String index(Model model) {
		// Bind empty User and LoginUser objects to the JSP to capture the form input
	     model.addAttribute("newUser", new User());
	     model.addAttribute("newLogin", new LoginUser());
	     return "index.jsp";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		// Set userId to null and redirect to login/register page
		session.setAttribute("userId", null);
	    return "redirect:/";
	}

 
	 @PostMapping("/login")
	 public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
		 User user = userService.login(newLogin, result);
	     if(result.hasErrors() || user==null) {
	         model.addAttribute("newUser", new User());
	         return "index.jsp";
	     } else {
	    	 session.setAttribute("userId", user.getId());
	    	 return "redirect:/books";
	     }     
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
			return "redirect:/books";
		}
	}
 
}

