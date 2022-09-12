package com.carloso.dojooverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.carloso.dojooverflow.models.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {
	
	List<Tag> findAll();
	
	Tag findBySubjectIs(String subject);
}
