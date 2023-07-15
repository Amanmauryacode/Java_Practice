package com.masai.Dao;

import com.masai.Entity.Employee;

public interface EmployeeDao {
	public String registerEmployee(Employee employee);

	public Employee getEmployeeById(int empId);

	public String deleteEmployeeById(int empId);

	public String updateEmployeeSalary(int empId, int amount);
}
