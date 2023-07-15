package com.masai.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.DepartmentException;
import com.masai.exception.EmployeeException;
import com.masai.exception.ProjectException;
import com.masai.exception.RoleException;
import com.masai.model.AssignProjectRoleDTO;
import com.masai.model.Employee;
import com.masai.model.EmployeeExperienceDTO;
import com.masai.model.Project;
import com.masai.model.Role;
import com.masai.repository.EmployeeDao;
import com.masai.repository.ProjectDao;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private ProjectDao proDao;

	@Override
	public Employee addEmployee(Employee employee)
			throws EmployeeException, ProjectException, RoleException, DepartmentException {

		if (employee != null) {

			List<Project> list = employee.getProjects();
			if (list.isEmpty())
				throw new ProjectException("Project Not Found For Employee!");
			for (Project p : list) {
				p.getEmployees().add(employee);
				p.getDepartments().getProjects().add(p);
			}

			List<Role> roles = employee.getRoles();

			if (roles.isEmpty())
				throw new RoleException("Role Not Found!");

			for (Role r : roles) {
				r.getEmployees().add(employee);
			}

			return employeeDao.save(employee);
		} else
			throw new EmployeeException("Employee Cannot Be Null!");

	}

	@Override
	public Employee getEmployeeById(Integer id) throws EmployeeException {

		Optional<Employee> opt = employeeDao.findById(id);

		if (opt.isEmpty()) {
			throw new EmployeeException("Employee Not Found By Id : " + id);
		}

		return opt.get();
	}

	@Override
	public Employee AssignProjectAndRoleToEmployeeById(Integer id, AssignProjectRoleDTO dto)
			throws EmployeeException {
		
		Optional<Employee> opt =employeeDao.findById(id);
		
		if(opt.isEmpty())
			throw new EmployeeException("Employee Not Found With Id : "+id);
		
		Employee e = opt.get();
		e.getProjects().add(dto.getProject());
		e.getRoles().add(dto.getRole());
		return employeeDao.save(e);


		
	}

	@Override
	public List<Employee> findEmployeebyProjectDeptAndRole(String pName, String dname, String rname)
			throws EmployeeException, ProjectException, DepartmentException, RoleException {
		
		Project projects = proDao.getProjectByProjectNameAndDept(pName, dname);
		
		if(projects ==null)throw new ProjectException("No project found with name "+pName+" And Department name "+dname);
		
		List<Employee> emp = projects.getEmployees();
		
		List<Employee> emp2 = new ArrayList<>();
		
		for(Employee e : emp) {
			List<Role> list = e.getRoles();
			for(Role r:list) {
				if(r.getRoleName().equalsIgnoreCase(rname)) {
					emp2.add(e);
				}
			}
			
		}
		
		if(emp2.isEmpty())throw new EmployeeException("Employee Not Found!");
		return emp2;
	}

	@Override
	public List<EmployeeExperienceDTO> findTopNExperienceEmployee(Integer n) throws EmployeeException {
		
		List<EmployeeExperienceDTO> employee = new ArrayList<>();
		List<Employee>  list = employeeDao.findAll();
		
		list.sort((e1,e2)-> {
			if(ChronoUnit.DAYS.between(e1.getHireDate(), e1.getHireDate()) >0) {
				return -1;
			}
			return 1;
		});
		if(list.size() < n)throw new EmployeeException("No Employee Found !");
		
		int count =0;
		for(Employee e:list) {
			EmployeeExperienceDTO dto = new EmployeeExperienceDTO();
			dto.setEmployee(e);
			dto.setExperience(ChronoUnit.YEARS.between(e.getHireDate(), LocalDate.now()));
			employee.add(dto);
			count++;
			if(count==n)break;
		}
		
		return employee;
	}

	

}
