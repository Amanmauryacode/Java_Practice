package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.StudentDao;
import com.masai.dao.StudentDaoImpl;

public class GetMarksUseCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter  Roll to get Student marks : ");
		int roll = sc.nextInt();
		
		StudentDao dao = new StudentDaoImpl();
		
		int marks = dao.getStudentMarksByRoll(roll);
		
		if(marks>0) {
			System.out.println("Student marks is : "+marks);
		}else
			System.out.println("Student does not exist with Roll :"+ roll);
		
		
	}

}
