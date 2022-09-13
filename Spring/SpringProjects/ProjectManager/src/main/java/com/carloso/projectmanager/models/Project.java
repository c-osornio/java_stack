package com.carloso.projectmanager.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="*Title must be provided.")
	private String title;

	@NotBlank(message="*Description must not be blank.")
	@Size(min=3, message="*Description must be between 3 characters.")
	private String description;
	
	@NotNull(message="*Due date must be provided.")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@FutureOrPresent(message="*Due date must not be in the past.")
	private Date dueDate;
	
    private String teamLead;
	
	@Column(updatable = false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	private Date updatedAt;

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(
        name="users_projects", 
        joinColumns=@JoinColumn(name="projectId"), 
        inverseJoinColumns=@JoinColumn(name="userId")
    )
    private List<User> users;
    
    @Column(updatable=false)
	@OneToMany(mappedBy="project", fetch=FetchType.LAZY)
	private List<Task> tasks;


	public Project() {
	}

	public Project(String title,
			String description,
			Date dueDate,
			String teamLead) {
		this.title = title;
		this.description = description;
		this.dueDate = dueDate;
		this.teamLead = teamLead;
	}
	
	

	public Project(String title,
			String description,
			Date dueDate,
			String teamLead, 
			List<User> users) {
		this.title = title;
		this.description = description;
		this.dueDate = dueDate;
		this.teamLead = teamLead;
		this.users = users;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getTeamLead() {
		return teamLead;
	}

	public void setTeamLead(String teamLead) {
		this.teamLead = teamLead;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}
	
	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
    
    
    
    
}
