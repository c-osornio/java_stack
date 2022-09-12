package com.carloso.dojooverflow.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carloso.dojooverflow.models.Answer;
import com.carloso.dojooverflow.repositories.AnswerRepository;

@Service
public class AnswerService {
	
	@Autowired
	private AnswerRepository answerRepo;
	
	public Answer createAnswer(Answer a) {
		return answerRepo.save(a);
	}
	
	public Answer addAnswer(Answer answer) {
		return answerRepo.save(answer);
	}
}
