package com.carloso.projectmanager.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.carloso.projectmanager.models.Project;
import com.carloso.projectmanager.models.Task;
import com.carloso.projectmanager.models.User;
import com.carloso.projectmanager.services.ProjectService;
import com.carloso.projectmanager.services.TaskService;
import com.carloso.projectmanager.services.UserService;

@Controller
public class ProjectController {

	// SERVICES 
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private TaskService taskService;
	
	// GET METHODS
	
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, Model model) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		Long userId = (Long) session.getAttribute("userId");
		model.addAttribute("user", userService.findById(userId));
		model.addAttribute("availableProjects", projectService.availableProjects(userService.findById(userId)));
		model.addAttribute("myProjects", projectService.myProjects(userService.findById(userId)));
		return "project/dashboard.jsp";
	}
	
	@GetMapping("/projects/new")
	public String newProject(@ModelAttribute("project") Project project, Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		User user = userService.findById((Long)session.getAttribute("userId"));
    	model.addAttribute("user", user);
		return "/project/projectForm.jsp";
	}
	
	@GetMapping("/projects/{id}")
	public String showProject(Model model, @PathVariable("id") Long id, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		model.addAttribute("project", projectService.findProject(id));
		model.addAttribute("user", userService.findById((Long)session.getAttribute("userId")));
		return "project/showProject.jsp";
	}


    @GetMapping("/projects/{id}/join")
    public String jointProject(@PathVariable("id") Long projectId, HttpSession session) {
    	if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
    	Long userId = (Long) session.getAttribute("userId");
    	projectService.joinProject(projectService.findProject(projectId), userService.findById(userId));
    	return "redirect:/dashboard";
    }
    
    @GetMapping("/projects/{id}/leave")
    public String leaveProject(@PathVariable("id") Long projectId, HttpSession session) {
    	if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
    	Long userId = (Long) session.getAttribute("userId");
    	projectService.leaveProject(projectService.findProject(projectId), userService.findById(userId));
    	return "redirect:/dashboard";
    }

    @GetMapping("projects/{id}/edit")
    public String editProject(Model model, @PathVariable("id") Long id, HttpSession session) {
    	if (session.getAttribute("userId") == null) {
    		return "redirect:/logout";
    	}

       	// Send back to /dashboard if user tries to edit another person's project
    	Long userId = (Long) session.getAttribute("userId");
    	User user = userService.findById(userId);
		if ( !user.getFirstName().equals(projectService.findProject(id).getTeamLead()) ) {
			return "redirect:/dashboard";
		}
		
    	model.addAttribute("project", projectService.findProject(id));
    	model.addAttribute("user", user);
    	return "project/editProject.jsp";
    }
    
    @GetMapping("projects/{id}/tasks")
    public String showTasks(@PathVariable("id") Long id, HttpSession session, Model model, @ModelAttribute("task") Task task) {
    	if (session.getAttribute("userId") == null) {
    		return "redirect:/logout";
    	}
		Project project = projectService.findProject(id);
    	model.addAttribute("project", project);
    	model.addAttribute("tasks", taskService.projectTasks(id));
    	return "project/showTasks.jsp";
    }

	// POST METHODS
	
	@PostMapping("projects/new")
	public String createProject(Model model, @Valid @ModelAttribute("project") Project project, BindingResult result, HttpSession session) {
    	if (session.getAttribute("userId") == null) {
    		return "redirect:/logout";
    	}
    	
		if (result.hasErrors()) {
			User user = userService.findById((Long)session.getAttribute("userId"));
	    	model.addAttribute("user", user);
			return "/project/projectForm.jsp";
		} else {
			Long userId = (Long) session.getAttribute("userId");
			User user = userService.findById(userId);
			Project newProject = new Project(project.getTitle(), project.getDescription(), project.getDueDate(), project.getTeamLead());
			projectService.createProject(newProject);
			user.getProjects().add(newProject);
			userService.updateUser(user);
			return "redirect:/dashboard";
		}
	}
	
	@PostMapping("projects/{id}/tasks")
	public String createTask(@PathVariable("id") Long id, Model model, @Valid @ModelAttribute("task") Task task, BindingResult result, HttpSession session) {
    	if (session.getAttribute("userId") == null) {
    		return "redirect:/logout";
    	}
		
		Long userId = (Long) session.getAttribute("userId");
		Project project = projectService.findProject(id);
		
		
		if (result.hasErrors()) {
	    	model.addAttribute("project", project);
	    	model.addAttribute("tasks", taskService.projectTasks(id));
			return "/project/showTasks.jsp";
		} else {
			Task newTask = new Task(task.getTicket());
			newTask.setProject(project);
			newTask.setCreator(userService.findById(userId).getFirstName());
			taskService.createTask(newTask);
			return "redirect:/projects/" + id + "/tasks";
		}
	}
	
	// PUT METHOD
	
    @PutMapping("projects/{id}/edit")
    public String updateProject(@PathVariable("id") Long id, @Valid @ModelAttribute("project") Project project, BindingResult result, Model model, HttpSession session) {
    	if (result.hasErrors()) {
    		return "project/editProject.jsp";
    	}
    	Project thisProject = projectService.findProject(id);
    	project.setUsers(thisProject.getUsers());
        projectService.updateProject(project);
    	return "redirect:/dashboard";
    }
    
    // DELETE METHOD
    
    @DeleteMapping("projects/{id}/delete")
    public String destroyProject(@PathVariable("id") Long id) {
        projectService.deleteProject(id);
        return "redirect:/dashboard";
    }
    
    @DeleteMapping("projects/{id}/{taskId}/delete")
    public String destroyTask(@PathVariable("id") Long id, @PathVariable("taskId") Long taskId) {
        taskService.deleteTask(taskId);
        return "redirect:/projects/" + id + "/tasks";
    }


}
