package com.masai.Dao;

import com.masai.entity.Student;

public interface masaiDAO {
	
	Student findStudentById(int id);

	String saveStudent(Student student);

	String deleteStudentById(int id);

	String updateStudentLevel(int id, int level);
}
