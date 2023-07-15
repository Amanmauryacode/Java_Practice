package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.CarDao;
import com.masai.dao.CarDaoImpl;

public class DeleteCarDetailsByCarId {

	public static void main(String[] args) {

		Scanner sc =new Scanner(System.in);
		
		System.out.println("Enter The Car ID to Delete Car Details From DataBase : ");
		
		String id = sc.next();
		
		
		CarDao dao = new CarDaoImpl();
		
		String msg = dao.deleteCarByCarId(id);
		System.out.println(msg);
	}

}
