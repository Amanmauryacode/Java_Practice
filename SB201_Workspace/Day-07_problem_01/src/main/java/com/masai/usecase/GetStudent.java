package com.masai.usecase;

import com.masai.dao.CollageDAO;
import com.masai.dao.CollageDAOImpl;
import com.masai.entity.Student;
import com.masai.exception.StudentNotFoundException;

public class GetStudent {

	public static void main(String[] args) {
		CollageDAO dao = new CollageDAOImpl();
		
		try {
			Student std = dao.getStudent(1);
			System.out.println(std.getStudentId());
			System.out.println(std.getStudentName());
			System.out.println(std.getCourse());
			System.out.println(std.getLocation());
			System.out.println(std.getTeacherList());
		} catch (StudentNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
}
