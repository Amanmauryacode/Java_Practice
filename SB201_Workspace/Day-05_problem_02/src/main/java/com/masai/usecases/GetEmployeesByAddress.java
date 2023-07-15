package com.masai.usecases;

import java.util.List;

import com.masai.Dao.EmployeDaoImpl;
import com.masai.Dao.EmployeeDao;
import com.masai.entity.Employee;
import com.masai.exception.EmployeeException;

public class GetEmployeesByAddress {

	public static void main(String[] args) {
		EmployeeDao dao = new EmployeDaoImpl();
		try {
			List<Employee> list = dao.getEmployeesByAddress("abc");
			list.forEach(System.out::println);
		} catch (EmployeeException e) {
			System.out.println(e.getMessage());
		}
	}
}
