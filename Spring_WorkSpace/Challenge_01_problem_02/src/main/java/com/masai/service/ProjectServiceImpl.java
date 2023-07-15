package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.DepartmentException;
import com.masai.exception.ProjectException;
import com.masai.model.Department;
import com.masai.model.Project;
import com.masai.model.ProjectEmployeListDTO;
import com.masai.repository.DepartmentDao;
import com.masai.repository.ProjectDao;

@Service
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	private ProjectDao projectDao;
	
	@Autowired
	private DepartmentDao deptDao;

	@Override
	public ProjectEmployeListDTO getProjectWithEmployeListAndDeptById(Integer id) throws ProjectException {

		Optional<Project> opt = projectDao.findById(id);
		if(opt.isPresent()) {
			ProjectEmployeListDTO dto = new ProjectEmployeListDTO();
			dto.setEmployees(opt.get().getEmployees());
			dto.setProject(opt.get());
			return dto;
		}
		else
			throw new ProjectException("Project Not Found With Id "+id);
	}

	@Override
	public Project assignProjectToDiffDeptbyId(Integer projectId, Integer DeptId)
			throws ProjectException, DepartmentException {

		Optional<Project> opt1 = projectDao.findById(projectId);
		
		Optional<Department> opt2 = deptDao.findById(DeptId);
		if(opt1.isPresent()) {
			if(opt2.isPresent()) {
				Project p = opt1.get();
				Department d = opt2.get();
				d.getProjects().add(p);
				p.setDepartments(d);

				return projectDao.save(p);
			}else {
				throw new DepartmentException("Department Not Found With id : "+DeptId);
			}
		}else {
			throw new ProjectException("Project Not Found With id : "+projectId);
			
		}
		
	}

}
