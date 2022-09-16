package com.carloso.beltexam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carloso.beltexam.models.Listing;
import com.carloso.beltexam.repositories.ListingRepository;


@Service
public class ListingService {
	
	@Autowired
	private ListingRepository listingRepo;
	
	public List<Listing> allListings() {
		return listingRepo.findAll();
	}

	public Listing createListing(Listing l) {
		return listingRepo.save(l);
	}
	
    public Listing findListing(Long id) {
    	return listingRepo.findById(id).orElse(null);
    }
    
    public void updateListing(Listing l) {
    	listingRepo.save(l);
    }
    
    public void deleteListing(Long id) {
    	listingRepo.deleteById(id);
    }
}
