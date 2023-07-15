package com.masai.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class RoomType {
//	a unique roomId, hotelId, name, description, capacity, price, and type (It is an enum: Single/Double/Deluxe/Premium).
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer roomId;
//	private Integer hotelId;
	private String name;
	private String description;
	private Integer capacity;
	private Integer price;
	
	@Enumerated(EnumType.STRING)
	private Type type;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "hotelId")
	private Hotel hotel;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "bookingId")
	private Booking booking;
	
}
