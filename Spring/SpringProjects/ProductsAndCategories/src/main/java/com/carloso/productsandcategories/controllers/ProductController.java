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
@RequestMapping("/products")
public class ProductController {

	// Services
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;

	// GET METHODS
	
	@GetMapping("/new")
	public String newProduct(@ModelAttribute("product") Product product) {
		return "productForm.jsp";
	}
	
	@GetMapping("/{id}")
	public String showProduct(@PathVariable("id") Long id, Model model) {
		model.addAttribute("categorized", categoryService.getCategorizedProducts(productService.findProduct(id)));
		model.addAttribute("uncategorized", categoryService.getUncategorizedProducts(productService.findProduct(id)));
		model.addAttribute("product", productService.findProduct(id));
		return "showProduct.jsp";
	}
	
	// POST METHODS
	
	@PostMapping("/new")
	public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "productForm.jsp";
		} else { 
			productService.createProduct(product);
			return "redirect:/";
		}
	}
	
	@PostMapping("/{id}")
	public String addCategory(@PathVariable("id") Long id, @RequestParam(value="categoryId") Long categoryId,  Model model) {
		Product product = productService.findProduct(id);
		Category category = categoryService.findCategory(categoryId);
		product.getCategories().add(category);
		productService.updateProduct(product);
		model.addAttribute("categorized", categoryService.getCategorizedProducts(product));
		model.addAttribute("uncategorized", categoryService.getUncategorizedProducts(product));
		return "redirect:/products/" + id;
	}
}
