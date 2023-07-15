package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entity.Role;
import com.masai.entity.User;
import com.masai.entity.Vehicle;
import com.masai.exception.UserException;
import com.masai.exception.VehicleException;
import com.masai.repository.UserRepository;
import com.masai.repository.VehicleRepository;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleRepository vehicleRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public List<Vehicle> getAllVehicles() throws VehicleException {
		
		List<Vehicle> vehicles = vehicleRepo.findAll();
		if(vehicles.isEmpty())throw new VehicleException("No Vehicle found in record");
		return vehicles;
	}

	@Override
	public Vehicle getVehicleById(Integer vId, Integer uId) throws VehicleException, UserException {
		Optional<Vehicle> opt = vehicleRepo.findById(vId);
		if(opt.isEmpty())throw new VehicleException("No vehicle find with id : "+vId);
		Vehicle vehicle = opt.get();
		if(vehicle.getUser().getRole() == Role.DRIVER) {
			if(vehicle.getUser().getId() == uId) {
				return vehicle;
			}
			throw new UserException("Driver cannot access other vehicle"); 
		}
		return vehicle;
	}

	@Override
	public Vehicle updateVehicle(Vehicle vehicle, Integer uId) throws VehicleException, UserException {
		
		if(vehicle == null)throw new VehicleException("Vehicle details required");
		Optional<Vehicle> vOpt = vehicleRepo.findById(vehicle.getId());
		if(vOpt.isEmpty()) {
			throw new VehicleException("Vehicle not excist in record");
		}
		Vehicle eVehicle = vOpt.get();
		eVehicle.setVehicleColor(vehicle.getVehicleColor());
		eVehicle.setVehicleNumber(vehicle.getVehicleNumber());
		Optional<User> opt= userRepo.findById(uId); 
		if(opt.isEmpty())throw new UserException("User not found"); 
		User user = opt.get();
		if(user.getRole() == Role.DRIVER) {
			if(user.getVehicle().getId() == vehicle.getId()) {
				return vehicleRepo.save(eVehicle);
			}
			throw new UserException("Driver cannot update others vehicle"); 
		}
		return vehicleRepo.save(eVehicle);
	}

	@Override
	public Vehicle removeVehicle(Integer vId, Integer uId) throws VehicleException, UserException {
		Optional<Vehicle> opt = vehicleRepo.findById(vId);
		if(opt.isEmpty())throw new VehicleException("No vehicle find with id : "+vId);
		Vehicle vehicle = opt.get();
		if(vehicle.getUser().getRole() == Role.DRIVER) {
			if(vehicle.getUser().getId() == uId) {
				vehicleRepo.delete(vehicle);
				return vehicle;
			}
			throw new UserException("Driver cannot access other vehicle"); 
		}
		vehicleRepo.delete(vehicle);
		return vehicle;
	}

}
