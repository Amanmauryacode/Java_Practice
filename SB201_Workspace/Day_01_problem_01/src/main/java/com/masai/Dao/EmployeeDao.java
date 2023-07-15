package com.masai.Dao;

import java.util.List;

import com.masai.Exception.EmployeeException;
import com.masai.model.Employee;


public interface EmployeeDao {

	public String registerEmployee(Employee employee);
	
	public Employee getEmployeeById(int empId)throws EmployeeException;
	
	public List<Employee> getAllEmployee();
	
	public String deleteEmployeeById(int empId)throws EmployeeException;
	
	public String giveBonusToEmployee(int empId, int amount)throws EmployeeException;
}
