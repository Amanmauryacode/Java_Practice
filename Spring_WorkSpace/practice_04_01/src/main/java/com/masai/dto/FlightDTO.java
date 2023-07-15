package com.masai.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FlightDTO {

	private Long flightNumber;
	private String airline;
	private String departureAirportCode;
	private String arrivalAirportCode;
	private LocalDateTime departureDateTime;
	private LocalDateTime arrivalDateTime;
	private Double flightFare;
	
}
