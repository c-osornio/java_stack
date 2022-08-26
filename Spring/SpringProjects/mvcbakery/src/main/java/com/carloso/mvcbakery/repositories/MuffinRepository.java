package com.carloso.mvcbakery.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.carloso.mvcbakery.models.Muffin;

@Repository
public interface MuffinRepository extends CrudRepository<Muffin, Long>{
	
	List <Muffin> findAll();
	List <Muffin> findByFrostingContaining(String search);
	Optional<Muffin> findById(long id);
	Long countByFrostingContaining(String search);
}
