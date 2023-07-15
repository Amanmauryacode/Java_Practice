package com.masai.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Seller {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seller_ID")
	private int seller_id;
	private String seller_name;
	private int year_of_experience;
	private String email;
	
	@OneToMany(mappedBy = "seller",cascade = CascadeType.ALL)
	private List<Store> sList = new ArrayList<>();

	public int getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(int seller_id) {
		this.seller_id = seller_id;
	}

	public String getSeller_name() {
		return seller_name;
	}

	public void setSeller_name(String seller_name) {
		this.seller_name = seller_name;
	}

	public int getYear_of_experience() {
		return year_of_experience;
	}

	public void setYear_of_experience(int year_of_experience) {
		this.year_of_experience = year_of_experience;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Store> getsList() {
		return sList;
	}

	public void setsList(List<Store> sList) {
		this.sList = sList;
	}

	@Override
	public String toString() {
		return "Seller [seller_id=" + seller_id + ", seller_name=" + seller_name + ", year_of_experience="
				+ year_of_experience + ", email=" + email + "]";
	}

}
