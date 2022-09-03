package com.carloso.dojosandninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.carloso.dojosandninjas.models.Dojo;
import com.carloso.dojosandninjas.models.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long> {

	List <Ninja> findAll();
	List<Ninja> findAllByDojo(Dojo dojo);
}
