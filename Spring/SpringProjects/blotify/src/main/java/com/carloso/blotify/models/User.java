package com.carloso.blotify.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=4, max=128, message="Username must be at least 4 characters long.")
	private String username;
	
	@NotNull
	@Email(message="Invaild email address.")
	private String email;
	
	@NotNull
	@Size(min=8, max=128, message="Paswword must be at least 8 characters.")
	private String password;
	
	@Transient
	private String confirmPW;
	
	@Column(updatable = false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	private Date updatedAt;
	
	@OneToMany(mappedBy="user", fetch=FetchType.LAZY)
	private List<Playlist> playlists;
	
	public User() {
	}


	public User(
			@NotNull @Size(min = 4, max = 128, message = "Username must be at least 4 characters long.") String username,
			@NotNull @Email(message = "Invaild email address.") String email,
			@NotNull @Size(min = 8, max = 128, message = "Paswword must be at least 8 characters.") String password,
			String confirmPW) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.confirmPW = confirmPW;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getConfirmPW() {
		return confirmPW;
	}


	public void setConfirmPW(String confirmPW) {
		this.confirmPW = confirmPW;
	}

	

	public Date getCreatedAt() {
		return createdAt;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}
	
	public List<Playlist> getPlaylists() {
		return playlists;
	}


	public void setPlaylists(List<Playlist> playlists) {
		this.playlists = playlists;
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
