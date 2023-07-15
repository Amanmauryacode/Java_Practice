package com.masai.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode
public class Airport {

//	airportCode: String;
//	airportName: String;
//	city: String;
//	country: String;
	@NotNull(message = "{Airport Code Is Mandatory}")
	@NotEmpty(message = "{Airport Code Is Mandatory}")
	@Size(min = 3,max = 3,message = "{The airport code should be 3 characters in length}")
	private String airportCode;
	@NotNull(message = "{Airport Name Is Mandatory}")
	@NotEmpty(message = "{Airport Name Is Mandatory}")
	private String airportName;
	
	@NotNull(message = "{City Is Mandatory}")
	@NotEmpty(message = "{City Is Mandatory}")
	private String city;
	
	@NotNull(message = "{Country Is Mandatory}")
	@NotEmpty(message = "{Country Is Mandatory}")
	private String country;
	
}
