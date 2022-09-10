package com.carloso.productsandcategories.controllers;

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

import com.carloso.productsandcategories.models.Category;
import com.carloso.productsandcategories.models.Product;
import com.carloso.productsandcategories.services.CategoryService;
import com.carloso.productsandcategories.services.ProductService;

@Controller
@RequestMapping("/categories")
public class CategoryController {
	
	// Services
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;

	// GET METHODS
	
	@GetMapping("/new")
	public String newCategory(@ModelAttribute("category") Category category) {
		return "categoryForm.jsp";
	}
	
	@GetMapping("/{id}")
	public String showCategory(@PathVariable("id") Long id, Model model) {
		model.addAttribute("assignedProducts", productService.getProductsByCategory(categoryService.findCategory(id)));
		model.addAttribute("unassignedProducts", productService.getProductsUncategorized(categoryService.findCategory(id)));
		model.addAttribute("category", categoryService.findCategory(id));
		return "showCategory.jsp";
	}
	
	// POST METHODS
	
	@PostMapping("/new")
	public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "categoryForm.jsp";
		} else { 
			categoryService.createCategory(category);
			return "redirect:/";
		}
	}
	
	@PostMapping("/{id}")
	public String addProduct(@PathVariable("id") Long id, @RequestParam(value="productId") Long productId,  Model model) {
		Product product = productService.findProduct(productId);
		Category category = categoryService.findCategory(id);
		category.getProducts().add(product);
		categoryService.updateCategory(category);
		model.addAttribute("assignedProducts", productService.getProductsByCategory(category));
		model.addAttribute("unassignedProducts", productService.getProductsUncategorized(category));
		return "redirect:/categories/" + id;
	}
}
