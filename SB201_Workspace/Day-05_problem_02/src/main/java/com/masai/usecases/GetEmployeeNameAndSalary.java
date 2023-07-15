package com.masai.usecases;

import java.util.List;

import com.masai.Dao.EmployeDaoImpl;
import com.masai.Dao.EmployeeDao;
import com.masai.exception.EmployeeException;

public class GetEmployeeNameAndSalary {

	public static void main(String[] args) {
		EmployeeDao dao = new EmployeDaoImpl();
		try {
			Object[] list = dao.getEmployeeNameAndSalary(13);
			
			
			System.out.println(list[0]+" " + list[1]);
			
			
		} catch (EmployeeException e) {
			System.out.println(e.getMessage());
		}
	}
}
