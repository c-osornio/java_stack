package com.carloso.mvcbakery.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carloso.mvcbakery.models.Chef;
import com.carloso.mvcbakery.repositories.ChefRepository;

@Service
public class ChefService {
	
	@Autowired
	ChefRepository chefRepo;
	
    public List<Chef> allChefs() {
        return chefRepo.findAll();
    }
    
    public Chef findChef(Long id) {
    	return chefRepo.findById(id).orElse(null);
    }
}
