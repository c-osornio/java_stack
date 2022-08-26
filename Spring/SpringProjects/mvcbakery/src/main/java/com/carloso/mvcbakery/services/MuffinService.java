package com.carloso.mvcbakery.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.carloso.mvcbakery.models.Muffin;
import com.carloso.mvcbakery.repositories.MuffinRepository;

@Service
public class MuffinService {

	// adding the muffin repository as a dependency
	private final MuffinRepository muffinRepo;
	
	public MuffinService(MuffinRepository muffinRepo) {
	        this.muffinRepo = muffinRepo;
	}
	
	// returns all the muffins
    public List<Muffin> allMuffins() {
        return muffinRepo.findAll();
    }
    
    // creates a muffin
    public Muffin createMuffin(Muffin m) {
        return muffinRepo.save(m);
    }
    
    // retrieves a muffin
    public Muffin findMuffin(Long id) {
        Optional<Muffin> optionalMuffin = muffinRepo.findById(id);
        if(optionalMuffin.isPresent()) {
            return optionalMuffin.get();
        } else {
            return null;
        }
    }
    
    public Muffin findMuff(Long id) {
    	return muffinRepo.findById(id).orElse(null);
    }
    
    // updates a muffin
    public void updateMuffin(Muffin m) {
    	muffinRepo.save(m);
    }
    
    // deletes a muffin
    public void deleteMuffin(Long id) {
    	muffinRepo.deleteById(id);
    }
}

