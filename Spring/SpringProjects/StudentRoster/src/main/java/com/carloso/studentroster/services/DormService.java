package com.carloso.studentroster.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carloso.studentroster.models.Dorm;
import com.carloso.studentroster.repositories.DormRepository;

@Service
public class DormService {
	
	@Autowired
	private DormRepository dormRepo;
	
	public List<Dorm> allDorms() {
		return dormRepo.findAll();
	}
	
	public Dorm createDorm(Dorm d) {
		return dormRepo.save(d);
	}
	
	public Dorm findDorm(Long id) {
		return dormRepo.findById(id).orElse(null);
	}
}
