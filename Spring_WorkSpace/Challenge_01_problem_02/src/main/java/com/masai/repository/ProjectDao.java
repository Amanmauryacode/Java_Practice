package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.model.Project;
@Repository
public interface ProjectDao extends JpaRepository<Project, Integer> {
	
	@Query("select p from Project p where p.projectName = ?1 AND p.departments.departmentName = ?2 ")
	public Project getProjectByProjectNameAndDept(String pname,String dname);
	
}
