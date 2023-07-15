package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Department {
//	a unique departmentId, departmentName, and location.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "department_id ")
	private Integer departmentId;
	@NotNull(message = "Department Name Can Not Be Null!")
	@NotEmpty(message = "Department Name can not be empty")
	private String departmentName;
	@NotNull(message = "Location Can Not Be Null!")
	@NotEmpty(message = "Location can not be empty")
	private String location;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Department_Project",joinColumns = @JoinColumn(name = "department_id"),inverseJoinColumns = @JoinColumn(name = "project_id"))
	private List<Project> projects = new ArrayList<>();

	public Department() {
		// TODO Auto-generated constructor stub
	}
	
	public Department(String departmentName, String location, List<Project> projects) {
		super();
		this.departmentName = departmentName;
		this.location = location;
		this.projects = projects;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
}
