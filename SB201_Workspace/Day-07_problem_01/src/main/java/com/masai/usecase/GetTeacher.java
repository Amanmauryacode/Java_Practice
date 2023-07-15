package com.masai.usecase;

import com.masai.dao.CollageDAO;
import com.masai.dao.CollageDAOImpl;
import com.masai.entity.Teacher;
import com.masai.exception.TeacherNotFoundException;

public class GetTeacher {

	public static void main(String[] args) {
		
		CollageDAO dao = new CollageDAOImpl();
		
		try {
			Teacher t = dao.getTeacher(2);
			System.out.println(t.getTeacherId());
			System.out.println(t.getTeacherName());
			System.out.println(t.getSubject());
			System.out.println(t.getStudentList());
		} catch (TeacherNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
