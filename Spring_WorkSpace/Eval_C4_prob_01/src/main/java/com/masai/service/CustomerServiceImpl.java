package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CustomerException;
import com.masai.model.Booking;
import com.masai.model.Customer;
import com.masai.repository.CustomerDao;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public Customer addCustomer(Customer customer) throws CustomerException {
		if(customer==null)throw new CustomerException("Customer Details Not FOund");
		
		return customerDao.save(customer);
	}

	@Override
	public Customer addBookingToCustomer(Integer id, Booking booking) throws CustomerException {
		
		Optional<Customer> opt = customerDao.findById(id);
		if(opt.isEmpty())throw new CustomerException("Customer Details Not FOund");
		
		Customer c = opt.get();
		c.getBookings().add(booking);
		booking.setCustomer(c);
		
		return customerDao.save(c);
	}

}
