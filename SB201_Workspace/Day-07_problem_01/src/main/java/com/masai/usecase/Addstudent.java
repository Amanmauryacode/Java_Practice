package com.masai.usecase;

import java.util.List;

import com.masai.dao.CollageDAO;
import com.masai.dao.CollageDAOImpl;
import com.masai.entity.Student;
import com.masai.entity.Teacher;

public class Addstudent {

	public static void main(String[] args) {

		Teacher t1 = new Teacher();
		t1.setTeacherName("Rahul Bhai");
		t1.setSubject("SpringBoot");

		Student s1 = new Student();
		s1.setStudentName("Rounak");
		s1.setLocation("Varansi");
		s1.setCourse("SpringBoot");

		List<Student> list = t1.getStudentList();
		list.add(s1);
		t1.setStudentList(list);

//		List<Teacher> list1 = s1.getTeacherList();
//		list1.add(t1);
//		s1.setTeacherList(list1);

		CollageDAO dao = new CollageDAOImpl();

		dao.addStudent(s1);
		System.out.println("Done");
	}
}
