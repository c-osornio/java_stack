package com.carloso.beltexam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carloso.beltexam.models.Note;
import com.carloso.beltexam.repositories.NoteRepository;

@Service
public class NoteService {

	@Autowired
	private NoteRepository noteRepo;
	
	public Note createNote(Note n) {
		return noteRepo.save(n);
	}

	public List<Note> listingNotes(Long listingId){
		return noteRepo.findByListingIdIs(listingId);
	}
	
    public void deleteNote(Long id) {
    	noteRepo.deleteById(id);
    }
}
