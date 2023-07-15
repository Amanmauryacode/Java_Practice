package com.masai.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.masai.dto.FlightDTO;
import com.masai.model.Flight;
@Repository
public interface FlightDao  extends JpaRepository<Flight, Long>{

	
	@Query("select new com.masai.dto.FlightDTO(f.flightNumber,f.airline,f.departureAirport.airportCode,f.arrivalAirport.airportCode,f.departureDateTime,f.arrivalDateTime,f.flightFare) from Flight f")
	public List<FlightDTO> getAllFlights();
	
	@Query("select new com.masai.dto.FlightDTO(f.flightNumber,f.airline,f.departureAirport.airportCode,f.arrivalAirport.airportCode,f.departureDateTime,f.arrivalDateTime,f.flightFare) from Flight f WHERE f.flightNumber=?1")
	public FlightDTO getFlightByFlightNo(Long id);
	
	@Query("select new com.masai.dto.FlightDTO(f.flightNumber,f.airline,f.departureAirport.airportCode,f.arrivalAirport.airportCode,f.departureDateTime,f.arrivalDateTime,f.flightFare) from Flight f where f.arrivalAirport.airportCode = ?1 AND f.departureAirport.airportCode = ?2 AND f.departureDateTime=?3")
	public List<FlightDTO> getFlightBydepartureAirportCodeAndArrivalCode(String acode,String dcode,LocalDateTime departTime);

	@Query("select new com.masai.dto.FlightDTO(f.flightNumber,f.airline,f.departureAirport.airportCode,f.arrivalAirport.airportCode,f.departureDateTime,f.arrivalDateTime,f.flightFare) from Flight f where f.airline = ?1")
	public List<FlightDTO> getFlightDetailsByAirline(String airline);
	
	@Query("select new com.masai.dto.FlightDTO(f.flightNumber,f.airline,f.departureAirport.airportCode,f.arrivalAirport.airportCode,f.departureDateTime,f.arrivalDateTime,f.flightFare) from Flight f where f.flightFare BETWEEN :f1 And :f2")
	public List<FlightDTO> getFlightDetailsBetweenFair(@Param("f1") Double minFair,@Param("f2") Double maxFair);
	
	
}
