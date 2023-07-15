package com.masai.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.dto.FlightDTO;
import com.masai.exception.FlightException;
import com.masai.model.Flight;
import com.masai.service.FlightService;

import jakarta.validation.Valid;

@RestController
public class FlightController {
	@Autowired
	private FlightService flightService;
	
	@GetMapping("/flights")
	public ResponseEntity<List<FlightDTO>> getAllFlight() throws FlightException{
		
		List<FlightDTO> dto = flightService.getAllFlights();
		return new ResponseEntity<>(dto,HttpStatus.OK);
		
	}
	
	@GetMapping("flight/id/{fNo}")
	public ResponseEntity<FlightDTO> getFlightByFlightNo(@Valid @PathVariable("fNo")Long fNo) throws FlightException{
		
		FlightDTO dto =flightService.getFlightByFlightNumber(fNo);
		
		return new ResponseEntity<>(dto,HttpStatus.OK);		
	}
	
	@PostMapping("/flights")
	public ResponseEntity<Flight> registerFlight(@Valid @RequestBody Flight flight) throws FlightException{
		
		Flight f = flightService.addFlight(flight);
		
		return new ResponseEntity<>(f,HttpStatus.CREATED);
	}
	
	@PutMapping("/flights/{fNo}")
	public ResponseEntity<FlightDTO> updateFlight(@Valid @PathVariable("fNo") Long fNo,@RequestBody FlightDTO dto) throws FlightException{
		
		FlightDTO dt = flightService.updateFlight(fNo, dto);
		return new ResponseEntity<>(dt,HttpStatus.ACCEPTED);	
	}
	@GetMapping("/flights/from")
	public ResponseEntity<List<FlightDTO>> serarchFligh(@Valid @RequestParam("departCode") String departCode,
			@RequestParam("ArrivalCode") String ArrivalCode, @RequestParam("departDateTime") LocalDateTime departTime)
			throws FlightException{
		
		List<FlightDTO> dto = flightService.searchFlights(departCode, ArrivalCode, departTime);
		return new ResponseEntity<>(dto,HttpStatus.OK);
	}
	
	@GetMapping("/flight/{Airline}")
	public ResponseEntity<List<FlightDTO>> searchFlightsByAirline(@Valid @PathVariable("Airline") String airline) throws FlightException{
		
		List<FlightDTO> dto = flightService.searchFlightsByAirline(airline);
		return new ResponseEntity<>(dto,HttpStatus.OK);
	}
	@GetMapping("/flight/fair/between")
	public ResponseEntity<List<FlightDTO>> searchFlightByFair(@Valid @RequestParam("minFair") Double minFair,
			@RequestParam("maxFair") Double maxFair) throws FlightException{
		List<FlightDTO> dto = flightService.searchFlightsByFare(minFair, maxFair);
		
		return new ResponseEntity<>(dto,HttpStatus.OK);
	}
	@GetMapping("/flight/sortByFare")
	public ResponseEntity<List<Flight>> getAllFlightsSortedByFare() throws FlightException{
		List<Flight> flight = flightService.getAllFlightsSortedByFare();
		return new ResponseEntity<>(flight,HttpStatus.OK);
	}
}
