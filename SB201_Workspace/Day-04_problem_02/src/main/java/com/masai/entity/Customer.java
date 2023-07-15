package com.masai.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "customer by id",
			query = "Select c from Customer c WHERE c.customerId = :id")

@NamedQuery(name = "List of All the customers",
			query = "from Customer")
public class Customer {
//	Table: customer{
//		customerId: int primary key
//		name: varchar not null
//		address: varchar not null
//		budget: int not null
//	}
	
	@Id
	private int customerId;
	private String name;
	private String address;
	private int budget;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getBudget() {
		return budget;
	}
	public void setBudget(int budget) {
		this.budget = budget;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", address=" + address + ", budget=" + budget
				+ "]";
	}
	
	
}
