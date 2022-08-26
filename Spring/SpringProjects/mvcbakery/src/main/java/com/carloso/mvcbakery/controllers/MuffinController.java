package com.carloso.mvcbakery.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.carloso.mvcbakery.models.Muffin;
import com.carloso.mvcbakery.services.MuffinService;

@Controller
public class MuffinController {

	@Autowired
	MuffinService muffinService;
	
	@GetMapping("/")
	public String index(@ModelAttribute("muffin") Muffin muffin, Model model) {
		List <Muffin> allTheMuffins = muffinService.allMuffins();
		model.addAttribute("muffins", allTheMuffins);
		return "index.jsp";
	}
	
	@PostMapping("/muffin/create")
	public String createMuffin(@Valid @ModelAttribute("muffin") Muffin muffin, BindingResult result) {
		if (result.hasErrors()) {
			return "index.jsp";
		} else {
			muffinService.createMuffin(muffin);
			return "redirect:/";
		}
	}
	
	@GetMapping("/muffin/{id}/edit")
	public String editMuffin(
			@PathVariable("id") Long id,
			Model model
			) {
        Muffin muffin = muffinService.findMuffin(id);
        model.addAttribute("muffin", muffin);
		return "editMuffin.jsp";
	}
	
	@PutMapping("/muffin/{id}/update")
	public String updateMuffin(@Valid @ModelAttribute("muffin") Muffin muffin, BindingResult result) {
		if(result.hasErrors()) {
			return "editMuffin.jsp";
		} else {
			muffinService.updateMuffin(muffin);
			return "redirect:/";
		}
	}
	
	@DeleteMapping("/muffin/{id}/delete")
	public String delete(@PathVariable("id") Long id) {
		muffinService.deleteMuffin(id);
		return "redirect:/";
	}
}
