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

import com.carloso.studentroster.models.Student;
import com.carloso.studentroster.services.DormService;
import com.carloso.studentroster.services.StudentService;
import com.carloso.studentroster.services.SubjectService;

@Controller
@RequestMapping("/students")
public class StudentController {

	// SERVICES 
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private DormService dormService;
	
	@Autowired
	private SubjectService subjectService;
	
	// GET METHODS
	
	@GetMapping("/new")
	public String studentForm(Model model, @ModelAttribute("student") Student student) {
		model.addAttribute("dorms", dormService.allDorms());
		return "studentForm.jsp";
	}
	
	@GetMapping("/remove/{id}")
	public String removeStudentFromDorm(@PathVariable("id") Long id) {
		Student student = studentService.findStudent(id);
		Long dormId = student.getDorm().getId();
		studentService.removeFromDorm(student);
		return "redirect:/dorms/" + dormId;
	}
	
	@GetMapping("/{id}")
	public String addSubject(@PathVariable("id") Long id, Model model) {
		Student student = studentService.findStudent(id);
		model.addAttribute("student", student);
		model.addAttribute("notEnrolledSubjects", subjectService.getByNotContainsStudents(student));
		return "showClassesOfStudent.jsp";
	}
	
	@GetMapping("/remove/{id}/{subjectId}")
	public String dropSubject(@PathVariable("id") Long id, @PathVariable("subjectId") Long subjectId, Model model) {
		Student student = studentService.findStudent(id);
		student.getSubjects().remove(subjectService.findSubject(subjectId));
		studentService.updateStudent(student);
		return "redirect:/students/{id}";
	}
	
	// POST METHODS
	
	@PostMapping("/new")
	public String createStudent(Model model,@Valid @ModelAttribute("student") Student student, BindingResult results) {
		if (results.hasErrors()) {
			model.addAttribute("dorms", dormService.allDorms());
			return "studentForm.jsp";
		} else {
			studentService.createStudent(student);
			return "redirect:/dorms/" + student.getDorm().getId();
		}
	}
	
	@PostMapping("/{id}")
	public String enrollSubject(@PathVariable("id") Long id, @RequestParam(value="subjectId") Long subjectId, Model model) {
		Student student = studentService.findStudent(id);
		model.addAttribute("student", student);
		student.getSubjects().add(subjectService.findSubject(subjectId));
		studentService.updateStudent(student);
		return "redirect:/students/" + id;
	}
	

	
}
