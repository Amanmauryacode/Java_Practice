package com.masai.service;

import com.masai.exception.CustomerException;
import com.masai.model.Booking;
import com.masai.model.Customer;

public interface CustomerService {

	public Customer addCustomer(Customer customer)throws CustomerException;
	
	public Customer addBookingToCustomer(Integer id,Booking booking)throws CustomerException;
}
