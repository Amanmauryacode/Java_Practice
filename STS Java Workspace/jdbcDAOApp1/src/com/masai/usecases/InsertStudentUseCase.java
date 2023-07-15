package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.StudentDao;
import com.masai.dao.StudentDaoImpl;
import com.masai.model.Student;

public class InsertStudentUseCase {

	public static void main(String[] args) {
		

		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Roll : ");
		int roll = sc.nextInt();
		
		System.out.print("Enter Name : ");
		String name = sc.next();
		
		System.out.print("Enter Address : ");
		String address = sc.next();
		
		System.out.print("Enter Marks : ");
		int marks = sc.nextInt();
		
		
		StudentDao dao = new StudentDaoImpl();
		
		Student student = new Student();
		
		student.setRoll(roll);
		student.setName(name);
		student.setAddress(address);
		student.setMarks(marks);
		
		String result  = dao.insetStudentDetails2(student);
		System.out.println(result);
	}

}
