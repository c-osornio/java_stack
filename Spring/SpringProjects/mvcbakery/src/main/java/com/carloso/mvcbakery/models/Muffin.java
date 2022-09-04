package com.carloso.mvcbakery.models;

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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="muffins")
public class Muffin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@NotNull
	@Size(min = 4, max = 100, message= "Flavor name is either too short or too long, bro")
	private String flavor;
	
	@NotNull
	@Size(min = 3, max = 20, message= "Frosting name is either too short or too long, bro")
	private String frosting;
	
	@NotNull(message= "Provide amount for calories and keep it over 250 breh")
	@Min(250)
	private Integer calories;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="chef_id")
	private Chef chef;
	
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

	public Muffin() {}


	public Muffin(@NotNull @Size(min = 4, max = 100) String flavor,
			@NotNull @Size(min = 3, max = 20) String frosting, @NotNull @Min(250) Integer calories) {
		this.flavor = flavor;
		this.frosting = frosting;
		this.calories = calories;
	}
	

	public Chef getChef() {
		return chef;
	}


	public void setChef(Chef chef) {
		this.chef = chef;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFlavor() {
		return flavor;
	}


	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}


	public String getFrosting() {
		return frosting;
	}


	public void setFrosting(String frosting) {
		this.frosting = frosting;
	}


	public Integer getCalories() {
		return calories;
	}


	public void setCalories(Integer calories) {
		this.calories = calories;
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
