package com.masai.usecase;

import java.util.Scanner;

import com.masai.Dao.masaiDAO;
import com.masai.Dao.Impl.masaiDaoImpl;
import com.masai.entity.Student;

public class InsertStudentUseCase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Student Code : ");
		String studentCode = sc.next();
		
		System.out.print("Enter Student Email : ");
		String email = sc.next();
		
		System.out.print("Enter Student Address : ");
		String address = sc.next();
		
		System.out.print("Enter Student Course : ");
		String course = sc.next();
		
		System.out.print("Enter Course Level : ");
		String level = sc.next();
		
		try {
			int code = Integer.parseInt(studentCode);
			int lvl = Integer.parseInt(level);
			Student student = new Student();
			
			student.setStudentCode(code);
			student.setEmail(email);
			student.setAddress(address);
			student.setCourse(course);
			student.setLevel(lvl);
			
			masaiDAO dao= new masaiDaoImpl();
			String msg = dao.saveStudent(student);
			System.out.println(msg);
		} catch (Exception e) {
			System.out.println("Invalid Input ");
		}
		sc.close();
		
	}

}
