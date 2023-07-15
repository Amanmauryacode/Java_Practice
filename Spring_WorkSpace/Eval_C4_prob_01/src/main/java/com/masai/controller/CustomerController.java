package com.masai.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.CustomerException;
import com.masai.model.Booking;
import com.masai.model.Customer;
import com.masai.service.CustomerService;

import jakarta.validation.Valid;

@RestController
public class CustomerController {

	private CustomerService cs;
	
	@PostMapping("/customers")
	public ResponseEntity<Customer> addCustomer(@Valid @RequestBody Customer customer) throws CustomerException{
		
		Customer c = cs.addCustomer(customer);
		
		return new ResponseEntity<>(c,HttpStatus.CREATED);
	}
	
	@PatchMapping("/customers/New_Booking/{id}")
	public ResponseEntity<Customer> addNewBookingForCustomer(@Valid @PathVariable Integer id,
			@RequestBody Booking booking) throws CustomerException{
		Customer c = cs.addBookingToCustomer(id, booking);
		return new ResponseEntity<>(c,HttpStatus.ACCEPTED);
	}
}
