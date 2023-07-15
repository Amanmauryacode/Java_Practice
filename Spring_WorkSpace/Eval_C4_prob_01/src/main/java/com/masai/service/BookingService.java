package com.masai.service;

import java.time.LocalDate;
import java.util.List;

import com.masai.exception.BookingException;
import com.masai.exception.CustomerException;
import com.masai.model.Booking;

public interface BookingService {

	public Booking addBooking(Booking booking)throws CustomerException;
	
	public List<Booking> bookingListBtDate(Integer id,LocalDate s_date,LocalDate e_date)throws BookingException,CustomerException;
}
