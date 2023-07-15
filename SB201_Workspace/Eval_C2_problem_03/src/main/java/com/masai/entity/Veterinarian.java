package com.masai.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Veterinarian {
//	veterinarianId, name, specialty, and location.
	@Id
	private int veterinarianId;
	private String name;
	private String specialty;
	private String location;
	
	@ManyToMany
	@JoinTable(
				name = "Veterinarian_Pet",
				joinColumns = @JoinColumn(name = "veterinarianId"),
				inverseJoinColumns = @JoinColumn(name = "petID")
			)
	
	List<Pet> petList = new ArrayList<>();

	public int getVeterinarianId() {
		return veterinarianId;
	}

	public void setVeterinarianId(int veterinarianId) {
		this.veterinarianId = veterinarianId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Pet> getPetList() {
		return petList;
	}

	public void setPetList(List<Pet> petList) {
		this.petList = petList;
	}

	@Override
	public String toString() {
		return "Veterinarian [veterinarianId=" + veterinarianId + ", name=" + name + ", specialty=" + specialty
				+ ", location=" + location + ", petList=" + petList + "]";
	}
	
	
	
}
