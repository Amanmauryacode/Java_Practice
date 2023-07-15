package com.masai.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Project {
//	a unique projectId, projectName, and startDate.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "project_id")
	private Integer projectId;
	@NotNull(message = "Project Name Can Not Be Null!")
	@NotEmpty(message = "Project Name can not be empty")
	private String projectName;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate startDate;
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "projects")
	private List<Employee> employees = new ArrayList<>();

	@ManyToOne(cascade = CascadeType.ALL)
	private Department departments;

	public Project() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Project(String projectName, LocalDate startDate, List<Employee> employees, Department departments) {
		super();
		this.projectName = projectName;
		this.startDate = startDate;
		this.employees = employees;
		this.departments = departments;
	}



	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Department getDepartments() {
		return departments;
	}

	public void setDepartments(Department departments) {
		this.departments = departments;
	}
	
	
}
