package com.carloso.productsandcategories.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.carloso.productsandcategories.services.CategoryService;
import com.carloso.productsandcategories.services.ProductService;

@Controller
public class MainController {
	
	// Services
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;

	// GET METHODS
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("products", productService.allProducts());
		model.addAttribute("categories", categoryService.allCategories());
		return "home.jsp";
	}
}

