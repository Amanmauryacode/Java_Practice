package com.masai.model;

public class Car {
	
	private String carId;
	private String modelName;
	private int price;
	private int totalSeats;
	private String companyId;
	
	
	public Car() {
		
	}


	public Car(String carId, String modelName, int price, int totalSeats, String companyId) {
		super();
		this.carId = carId;
		this.modelName = modelName;
		this.price = price;
		this.totalSeats = totalSeats;
		this.companyId = companyId;
	}


	public String getCarId() {
		return carId;
	}


	public void setCarId(String carId) {
		this.carId = carId;
	}


	public String getModelName() {
		return modelName;
	}


	public void setModelName(String modelName) {
		this.modelName = modelName;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getTotalSeats() {
		return totalSeats;
	}


	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}


	public String getCompanyId() {
		return companyId;
	}


	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}


	@Override
	public String toString() {
		return String.format("carId=%s, modelName=%s, price=%s, totalSeats=%s, companyId=%s \n", carId, modelName,
				price, totalSeats, companyId);
	}
	
}
