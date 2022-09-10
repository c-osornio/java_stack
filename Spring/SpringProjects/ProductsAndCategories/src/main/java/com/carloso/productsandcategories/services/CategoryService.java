package com.carloso.productsandcategories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carloso.productsandcategories.models.Category;
import com.carloso.productsandcategories.models.Product;
import com.carloso.productsandcategories.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepo;
	
	public List<Category> allCategories() {
		return categoryRepo.findAll();
	}
	
	public Category createCategory(Category c) {
		return categoryRepo.save(c);
	}
	
    public Category findCategory(Long id) {
    	return categoryRepo.findById(id).orElse(null);
    }
	
	public List<Category> getCategorizedProducts(Product product){
		return categoryRepo.findAllByProducts(product);
	}
	
	public List<Category> getUncategorizedProducts(Product product){
		return categoryRepo.findByProductsNotContains(product);
	}
	
	public Category updateCategory(Category category) {
		return categoryRepo.save(category);
	}
}
