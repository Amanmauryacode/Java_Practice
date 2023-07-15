package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.CarDao;
import com.masai.dao.CarDaoImpl;
import com.masai.model.Car;

public class AddCarDetails {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("Enter Car ID : ");
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
		
		car.setCarId(carID);
		car.setModelName(carModel);
		car.setPrice(carPrice);
		car.setTotalSeats(seats);
		car.setCompanyID(companyID);
		
		CarDao dao = new CarDaoImpl();
		String msg = dao.addCarDetails(car);
		System.out.println(msg);
			
		
		
		
	}
}
