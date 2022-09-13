package com.carloso.studentroster.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.carloso.studentroster.models.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
	List<Student> findAll();
	List<Student> findAllByDormIdIs(Long dormId);
	Optional<Student> findById(Long id);
}
