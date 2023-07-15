package com.masai.usecase;

import java.util.List;

import com.masai.dao.CollageDAO;
import com.masai.dao.CollageDAOImpl;
import com.masai.entity.Student;
import com.masai.entity.Teacher;
import com.masai.exception.StudentNotFoundException;
import com.masai.exception.TeacherNotFoundException;

public class RegisterTeacherWithDiffStudents {

	public static void main(String[] args) {
//		Teacher t1 = new Teacher();
//		t1.setTeacherName("Rahul Bhai");
//		t1.setSubject("SpringBoot");
//		
//		Student s1 = new Student();
//		s1.setStudentName("Aman");
//		s1.setLocation("Varanasi");
//		s1.setCourse("SpringBoot");
////		s1.getTeacher().add(t1);
////		
////		t1.getStudent().add(s1);
//		
//		List<Student> list = t1.getStudentList();
//		list.add(s1);
//		t1.setStudentList(list);
		
		CollageDAO dao = new CollageDAOImpl();
		
		try {
			dao.registerTeacherWithDiffStudents(1, 2);
		} catch (TeacherNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (StudentNotFoundException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Done");
	}
}
