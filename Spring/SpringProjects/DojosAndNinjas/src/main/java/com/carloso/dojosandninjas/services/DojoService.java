package com.carloso.dojosandninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carloso.dojosandninjas.models.Dojo;
import com.carloso.dojosandninjas.repositories.DojoRepository;

@Service
public class DojoService {

	@Autowired
	DojoRepository dojoRepo;
	
	public List<Dojo> allDojos() {
		return dojoRepo.findAll();
	}
	
	public Dojo createDojo(Dojo d) {
		return dojoRepo.save(d);
	}
	
	public Dojo findDojo(Long id) {
		return dojoRepo.findById(id).orElse(null);
	}
}
