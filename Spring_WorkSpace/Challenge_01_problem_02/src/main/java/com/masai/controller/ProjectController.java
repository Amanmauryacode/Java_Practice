package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.DepartmentException;
import com.masai.exception.ProjectException;
import com.masai.model.Project;
import com.masai.model.ProjectEmployeListDTO;
import com.masai.service.ProjectService;

@RestController
public class ProjectController {
	@Autowired
	private ProjectService projectService;
	@GetMapping("/projects/{id}")
	public ResponseEntity<ProjectEmployeListDTO> getProjectWithListOfEmployeById(@PathVariable("id") Integer id) throws ProjectException {

		ProjectEmployeListDTO dto= projectService.getProjectWithEmployeListAndDeptById(id);
		return new ResponseEntity<>(dto,HttpStatus.ACCEPTED);
	}
	@PatchMapping("/projects/{pid}/{did}")
	public ResponseEntity<Project> assignProjectToDiffDeptById(@PathVariable("pid") Integer projectID,@PathVariable("did") Integer deptId) throws ProjectException, DepartmentException{
		
		Project p = projectService.assignProjectToDiffDeptbyId(projectID, deptId);
		return new ResponseEntity<>(p,HttpStatus.ACCEPTED);
	}
}
