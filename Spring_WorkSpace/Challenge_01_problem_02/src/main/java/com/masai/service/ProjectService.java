package com.masai.service;

import com.masai.exception.DepartmentException;
import com.masai.exception.ProjectException;
import com.masai.model.Project;
import com.masai.model.ProjectEmployeListDTO;

public interface ProjectService {
	
	public ProjectEmployeListDTO getProjectWithEmployeListAndDeptById(Integer id)throws ProjectException;
	
	public Project assignProjectToDiffDeptbyId(Integer projectId,Integer DeptId) throws ProjectException,DepartmentException;
}
