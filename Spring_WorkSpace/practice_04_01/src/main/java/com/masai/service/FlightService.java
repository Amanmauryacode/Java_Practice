package com.masai.service;

import java.time.LocalDateTime;
import java.util.List;

import com.masai.dto.FlightDTO;
import com.masai.exception.FlightException;
import com.masai.model.Flight;

public interface FlightService {
	public List<FlightDTO> getAllFlights() throws FlightException; 
//	[Points : 0.25]

	public FlightDTO getFlightByFlightNumber(Long flightNumber) throws FlightException; 
	//	[Points : 0.25]

	public Flight addFlight(Flight flight) throws FlightException; 
	//	[Points : 0.25]

	public FlightDTO updateFlight(Long flightNumber, FlightDTO flightDTO) throws FlightException; 
	//	[Points : 0.25]

	public Flight deleteFlight(Long flightNumber) throws FlightException; 
	//	[Points : 0.25]

	public List<FlightDTO> searchFlights(String departureAirportCode, String arrivalAirportCode, LocalDateTime departureDateTime) throws FlightException; 
	//	[Points : 0.75]

	public List<FlightDTO> searchFlightsByAirline(String airline) throws FlightException; 
	//	[Points : 0.25]

	public List<FlightDTO> searchFlightsByFare(Double minFare, Double maxFare) throws FlightException; 
	//	[Points : 0.75]
	
	public List<Flight> getAllFlightsSortedByFare() throws FlightException;
}
