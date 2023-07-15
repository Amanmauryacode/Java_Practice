package com.masai.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.BookingException;
import com.masai.exception.CustomerException;
import com.masai.model.Booking;
import com.masai.model.Customer;
import com.masai.repository.BookingDao;
import com.masai.repository.CustomerDao;
@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingDao bookingDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public Booking addBooking(Booking booking) throws CustomerException {
		
		Optional<Customer> opt = customerDao.findById(booking.getCustomer().getCustomerId());
		if(opt.isEmpty())throw new CustomerException("Customer Not Found!");
		
		booking.setStatus("Confirmed");
		return bookingDao.save(booking);
	}

	@Override
	public List<Booking> bookingListBtDate(Integer id, LocalDate s_date, LocalDate e_date) throws CustomerException, BookingException {
		Optional<Customer> opt = customerDao.findById(id);
		if(opt.isEmpty())throw new CustomerException("Customer Not Found!");
		
		List<Booking> bookings =bookingDao.bookingListBtDate(id, s_date, e_date);
		
		if(bookings.isEmpty())throw new BookingException("No Booking Found Between Date "+s_date+" And "+e_date);
		return bookings;
	}

}
