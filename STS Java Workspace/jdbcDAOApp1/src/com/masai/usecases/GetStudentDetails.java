package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.StudentDao;
import com.masai.dao.StudentDaoImpl;
import com.masai.model.Student;

public class GetStudentDetails {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Roll to get Studetn Details : ");
		
		int roll = sc.nextInt();
		
		StudentDao dao = new StudentDaoImpl();
		
		Student student  = dao.getStudentDetailsByRoll(roll);
		if(student != null) {
			System.out.println(student);
		}else
			System.out.println("Student does not exist...");
	}
	
}
