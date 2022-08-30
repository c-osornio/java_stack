package com.carloso.languages.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carloso.languages.models.Language;
import com.carloso.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	
	@Autowired
	LanguageRepository languageRepo;
	
	public List<Language> allLanguages() {
		return languageRepo.findAll();
	}
	
	public Language createLanguage(Language l) {
		return languageRepo.save(l);
	}
	
    public Language findLanguage(Long id) {
    	return languageRepo.findById(id).orElse(null);
    }
    
    public void updateLanguage(Language l) {
    	languageRepo.save(l);
    }
    
    public void deleteLanguage(Long id) {
    	languageRepo.deleteById(id);
    }
}
