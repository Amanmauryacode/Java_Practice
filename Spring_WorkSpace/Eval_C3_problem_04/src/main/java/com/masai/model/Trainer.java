package com.masai.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Trainer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;// (primary key);
	private String name;
	private int age;
	private String email;
	private String mobile;
	private int noOfClients;
	private boolean availability;
	@OneToOne
	private int specialization_id;// (foreign key);
	public Trainer(int id, String name, int age, String email, String mobile, int noOfClients, boolean availability,
			int specialization_id) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;
		this.mobile = mobile;
		this.noOfClients = noOfClients;
		this.availability = availability;
		this.specialization_id = specialization_id;
	}
	public Trainer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public int getNoOfClients() {
		return noOfClients;
	}
	public void setNoOfClients(int noOfClients) {
		this.noOfClients = noOfClients;
	}
	public boolean isAvailability() {
		return availability;
	}
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	public int getSpecialization_id() {
		return specialization_id;
	}
	public void setSpecialization_id(int specialization_id) {
		this.specialization_id = specialization_id;
	}
	
}