package com.masai.Usecases;

import java.util.Scanner;

import com.masai.Dao.EmployeeDao;
import com.masai.Dao.Impl.EmployeeDaoImpl;
import com.masai.Entity.Employee;
import com.masai.Exception.EmployeeException;

public class UpdateEmployeSalaryUseCase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter Employee Id To Update Details : ");
		String id = sc.next();
		
		System.out.print("Enter Employee New Salary : ");
		String salary = sc.next();

		try {
			EmployeeDao dao = new EmployeeDaoImpl();
			String msg = dao.updateEmployeeSalary(Integer.parseInt(id),Integer.parseInt(salary));
			System.out.println(msg);
		} catch (EmployeeException eme) {
			// TODO: handle exception
			System.out.println(eme.getMessage());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Invalid Input " + e.getMessage());
		}
	}
}
