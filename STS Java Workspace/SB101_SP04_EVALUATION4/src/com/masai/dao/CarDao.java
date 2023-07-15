package com.masai.dao;

import java.util.List;
import java.util.Map;

import com.masai.model.Car;
import com.masai.model.FullCarDetails;

public interface CarDao {
	
	public String addCar(Car car);
	
	public List<FullCarDetails> getFullCarDetails();
	
	public String updateCarDetailsWithCarId(Car car);
	
	public String deleteCarDetailsUsingCarId(String id);
	
	public Map<String,Integer> getCompanyNameWithModelCount();
	
	
}
