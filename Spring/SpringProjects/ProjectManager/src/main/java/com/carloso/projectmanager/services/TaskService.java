package com.carloso.projectmanager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carloso.projectmanager.models.Task;
import com.carloso.projectmanager.repositories.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepo;
	
	public Task createTask(Task t) {
		return taskRepo.save(t);
	}

	public List<Task> projectTasks(Long projectId){
		return taskRepo.findByProjectIdIs(projectId);
	}
	
	public Task addTask(Task task) {
		return taskRepo.save(task);
	}
	
    public void deleteTask(Long id) {
    	taskRepo.deleteById(id);
    }
}
