package com.carloso.savetravels.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carloso.savetravels.models.Expense;
import com.carloso.savetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	@Autowired
	ExpenseRepository expenseRepo;
	
	public List<Expense> allExpenses() {
		return expenseRepo.findAll();
	}
	
	public Expense createExpense(Expense e) {
		return expenseRepo.save(e);
	}
	
    public Expense findExpense(Long id) {
    	return expenseRepo.findById(id).orElse(null);
    }
    
    public void updateExpense(Expense e) {
    	expenseRepo.save(e);
    }
}
