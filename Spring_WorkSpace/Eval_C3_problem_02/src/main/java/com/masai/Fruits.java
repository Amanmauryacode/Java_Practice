package com.masai;

public class Fruits extends Product {

	public Fruits(String name, double pricePerUnit, int quantity) {
		super(name, pricePerUnit, quantity);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calculateTotalPrice() {
		// TODO Auto-generated method stub
		return super.getPricePerUnit() * super.getQuantity();
	}

}
