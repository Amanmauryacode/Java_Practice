package com.masai.dao;

import com.masai.entity.Student;
import com.masai.entity.Teacher;
import com.masai.exception.StudentNotFoundException;
import com.masai.exception.TeacherNotFoundException;

public interface CollageDAO {

	public void addStudent(Student student); 
	public Student getStudent(int studentId)throws StudentNotFoundException; 
	public void registerTeacher(Teacher teacher, int id) throws StudentNotFoundException;
	public Teacher getTeacher(int teacherId) throws TeacherNotFoundException; 
	public void registerTeacherWithDiffStudents(int teacherId, int studentId) throws TeacherNotFoundException,StudentNotFoundException; 
}
