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
import org.springframework.web.bind.annotation.RequestParam;

import com.carloso.studentroster.models.Dorm;
import com.carloso.studentroster.models.Student;
import com.carloso.studentroster.services.DormService;
import com.carloso.studentroster.services.StudentService;

@Controller
@RequestMapping("/dorms")
public class DormController {

	// SERVICES
	
	@Autowired
	private DormService dormService;
	
	@Autowired
	private StudentService studentService;
	
	// GET METHODS
	
	@GetMapping("")
	public String showDorms(Model model) {
		model.addAttribute("dorms", dormService.allDorms());
		return "showDorms.jsp";
	}
	
	@GetMapping("/new")
	public String dormForm(@ModelAttribute("dorm") Dorm dorm) {
		return "dormForm.jsp";
	}
	
	@GetMapping("/{id}")
	public String showStudentsByDorm(@PathVariable("id") Long id, Model model, @ModelAttribute("student") Student student) {
		model.addAttribute("allStudents", studentService.allStudents());
		model.addAttribute("dormStudents", studentService.allStudentsByDormId(id));
		model.addAttribute("dorm", dormService.findDorm(id));
		return "showStudents.jsp";
	}
	
	// POST METHODS
	
	@PostMapping("/new")
	public String createDorm(@Valid @ModelAttribute("dorm") Dorm dorm, BindingResult results) {
		if (results.hasErrors()) {
			return "dormForm.jsp";
		} else {
			dormService.createDorm(dorm);
			return "redirect:/dorms";
		}
	}
	
	@PostMapping("/{id}")
	public String addStudentToDorm(@PathVariable("id") Long id, @RequestParam(value="studentId", required=false) Long studentID) {
		Student student = studentService.findStudent(studentID);
		studentService.addToDorm(student, dormService.findDorm(id));
		return "redirect:/dorms/{id}";
	}
}

