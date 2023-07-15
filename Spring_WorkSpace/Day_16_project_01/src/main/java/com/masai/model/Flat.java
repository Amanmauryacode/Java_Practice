package com.masai.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Flat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer flatId;
	@NotNull(message = "Building Name Not Be Null")
	@NotEmpty(message = "Building Name Not Be Empty")
	private String buildingName;

	@Min(value = 10, message = "No of Room Must Be Greater Than 10")
	@NotNull(message = "Building Name Not Be Null")
	private Integer noOfRoom;
	@NotNull(message = "date_of_manufacturing Not Be Null")
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
	private LocalDate date_of_manufacturing;

	@Enumerated(EnumType.STRING)
	@NotNull(message = "Facing Not Be Null")
	private Facing facing;
	@Min(value = 0, message = "No of Room Must Be Greater Than 10")
	@NotNull(message = "Building Name Not Be Null")
	private Integer price;
	@NotNull(message = "Description Not Be Null")
	@NotEmpty(message = "Description Not Be Empty")
	private String description;

}
