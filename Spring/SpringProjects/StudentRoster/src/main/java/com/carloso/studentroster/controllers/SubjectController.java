package com.carloso.studentroster.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.carloso.studentroster.models.Subject;
import com.carloso.studentroster.services.SubjectService;

@Controller
@RequestMapping("/classes")
public class SubjectController {
	
	// SERVICES
	
	@Autowired
	private SubjectService subjectService;
	
	// GET METHODS
	
	@GetMapping("")
	public String showClasses(Model model) {
		model.addAttribute("classes", subjectService.allSubjects());
		return "showClasses.jsp";
	}
	
	@GetMapping("/new")
	public String subjectForm(Model model, @ModelAttribute("subject") Subject subject) {
		return "classForm.jsp";
	}
	
	@GetMapping("/{id}")
	public String showStudentsInClass(@PathVariable("id") Long id, Model model) {
		model.addAttribute("subject", subjectService.findSubject(id));
		return "classStudents.jsp";
	}
	
	// POST METHODS
	
	@PostMapping("/new")
	public String createSubject(Model model, @Valid @ModelAttribute("subject") Subject subject, BindingResult result) {
		if (result.hasErrors()) {
			return "classForm.jsp";
		} else {
			subjectService.createSubject(subject);
			return "redirect:/classes";
		}
	}

	
	
}
