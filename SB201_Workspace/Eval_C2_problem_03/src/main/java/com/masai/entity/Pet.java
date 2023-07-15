package com.masai.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Pet {
//	petId and petName.
	@Id
	private int petID;
	private String petName;
	
	@ManyToMany(mappedBy = "petList",cascade = CascadeType.ALL)
	List<Veterinarian> veterinarianList = new ArrayList<>();

	public int getPetID() {
		return petID;
	}

	public void setPetID(int petID) {
		this.petID = petID;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	

	public List<Veterinarian> getVeterinarianList() {
		return veterinarianList;
	}

	public void setVeterinarianList(List<Veterinarian> veterinarianList) {
		this.veterinarianList = veterinarianList;
	}

	@Override
	public String toString() {
		return "Pet [petID=" + petID + ", petName=" + petName + "]";
	}
	
	
}
