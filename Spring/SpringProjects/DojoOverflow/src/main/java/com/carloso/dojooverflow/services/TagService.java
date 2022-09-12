package com.carloso.dojooverflow.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carloso.dojooverflow.models.Tag;
import com.carloso.dojooverflow.repositories.TagRepository;

@Service
public class TagService {
	
	@Autowired
	private TagRepository tagRepo;
	
	public Tag findBySubject(String subject) {
		return tagRepo.findBySubjectIs(subject);
	}
	
	public Tag createTag(Tag t) {
		return tagRepo.save(t);
	}

	
	public List<Tag> validateTags(String tags) {
		// Split up string of tags
    	String[] splitTags = tags.trim().split(",");
    	
    	// ArrayList that we will populate with individual Tag objects
		ArrayList<Tag> tempTags = new ArrayList<>();
		
		// Check if we have more than 3 tags
		if(splitTags.length > 3) {
			return null;
		}
		
		// Check if string is empty
		if(splitTags.length < 1) {
			return null;
		}
		
		// Iterate through the splitTags and create new Tag objects for each one that does not exist in our database
		for(String s: splitTags) {
			
			// First we remove spaces before and after the tag String and convert the tag to all lower case characters
			s = s.trim().toLowerCase();
			// We make sure the Tag object does not exist and that the tag String is at least one character long
			if(this.findBySubject(s)==null && s.length()>0) {
				// If the Tag object is not found, we add a new Tag object to our tempTags ArrayList (which will then add it to our database later)
				tempTags.add(new Tag(s));
			}else {
				// If the object is found, we simply add it to the tempTags ArrayList
				tempTags.add(this.findBySubject(s));
			}
		}
		return tempTags;
    }
}
