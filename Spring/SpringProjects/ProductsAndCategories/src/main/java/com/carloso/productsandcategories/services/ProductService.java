package com.carloso.productsandcategories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carloso.productsandcategories.models.Category;
import com.carloso.productsandcategories.models.Product;
import com.carloso.productsandcategories.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepo;
	
	public List<Product> allProducts() {
		return productRepo.findAll();
	}
	
	public Product createProduct(Product p) {
		return productRepo.save(p);
	}

    public Product findProduct(Long id) {
    	return productRepo.findById(id).orElse(null);
    }

	public List<Product> getProductsByCategory(Category category){
		return productRepo.findAllByCategories(category);
	}
	
	public List<Product> getProductsUncategorized(Category category){
		return productRepo.findByCategoriesNotContains(category);
	}
	
	public Product updateProduct(Product product) {
		return productRepo.save(product);
	}
}
