package com.masai.Usecases;

import java.util.Scanner;

import com.masai.Dao.EmployeeDao;
import com.masai.Dao.Impl.EmployeeDaoImpl;
import com.masai.Entity.Employee;
import com.masai.Exception.EmployeeException;

public class GetEmployeeUsecase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Employee Id To Get Details : ");
		String id = sc.next();
		
		try {
			EmployeeDao dao = new EmployeeDaoImpl();
			Employee emp = dao.getEmployeeById(Integer.parseInt(id));
			System.out.println(emp);
		} catch (EmployeeException eme) {
			// TODO: handle exception
			System.out.println(eme.getMessage());
		} catch (Exception e) {
		// TODO: handle exception
			System.out.println("Invalid Input " + e.getMessage());
		}
		
	}
}
