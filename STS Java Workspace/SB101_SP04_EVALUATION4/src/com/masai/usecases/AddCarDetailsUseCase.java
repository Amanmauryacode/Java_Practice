package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.CarDao;
import com.masai.dao.CarDaoImpl;
import com.masai.model.Car;

public class AddCarDetailsUseCase {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Car ID : ");
		String id = sc.next();
		
		System.out.print("Enter Car Model Name : ");
		String modelName = sc.next();
		
		System.out.print("Enter Car Price : ");
		int price = sc.nextInt();
		
		System.out.print("Enter Car Total Seats : ");
		int totalSeats = sc.nextInt();
		
		System.out.print("Enter Car Company ID : ");
		String companyId = sc.next();
		
		Car car = new Car();
		
		car.setCarId(id);
		car.setModelName(modelName);
		car.setPrice(price);
		car.setTotalSeats(totalSeats);
		car.setCompanyId(companyId);
		
		CarDao dao = new CarDaoImpl();
		String msg = dao.addCar(car);
		
		System.out.println(msg);
		
		
	}

}
