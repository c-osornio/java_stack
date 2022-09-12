package com.carloso.dojooverflow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carloso.dojooverflow.models.Answer;
import com.carloso.dojooverflow.models.Question;
import com.carloso.dojooverflow.repositories.QuestionRepository;

@Service
public class QuestionService {
	@Autowired
	private QuestionRepository questionRepo;
	
	public List<Question> allQuestions() {
		return questionRepo.findAll();
	}
	
	public Question findQuestion(Long id) {
		return questionRepo.findById(id).orElse(null);
	}
	
	public Question createQuestion(Question q) {
		return questionRepo.save(q);
	}

	public Question addAnswer(Question question, Answer answer) {
		question.getAnswers().add(answer);
		return questionRepo.save(question);
	}
}
