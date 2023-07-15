package com.masai.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.masai.dto.FlightDTO;
import com.masai.exception.FlightException;
import com.masai.model.Flight;
import com.masai.repository.FlightDao;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	private FlightDao flightDao;

	@Override
	public List<FlightDTO> getAllFlights() throws FlightException {

		List<FlightDTO> dto = flightDao.getAllFlights();
		if (dto.isEmpty())
			throw new FlightException("No Flight Found! ");

		return dto;
	}

	@Override
	public FlightDTO getFlightByFlightNumber(Long flightNumber) throws FlightException {
		FlightDTO dto = flightDao.getFlightByFlightNo(flightNumber);
		if (dto == null)
			throw new FlightException("No Flight Found With Flight Number " + flightNumber);
		return dto;
	}

	@Override
	public Flight addFlight(Flight flight) throws FlightException {
		if (flight == null)
			throw new FlightException("Flight Details Not Found! ");

		return flightDao.save(flight);
	}

	@Override
	public FlightDTO updateFlight(Long flightNumber, FlightDTO flightDTO) throws FlightException {

		if (flightDTO == null)
			throw new FlightException("New Flight Details Not Found! ");

		Optional<Flight> opt = flightDao.findById(flightNumber);
		if (opt.isEmpty())
			throw new FlightException("Flight Details Not Found With Flight No. " + flightNumber);

		Flight flight = opt.get();
		flight.setAirline(flightDTO.getAirline());
		flight.getDepartureAirport().setAirportCode(flightDTO.getDepartureAirportCode());
		flight.getArrivalAirport().setAirportCode(flightDTO.getArrivalAirportCode());
		flight.setArrivalDateTime(flightDTO.getArrivalDateTime());
		flight.setDepartureDateTime(flightDTO.getDepartureDateTime());
		flight.setFlightFare(flightDTO.getFlightFare());
		flightDao.save(flight);

		return flightDao.getFlightByFlightNo(flightNumber);

	}

	@Override
	public Flight deleteFlight(Long flightNumber) throws FlightException {
		Optional<Flight> opt = flightDao.findById(flightNumber);
		if (opt.isEmpty())
			throw new FlightException("Flight Details Not Found With Flight No. " + flightNumber);

		Flight flight = opt.get();
		flightDao.delete(flight);
		return flight;
	}

	@Override
	public List<FlightDTO> searchFlights(String departureAirportCode, String arrivalAirportCode,
			LocalDateTime departureDateTime) throws FlightException {

		List<FlightDTO> dto = flightDao.getFlightBydepartureAirportCodeAndArrivalCode(arrivalAirportCode,
				departureAirportCode,departureDateTime);
		if (dto.isEmpty())
			throw new FlightException("No Flight Found! ");

		return dto;
	}

	@Override
	public List<FlightDTO> searchFlightsByAirline(String airline) throws FlightException {
		List<FlightDTO> dto = flightDao.getFlightDetailsByAirline(airline);
		if(dto.isEmpty())throw new FlightException("No Flight Found With Airline "+airline);
		return dto;
	}

	@Override
	public List<FlightDTO> searchFlightsByFare(Double minFare, Double maxFare) throws FlightException {
		
		
		List<FlightDTO> dto = flightDao.getFlightDetailsBetweenFair(minFare, maxFare);
		if(dto.isEmpty())throw new FlightException("No Flight Found With Between Fair "+minFare+","+maxFare);
		
		return dto;
	}

	@Override
	public List<Flight> getAllFlightsSortedByFare() throws FlightException {

		Sort so = Sort.by("flightFare").ascending();
		List<Flight> flight = flightDao.findAll();
		if(flight.isEmpty())throw new FlightException("No Flight Found! ");
		
		return flight;
	}

}
