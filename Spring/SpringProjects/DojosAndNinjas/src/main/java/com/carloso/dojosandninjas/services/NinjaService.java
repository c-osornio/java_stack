package com.carloso.dojosandninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carloso.dojosandninjas.models.Dojo;
import com.carloso.dojosandninjas.models.Ninja;
import com.carloso.dojosandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	
	@Autowired
	private NinjaRepository ninjaRepo;
	
	public List<Ninja> allNinjas() {
		return ninjaRepo.findAll();
	}
	
	public Ninja createNinja(Ninja n) {
		return ninjaRepo.save(n);
	}
	
	public Ninja findNinja(Long id) {
		return ninjaRepo.findById(id).orElse(null);
	}
	
	public List<Ninja> findAllByDojo(Dojo dojo) {
		return ninjaRepo.findAllByDojo(dojo);
	}
}
