package com.masai.service;

import java.util.List;
import java.util.Map;

import com.masai.exception.DepartmentException;
import com.masai.exception.EmployeeException;
import com.masai.exception.ProjectException;
import com.masai.exception.RoleException;
import com.masai.model.AssignProjectRoleDTO;
import com.masai.model.Employee;
import com.masai.model.EmployeeExperienceDTO;

public interface EmployeeService {

	public Employee addEmployee(Employee employee)throws EmployeeException,ProjectException,RoleException,DepartmentException;
	
	public Employee getEmployeeById(Integer id)throws EmployeeException;
	
	public Employee AssignProjectAndRoleToEmployeeById(Integer id,AssignProjectRoleDTO dto) throws EmployeeException;
	
	public List<Employee> findEmployeebyProjectDeptAndRole(String pName,String dname,String rname)throws EmployeeException,ProjectException,DepartmentException,RoleException;
	
	public List<EmployeeExperienceDTO> findTopNExperienceEmployee(Integer n)throws EmployeeException;
}
