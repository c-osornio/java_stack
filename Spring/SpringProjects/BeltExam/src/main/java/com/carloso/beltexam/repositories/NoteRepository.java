package com.carloso.beltexam.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.carloso.beltexam.models.Note;



@Repository
public interface NoteRepository extends CrudRepository<Note, Long>{
	List<Note> findByListingIdIs(Long id);
}
