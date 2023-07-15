package com.masai.usecase;

import java.util.Scanner;

import com.masai.Dao.masaiDAO;
import com.masai.Dao.Impl.masaiDaoImpl;

public class UpdateStudentDetailsUseCase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Id To Update Level : ");
		String id = sc.next();
		
		System.out.print("Enter New Level : ");
		String level = sc.next();
		
		try {
			int ID = Integer.parseInt(id);
			int lvl = Integer.parseInt(level);
			
			masaiDAO dao = new masaiDaoImpl();
			String msg = dao.updateStudentLevel(ID, lvl);
			
			System.out.println(msg);
		} catch (Exception e) {
			System.out.println("Invalid Input");
		}
	}
}
