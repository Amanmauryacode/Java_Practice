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
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Role {
//	 a unique roleId and roleName.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private Integer roleId;
	@NotNull(message = "Role Name Can Not Be Null!")
	@NotEmpty(message = "Role name can not be empty")
	private String roleName;
	@JsonIgnore
	@ManyToMany(mappedBy = "Roles",cascade = CascadeType.ALL)
	private List<Employee> employees = new ArrayList<>();

	
	public Role() {
		// TODO Auto-generated constructor stub
	}
	
	public Role(String roleName, List<Employee> employees) {
		super();
		this.roleName = roleName;
		this.employees = employees;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	

}
