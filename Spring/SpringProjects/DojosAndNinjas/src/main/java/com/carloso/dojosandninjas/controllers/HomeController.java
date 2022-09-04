package com.carloso.dojosandninjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.carloso.dojosandninjas.models.Dojo;
import com.carloso.dojosandninjas.models.Ninja;
import com.carloso.dojosandninjas.services.DojoService;
import com.carloso.dojosandninjas.services.NinjaService;

@Controller
public class HomeController {

	@Autowired
	DojoService dojoService;
	
	@Autowired
	NinjaService ninjaService;
	
	@GetMapping("/")
	public String home() {
		return "redirect:/dojos/new";
	}
	
	@GetMapping("/dojos/new")
	public String index(@ModelAttribute("dojo") Dojo dojo) {
		return "index.jsp";
	}
	
	@GetMapping("ninjas/new")
	public String ninjaForm(Model model, @ModelAttribute("ninja") Ninja ninja) {
		model.addAttribute("dojos", dojoService.allDojos());
		return "ninjaForm.jsp";
	}
	
	@GetMapping("/dojos/{id}")
	public String showDojo(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dojo", dojoService.findDojo(id));
		return "showDojo.jsp";
	}
	
	@PostMapping("/dojos/new")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult results) {
		if (results.hasErrors()) {
			return "index.jsp";
		} else {
			dojoService.createDojo(dojo);
			return "redirect:/ninjas/new";
		}
	}
	
	@PostMapping("/ninjas/new")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult results, Model model) {
		if (results.hasErrors()) {
			model.addAttribute("dojos", dojoService.allDojos());
			return "ninjaForm.jsp";
		} else {
			ninjaService.createNinja(ninja);
			return "redirect:/dojos/" + ninja.getDojo().getId();
		}
	}
}
