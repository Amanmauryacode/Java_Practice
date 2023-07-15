package com.masai.model;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Flight {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long flightNumber;
	@Size(min = 3, max = 50,message = "{Size Between 3 character And Max 50 character}")
	@NotNull(message = "{Name Is Mandatory}")
	private String airline;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "airportCode" ,column = @Column(name = "departure_airportCode")),
		@AttributeOverride(name = "airportName" ,column = @Column(name = "departure_airportName")),
		@AttributeOverride(name = "city" ,column = @Column(name = "departure_city")),
		@AttributeOverride(name = "country" ,column = @Column(name = "departure_country"))
		
	})
	@NotNull(message = "{Departure Airport Is Mandatory}")
	@NotEmpty(message = "{Departure Airport Is Mandatory}")
	private Airport departureAirport;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "airportCode" ,column = @Column(name = "arrival_airportCode")),
		@AttributeOverride(name = "airportName" ,column = @Column(name = "arrival_airportName")),
		@AttributeOverride(name = "city" ,column = @Column(name = "arrival_city")),
		@AttributeOverride(name = "country" ,column = @Column(name = "arrival_country"))
		
	})
	@NotNull(message = "{Arrival Airport Is Mandatory}")
	@NotEmpty(message = "{Arrival Airport Is Mandatory}")
	private Airport arrivalAirport;
	
	@Future
	@NotNull(message = "{Arrival Airport Is Mandatory}")
	@NotEmpty(message = "{Arrival Airport Is Mandatory}")
	@DateTimeFormat( pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime departureDateTime;
	@Future
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime arrivalDateTime;
	@NotNull(message = "{Available Seats Is Mandatory}")
	@Min(value = 1,message = "{Available Seats Atleast Greater Than 0 }")
	private Integer availableSeats;
	
	@Min(value = 1,message = "{Flight Fair Atleast Greater Than 0 }")
	private Double flightFare;
	
	
}
