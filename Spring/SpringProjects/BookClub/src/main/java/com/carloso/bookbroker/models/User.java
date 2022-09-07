package com.carloso.bookbroker.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
    
@Entity
@Table(name="users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty(message="*Username is required!")
    @Size(min=3, max=30, message="*Username must be between 3 and 30 characters.")
    private String username;
    
    @NotEmpty(message="*Email is required!")
    @Email(message="*Please enter a valid email!")
    private String email;
    
    @NotEmpty(message="*Password is required!")    
    @Size(min=8, max=128, message="*Password must be between 8 and 128 characters.")
    private String password;
    
    @Transient
    @NotEmpty(message="*Confirm Password is required!")
    private String confirmPW;
    
    @Transient
    @AssertTrue(message="*Please accept terms and conditions.")
    private boolean terms;
    
    @Column(updatable=false)
	@OneToMany(mappedBy="user", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Book> books;
    
    @Column(updatable=false)
	@OneToMany(mappedBy="user", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Book> borrowedbooks;
    
	@Column(updatable = false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	private Date updatedAt;

  
    public User() {}


	public User(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
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


	public void setUsername(String userName) {
		this.username = userName;
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


	public boolean isTerms() {
		return terms;
	}


	public void setTerms(boolean terms) {
		this.terms = terms;
	}


	public List<Book> getBooks() {
		return books;
	}


	public void setBooks(List<Book> books) {
		this.books = books;
	}


	public List<Book> getBorrowedbooks() {
		return borrowedbooks;
	}


	public void setBorrowedbooks(List<Book> borrowedbooks) {
		this.borrowedbooks = borrowedbooks;
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
    
