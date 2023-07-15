package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.CarDao;
import com.masai.dao.CarDaoImpl;

public class DeleteCarDetailsUsingCarIdUseCase {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Car ID to Delete Car Details : ");
		String id = sc.next();
		
		
		CarDao dao = new CarDaoImpl();
		
		String msg = dao.deleteCarDetailsUsingCarId(id);
		System.out.println(msg);
		
		
	}
}
