package com.carloso.productsandcategories.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.carloso.productsandcategories.models.Category;
import com.carloso.productsandcategories.models.Product;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{
	
	List<Category> findAll();
	Optional<Category> findById(Long id);
	List<Category> findAllByProducts(Product product);
	List<Category> findByProductsNotContains(Product product);
}
