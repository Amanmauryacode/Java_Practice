package com.masai;

import java.util.Objects;

public class Employee {

	private Integer employeeId;
	private String name;
	private Integer salary;
	private EPFOAccount epfoAccount;

	public Employee(Integer employeeId, String name, Integer salary, EPFOAccount epfoAccount) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.salary = salary;
		this.epfoAccount = epfoAccount;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public EPFOAccount getEpfoAccount() {
		return epfoAccount;
	}

	public void setEpfoAccount(EPFOAccount epfoAccount) {
		this.epfoAccount = epfoAccount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(employeeId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(employeeId, other.employeeId);
	}

	@Override
	public String toString() {
//		Employee Id: E001 Name: Anuj Salary: 45000 EPFO Account details: (Account number: EPF001 Balance: 25500/-)

		return "Employee Id: " + employeeId + " Name: " + name + " Salary: " + salary + " EPFO Account details: ("
				+ epfoAccount + ")";
	}

}
