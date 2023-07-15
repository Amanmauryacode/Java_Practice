package com.masai.Usecases;

import java.util.Scanner;

import com.masai.Dao.EmployeeDao;
import com.masai.Dao.Impl.EmployeeDaoImpl;
import com.masai.Entity.Employee;
import com.masai.Exception.EmployeeException;

public class RegisterEmployeeUseCase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Employee Id : ");
		String empId = sc.next();
		
		System.out.print("Enter Employee Name : ");
		String name = sc.next();
		
		System.out.print("Enter Employee Address : ");
		String address = sc.next();
		
		System.out.print("Enter Employee Salary : ");
		String salary = sc.next();
		
		Employee emp = new Employee();
		
		try {
			emp.setEmpID(Integer.parseInt(empId));
			emp.setName(name);
			emp.setAddress(address);
			emp.setSalary(Integer.parseInt(salary));
			EmployeeDao dao = new EmployeeDaoImpl();
			String msg = dao.registerEmployee(emp);
			
			System.out.println(msg);
		} catch(EmployeeException eme ) {
			System.out.println(eme.getMessage());
		} catch (Exception e) {
			System.out.println("Invalid Input " + e.getMessage());
		}
		
	}
}
