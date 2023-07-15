package com.masai.model;

import java.util.List;

public class ProjectEmployeListDTO {

	private Project project;
	private List<Employee> employees;
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	
}
