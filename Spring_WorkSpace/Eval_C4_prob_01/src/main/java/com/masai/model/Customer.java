package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Customer {
//	a unique customerId, first name, last name, email, phone, and a list of bookings.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;
	@NotNull(message = "Customer First Name Is Mandatory")
	@NotEmpty(message = "Customer First Name Is Mandatory")
	private String firstName;
	@NotNull(message = "Customer Last Name Is Mandatory")
	@NotEmpty(message = "Customer Last Name Is Mandatory")
	private String lastName;
	@Email(message = "Email Should in Proper Formate")
	private String email;
//	@Pattern(regexp = "^[6-9]\\d{2}\d{8}$")
	private String phone;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "customer")
	private List<Booking> bookings = new ArrayList<>();
}
