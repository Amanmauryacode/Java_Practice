package com.masai.dao;

import java.util.List;
import java.util.Map;

import com.masai.model.Car;
import com.masai.model.FullCarDetails;

public interface CarDao {

	public String addCarDetails(Car car);
	
	public List<FullCarDetails>  getFullCarDetails();
	
	public String updateCarDetailsByCarID(String carID,String modelName,int price,int seats,String companyID);
	
	public String deleteCarByCarId(String carID);
	
	public Map<String,Integer> getCompanyNameWithModelCount();
}
