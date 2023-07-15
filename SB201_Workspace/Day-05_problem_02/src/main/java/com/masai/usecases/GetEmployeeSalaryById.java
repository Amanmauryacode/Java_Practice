package com.masai.usecases;

import com.masai.Dao.EmployeDaoImpl;
import com.masai.Dao.EmployeeDao;
import com.masai.exception.EmployeeException;

public class GetEmployeeSalaryById {

	public static void main(String[] args) {
		EmployeeDao dao = new EmployeDaoImpl();
		try {
			int salary = dao.getEmployeeSalaryById(12);
			
			
			System.out.println(salary);
			
			
		} catch (EmployeeException e) {
			System.out.println(e.getMessage());
		}
	}
}
