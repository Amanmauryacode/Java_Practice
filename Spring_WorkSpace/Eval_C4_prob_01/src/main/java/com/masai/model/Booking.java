package com.masai.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Booking {
//	a unique bookingId, customerId, roomId, bookingDate, and status (e.g., confirmed, cancelled).
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookingId;
//	private Integer customerId;
	@NotNull(message = "Room Id Is Mandatory")
	private Integer roomId;
	@NotNull(message = "Booking Date Is Mandatory")
	@NotEmpty(message = "Booking Date Is Mandatory")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@Future
	private LocalDate bookingDate;

	private String status;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "customerId")
	private Customer customer;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "booking")
	private List<RoomType> roomTypes = new ArrayList<>();
}
