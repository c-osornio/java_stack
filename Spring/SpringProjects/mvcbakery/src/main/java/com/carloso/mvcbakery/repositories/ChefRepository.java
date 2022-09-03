package com.carloso.mvcbakery.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.carloso.mvcbakery.models.Chef;

@Repository
public interface ChefRepository extends CrudRepository<Chef, Long> {
	List <Chef> findAll();
	Optional<Chef> findById(Long id);
}
