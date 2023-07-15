package com.masai.usecases;

import java.util.List;

import com.masai.dao.CarDao;
import com.masai.dao.CarDaoImpl;
import com.masai.model.FullCarDetails;

public class PrintFullCarDetails {

	public static void main(String[] args) {
		
		CarDao dao = new CarDaoImpl();
		
		List<FullCarDetails> carList = dao.getFullCarDetails();
		
		carList.forEach(System.out::print);
	}

}
