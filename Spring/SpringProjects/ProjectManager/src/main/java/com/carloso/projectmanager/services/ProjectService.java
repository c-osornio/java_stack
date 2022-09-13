package com.carloso.projectmanager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carloso.projectmanager.models.Project;
import com.carloso.projectmanager.models.User;
import com.carloso.projectmanager.repositories.ProjectRepository;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepo;
	
	public List<Project> availableProjects(User u){
		return projectRepo.findByUsersNotContains(u);
	}
	
	public List<Project> myProjects(User u){
		return projectRepo.findByUsersIdIs(u.getId());
	}

	public Project createProject(Project p) {
		return projectRepo.save(p);
	}

    public Project findProject(Long id) {
    	return projectRepo.findById(id).orElse(null);
    }

	public void leaveProject(Project project, User user) {
		project.getUsers().remove(user);
		projectRepo.save(project);
	}
	
	public void joinProject(Project project, User user) {
		project.getUsers().add(user);
		projectRepo.save(project);
	}	
	
    public void updateProject(Project p) {
    	projectRepo.save(p);
    }
    
    public void deleteProject(Long id) {
    	projectRepo.deleteById(id);
    }


}
