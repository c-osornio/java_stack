package com.carloso.dojooverflow.controllers;

import java.util.List;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.carloso.dojooverflow.models.Answer;
import com.carloso.dojooverflow.models.Question;
import com.carloso.dojooverflow.models.Tag;
import com.carloso.dojooverflow.services.AnswerService;
import com.carloso.dojooverflow.services.QuestionService;
import com.carloso.dojooverflow.services.TagService;

@Controller
@RequestMapping("/questions")
public class QuestionController {

	// Services 
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private TagService tagService;
	
	@Autowired
	private AnswerService answerService;
	
	// GET METHODS
	
	@GetMapping("")
	public String dashboard(Model model) {
		model.addAttribute("questions", questionService.allQuestions());
		return "dashboard.jsp";
	}
	
	@GetMapping("/new")
	public String newQuestion(@ModelAttribute("question") Question question) {
		return "newQuestion.jsp";
	}
	
	@GetMapping("/createError")
	public String FlashMessage(RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("tagErrors", "*Maximum of 3 tags allowed. Tags must be lowercased and seperated by a comma. Tags cannot be empty.");
		redirectAttributes.addFlashAttribute("questionErrors", "*Question cannot be left blank.");
		return "redirect:/questions/new";
	}
	
	@GetMapping("/createTagError")
	public String tagFlashMessage(RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("tagErrors", "*Maximum of 3 tags allowed. Tags must be lowercased and seperated by a comma. Tags cannot be empty.");
		return "redirect:/questions/new";
	}
	
	@GetMapping("/{id}")
	public String showQuestion(Model model, @PathVariable("id") Long id, @ModelAttribute("answer") Answer answer) {
		model.addAttribute("question", questionService.findQuestion(id));
		return "showQuestion.jsp";
	}
	
	// POST METHODS
	
	@PostMapping("/new")
	public String createQuestion(
			Model model, 
			@Valid @ModelAttribute("question") Question question, 
			BindingResult result, 
			@RequestParam(value="ListOfTags") String ListOfTags
			) {
		
		model.addAttribute("modelTags", ListOfTags);
		if(result.hasErrors() && ListOfTags.isBlank()) {
			return "redirect:/questions/createError";
		} else if (result.hasErrors()) {
			return "newQuestion.jsp";
		} else if (ListOfTags.isBlank()) {
			return "redirect:/questions/createTagError";
		} else {
			List<Tag> questionTags = tagService.validateTags(ListOfTags);
			if(questionTags!=null) {
				question.setTags(questionTags);
				questionService.createQuestion(question);
			}else {
				return "redirect:/questions/createTagError";
			}
			return "redirect:/questions";
		}
	}
	
	@PostMapping("/{id}")
	public String newAnswer(
			@PathVariable("id") Long id,
			@Valid @ModelAttribute("answer") Answer answer, 
			BindingResult result,
			Model model) {
		Question question = questionService.findQuestion(id);
		model.addAttribute("question", question);
		if(result.hasErrors()) {
			return "showQuestion.jsp";
		}else {
			Answer newAnswer = new Answer(answer.getText());
			newAnswer.setQuestion(question);
			answerService.addAnswer(newAnswer);
			return "redirect:/questions/" + id;
		}	
	}
	
}
