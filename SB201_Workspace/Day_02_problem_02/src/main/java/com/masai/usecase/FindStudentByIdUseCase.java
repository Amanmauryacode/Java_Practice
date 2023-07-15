package com.masai.usecase;

import java.util.Scanner;

import com.masai.Dao.masaiDAO;
import com.masai.Dao.Impl.masaiDaoImpl;
import com.masai.entity.Student;

public class FindStudentByIdUseCase {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Id To Get Student Details : ");
		String id = sc.next();
		
		try {
			int Id = Integer.parseInt(id);
			masaiDAO dao = new masaiDaoImpl();
			Student student = dao.findStudentById(Id);
			if(student == null) {
				System.out.println("Student Not Found With Id : "+Id);
			}else
				System.out.println(student);
		} catch (Exception e) {
			System.out.println("Invalid Input ");
		}
		
	}

}
