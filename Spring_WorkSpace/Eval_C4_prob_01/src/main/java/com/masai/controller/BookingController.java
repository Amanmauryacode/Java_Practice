package com.masai.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.BookingException;
import com.masai.exception.CustomerException;
import com.masai.model.Booking;
import com.masai.service.BookingService;

import jakarta.validation.Valid;

@RestController
public class BookingController {
	@Autowired
	private BookingService bs;

	@PostMapping("/bookings")
	public ResponseEntity<Booking> addHotel(@Valid @RequestBody Booking booking) throws CustomerException {

		Booking b = bs.addBooking(booking);
		return new ResponseEntity<>(b, HttpStatus.CREATED);
	}

	@GetMapping("/bookings/cId/{id}")
	public ResponseEntity<List<Booking>> customerBookingHistoryBtDate(@Valid @PathVariable Integer id,
			@RequestParam("s_date") LocalDate s_date, @RequestParam("e_date") LocalDate e_date) throws BookingException, CustomerException {

		List<Booking> bookings = bs.bookingListBtDate(id, s_date, e_date);
		return new ResponseEntity<>(bookings, HttpStatus.CREATED);
	}
}
