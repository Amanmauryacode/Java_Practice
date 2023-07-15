package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.CarDao;
import com.masai.dao.CarDaoImpl;
import com.masai.model.Car;

public class UpdateCarDetailsByCarId {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Car ID to Update Car Details : ");
		String carID = sc.next();
		
		System.out.print("Enter Car Model : ");
		String carModel = sc.next();
		
		System.out.print("Enter Car Price : ");
		int carPrice = sc.nextInt();
		
		System.out.print("Enter Car total Seats : ");
		int seats = sc.nextInt();
		
		System.out.print("Enter Car Company ID : ");
		String companyID = sc.next();
		
		Car car = new Car();
		
		CarDao dao = new CarDaoImpl();
		
		String msg = dao.updateCarDetailsByCarID(carID, carModel, carPrice, seats, companyID);
		System.out.println(msg);
		
		
	}

}
