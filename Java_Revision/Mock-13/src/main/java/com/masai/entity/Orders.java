package com.masai.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;

@Entity
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Double totalPrice;
	@NotNull(message = "Payment type must be required")
	private PaymentType paymentType;
	
	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="productId")
	private List<Product> products;
	
	@ManyToOne
    @JoinColumn(name = "userId")
	private User user;
	
}
