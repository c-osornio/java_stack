package com.carloso.projectmanager.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="tasks")
public class Task {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
    @NotEmpty(message="*Ticket is required!")
    private String ticket;
    
    private String creator;
    
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="projectId")
	private Project project;

	@Column(updatable = false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	private Date updatedAt;

	public Task() {
	}
	
	

	public Task(String ticket) {
		this.ticket = ticket;
	}



	public Task(String ticket, Project project, String creator) {
		this.ticket = ticket;
		this.project = project;
		this.creator = creator;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
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
