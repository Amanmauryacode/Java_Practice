package com.masai.usecase;

import java.util.List;

import com.masai.dao.CollageDAO;
import com.masai.dao.CollageDAOImpl;
import com.masai.entity.Student;
import com.masai.entity.Teacher;
import com.masai.exception.StudentNotFoundException;

public class RegisterTeacher {

	public static void main(String[] args) {
		Teacher t1 = new Teacher();
		t1.setTeacherName("Shubhendu");
		t1.setSubject("JavaScript");

		Student s1 = new Student();
		s1.setStudentName("Anuj");
		s1.setLocation("Varansi");
		s1.setCourse("JavaScript");

		t1.getStudentList().add(s1);

		s1.getTeacherList().add(t1);
		
		CollageDAO dao = new CollageDAOImpl();
		try {
			dao.registerTeacher(t1, 1);
		} catch (StudentNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
