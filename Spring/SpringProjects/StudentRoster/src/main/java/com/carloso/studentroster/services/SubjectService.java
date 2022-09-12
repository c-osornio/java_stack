package com.carloso.studentroster.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carloso.studentroster.models.Student;
import com.carloso.studentroster.models.Subject;
import com.carloso.studentroster.repositories.SubjectRepository;


@Service
public class SubjectService {
	
	@Autowired
	private SubjectRepository subjectRepo;
	
	
	public List<Subject> allSubjects() {
		return subjectRepo.findAll();
	}
	
	public List<Subject> allSubjectsByStudentId(Long studentId) {
		return subjectRepo.findAllByStudentsIdIs(studentId);
	}
	
	public Subject findSubject(Long id) {
		return subjectRepo.findById(id).orElse(null);
	}
	
	public Subject createSubject(Subject s) {
		return subjectRepo.save(s);
	}
	
	public void updateSubject(Subject s) {
		subjectRepo.save(s); 
	}
	
	public List<Subject> getByNotContainsStudents(Student s){
		return subjectRepo.findByStudentsNotContains(s);
	}
}
