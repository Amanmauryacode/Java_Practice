package com.masai;

public class Bakery extends Product {

	public Bakery(String name, double pricePerUnit, int quantity) {
		super(name, pricePerUnit, quantity);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calculateTotalPrice() {
		// TODO Auto-generated method stub
		return super.getPricePerUnit() * super.getQuantity();
	}

}
