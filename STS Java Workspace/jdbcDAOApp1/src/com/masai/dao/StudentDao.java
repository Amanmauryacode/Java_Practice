package com.masai.dao;

import java.util.List;

import com.masai.model.Student;

public interface StudentDao {

	public String insetStudentDetails(int roll,String name,String address,int marks);
	
	public String insetStudentDetails2(Student student);
	
	public int getStudentMarksByRoll(int roll);
	
	public Student getStudentDetailsByRoll(int roll);
	
	public List<Student> getAllStudentDetails();
}
