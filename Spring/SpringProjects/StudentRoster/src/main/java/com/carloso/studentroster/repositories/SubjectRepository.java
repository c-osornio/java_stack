package com.carloso.studentroster.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.carloso.studentroster.models.Student;
import com.carloso.studentroster.models.Subject;


@Repository
public interface SubjectRepository extends CrudRepository<Subject, Long> {
	
	List<Subject> findAll();
	List<Subject> findAllByStudentsIdIs(Long studentId);
	Optional<Subject> findById(Long id);
	List<Subject> findByStudentsNotContains(Student student);
}
