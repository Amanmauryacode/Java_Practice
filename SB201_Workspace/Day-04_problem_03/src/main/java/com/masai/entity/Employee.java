package com.masai.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;

@Entity
@NamedNativeQuery(name ="Employee.FindAllEmployee" , query = "select * from employee", resultClass = Employee.class)
@NamedNativeQuery(name ="Employee.FindEmployeeByName" , query = "select * from employee where empName = ?", resultClass = Employee.class)
public class Employee {

	
//	Employee{
//		empId: int (primary key)
//		empName: string
//		address: string
//		salary: int 
//		email : string
//	}
	@Id
	
	private int empId;
	private String empName;
	private String address;
	private int salary;
	private String email;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", address=" + address + ", salary=" + salary
				+ ", email=" + email + "]";
	}
	
	
}
