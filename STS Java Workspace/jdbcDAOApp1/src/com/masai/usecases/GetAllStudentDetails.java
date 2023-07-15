package com.masai.usecases;

import java.util.List;

import com.masai.dao.StudentDao;
import com.masai.dao.StudentDaoImpl;
import com.masai.model.Student;

public class GetAllStudentDetails {

	public static void main(String[] args) {
		
		StudentDao dao = new StudentDaoImpl();
		
		List<Student> students  = dao.getAllStudentDetails();
		
		for(int i=0;i<students.size();i++) {
			System.out.println(students.get(i));
		}
		
	}
	
}
