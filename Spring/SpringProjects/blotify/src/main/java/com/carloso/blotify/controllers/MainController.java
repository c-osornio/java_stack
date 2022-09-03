package com.carloso.blotify.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.carloso.blotify.models.LoginUser;
import com.carloso.blotify.models.User;
import com.carloso.blotify.services.UserService;

@Controller
public class MainController {
	
	@Autowired
	UserService userService;

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("loginUser", new LoginUser());
		return "index.jsp";
	}
	
	@PostMapping("/register")
	public String register(Model model, @Valid @ModelAttribute("newUser") User newUser, BindingResult results, HttpSession session) {
		User loggedUser = userService.register(newUser, results);
		if (results.hasErrors()) {
			model.addAttribute("loginUser", new LoginUser());
			return "index.jsp";
		} else {
			session.setAttribute("userId", loggedUser.getId());
			return "redirect:/home";
		}
	}
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("loginUser") LoginUser loginUser, BindingResult results, HttpSession session, Model model) {
		User loggedUser = userService.findUserByEmail(loginUser, results);
		if (results.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "index.jsp";
		} else {
			session.setAttribute("userId", loggedUser.getId());
			return "redirect:/home";
		}
	}
	
	@GetMapping("/home")
	public String home(HttpSession session, Model model) {
		Long id = (Long) session.getAttribute("userId");
		model.addAttribute("user", userService.findUserById(id));
		return "home.jsp";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("userId");
		//  session.invalidate() would clear all things in session 
		return "redirect:/";
	}
}
