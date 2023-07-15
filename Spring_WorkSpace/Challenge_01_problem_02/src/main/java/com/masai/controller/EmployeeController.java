package com.masai.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.DepartmentException;
import com.masai.exception.EmployeeException;
import com.masai.exception.ProjectException;
import com.masai.exception.RoleException;
import com.masai.model.AssignProjectRoleDTO;
import com.masai.model.Employee;
import com.masai.model.EmployeeExperienceDTO;
import com.masai.service.EmployeeService;

import jakarta.validation.Valid;
@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/employees")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) throws EmployeeException, ProjectException, RoleException, DepartmentException{
		
		Employee savedEmployee = employeeService.addEmployee(employee);
		return new ResponseEntity<>(savedEmployee,HttpStatus.CREATED);
	}
	
	@GetMapping("/employees/{Id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("Id") Integer id) throws EmployeeException{
		
	    Employee employee = employeeService.getEmployeeById(id);
	    
	    return new ResponseEntity<>(employee,HttpStatus.OK);
	}
	
	@PatchMapping("/employees/{Id}")
	public ResponseEntity<Employee> assignProjectAndRoleToEmployeeById(@Valid @PathVariable("Id") Integer id,@RequestBody AssignProjectRoleDTO dto ) throws EmployeeException{
		
		Employee employee = employeeService.AssignProjectAndRoleToEmployeeById(id, dto);
		
		return new ResponseEntity<>(employee,HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/employees/{pname}/{dname}/{rname}")
	
	public ResponseEntity<List<Employee>> getAllEmployeeWithProjectDeptRoleName(@Valid @PathVariable("pname") String pname,@PathVariable("dname") String dname,@PathVariable("rname") String rname) throws EmployeeException, ProjectException, DepartmentException, RoleException{
		
		List<Employee> employees = employeeService.findEmployeebyProjectDeptAndRole(pname, dname, rname);
		
		return new ResponseEntity<>(employees,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/employees")
	public ResponseEntity<List<EmployeeExperienceDTO>> getNExperincedEmployee(@Valid @RequestParam("exp") Integer n) throws EmployeeException{
		List<EmployeeExperienceDTO> employees =employeeService.findTopNExperienceEmployee(n);
		
		return new ResponseEntity<>(employees,HttpStatus.OK);
	}
	
}
