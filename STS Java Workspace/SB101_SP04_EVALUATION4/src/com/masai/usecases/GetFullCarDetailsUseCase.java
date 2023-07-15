package com.masai.usecases;

import java.util.List;

import com.masai.dao.CarDao;
import com.masai.dao.CarDaoImpl;
import com.masai.model.FullCarDetails;

public class GetFullCarDetailsUseCase {

	public static void main(String[] args) {
		CarDao dao = new CarDaoImpl();
		
		List<FullCarDetails> cars = dao.getFullCarDetails();
		cars.forEach(System.out::println);
	}
	
}
