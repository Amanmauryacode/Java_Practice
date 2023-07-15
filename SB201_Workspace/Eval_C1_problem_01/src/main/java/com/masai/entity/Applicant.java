package com.masai.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "job_applicant")
public class Applicant {
	@Id
	private int id;
	private String email;
	private String address;
	private String mobNo;
	private String category;
	private int experience;
	public Applicant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Applicant(int id, String email, String address, String mobNo, String category, int experience) {
		super();
		this.id = id;
		this.email = email;
		this.address = address;
		this.mobNo = mobNo;
		this.category = category;
		this.experience = experience;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobNo() {
		return mobNo;
	}
	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	@Override
	public String toString() {
		return "Applicant [id=" + id + ", email=" + email + ", address=" + address + ", mobNo=" + mobNo + ", category="
				+ category + ", experience=" + experience + "]";
	}
	
	
	
	
}
