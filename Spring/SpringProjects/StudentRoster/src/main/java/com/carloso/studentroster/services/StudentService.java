package com.carloso.studentroster.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carloso.studentroster.models.Dorm;
import com.carloso.studentroster.models.Student;
import com.carloso.studentroster.repositories.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepo;
	
	public List<Student> allStudents() {
		return studentRepo.findAll();
	}
	
	public List<Student> allStudentsByDormId(Long dormId) {
		return studentRepo.findAllByDormIdIs(dormId);
	}
	
	public Student findStudent(Long id) {
		return studentRepo.findById(id).orElse(null);
	}
	
	public Student createStudent(Student s) {
		return studentRepo.save(s);
	}
	
	public void updateStudent(Student s) {
		studentRepo.save(s); 
	}
	
	public void removeFromDorm(Student s) {
		s.setDorm(null);
		studentRepo.save(s);
	}
	
	public void addToDorm(Student s, Dorm d) {
		s.setDorm(d);
		studentRepo.save(s);
	}
	

}
