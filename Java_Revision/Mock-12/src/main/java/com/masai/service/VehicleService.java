package com.masai.service;

import java.util.List;

import com.masai.entity.Vehicle;
import com.masai.exception.UserException;
import com.masai.exception.VehicleException;

public interface VehicleService {

	public List<Vehicle> getAllVehicles() throws VehicleException;

	public Vehicle getVehicleById(Integer vId, Integer uId) throws VehicleException, UserException;
	
	public Vehicle updateVehicle(Vehicle vehicle,Integer uId)throws VehicleException, UserException;
	
	public Vehicle removeVehicle(Integer vId, Integer uId)throws VehicleException, UserException;
}
