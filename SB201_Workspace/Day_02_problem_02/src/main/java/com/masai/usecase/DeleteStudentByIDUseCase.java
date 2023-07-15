package com.masai.usecase;

import java.util.Scanner;

import com.masai.Dao.masaiDAO;
import com.masai.Dao.Impl.masaiDaoImpl;

public class DeleteStudentByIDUseCase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter ID To Delete Student : ");
		String id = sc.next();
		
		try {
			int ID = Integer.parseInt(id);
			masaiDAO dao = new masaiDaoImpl();
			String msg = dao.deleteStudentById(ID);
			System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Invalid Input");
		}
	}
}
