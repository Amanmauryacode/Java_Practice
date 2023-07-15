package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter

public class Hotel {
//	a unique hotelId, name, city, address, and a list of room types.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer hotelId;
	@NotNull(message = "Hotel Name Is Mandatory")
	@NotEmpty(message = "Hotel Name Is Mandatory")
	private String name;
	@NotNull(message = "Hotel City Is Mandatory")
	@NotEmpty(message = "Hotel City Is Mandatory")
	private String city;
	@NotNull(message = "Hotel Address Is Mandatory")
	@NotEmpty(message = "Hotel Address Is Mandatory")
	private String address;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "hotel")
	private List<RoomType> rootTypes = new ArrayList<>();

}
