package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entity.Vehicle;
import com.masai.exception.UserException;
import com.masai.exception.VehicleException;
import com.masai.service.VehicleService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin("*")
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;
	
	@GetMapping("/vehicles")
	public ResponseEntity<List<Vehicle>> getAllVehicles() throws VehicleException{
		List<Vehicle> vehicles = vehicleService.getAllVehicles();
		return new ResponseEntity<>(vehicles,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/vehicles/{vid}/{uid}")
	public ResponseEntity<Vehicle> getVehiclesById(@PathVariable("vid") Integer vid,@PathVariable("uid") Integer uid) throws VehicleException, UserException{
		Vehicle vehicle = vehicleService.getVehicleById(vid, uid);
		return new ResponseEntity<>(vehicle,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/vehicles/{vid}")
	public ResponseEntity<Vehicle> updateVehiclesById(@Valid @RequestBody Vehicle vehicle, @PathVariable("uid") Integer uid) throws VehicleException, UserException{
		Vehicle v = vehicleService.updateVehicle(vehicle, uid);
		return new ResponseEntity<>(v,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/vehicles/{vid}/{uid}")
	public ResponseEntity<Vehicle> removeVehiclesById(@PathVariable("vid") Integer vid,@PathVariable("uid") Integer uid) throws VehicleException, UserException{
		Vehicle vehicle = vehicleService.removeVehicle(vid, uid);
		return new ResponseEntity<>(vehicle,HttpStatus.ACCEPTED);
	}
	
	
	
}
