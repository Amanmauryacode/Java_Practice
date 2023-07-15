package com.masai.model;

public class Car {

	private String carId;
	private String modelName;
	private int price;
	private int totalSeats;
	private String companyID;
	
	public Car() {
		// TODO Auto-generated constructor stub
	}

	public Car(String carId, String modelName, int price, int totalSeats, String companyID) {
		super();
		this.carId = carId;
		this.modelName = modelName;
		this.price = price;
		this.totalSeats = totalSeats;
		this.companyID = companyID;
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

	public String getCompanyID() {
		return companyID;
	}

	public void setCompanyID(String companyID) {
		this.companyID = companyID;
	}

	@Override
	public String toString() {
		return "carId=" + carId + ", modelName=" + modelName + ", price=" + price + ", totalSeats=" + totalSeats
				+ ", companyID=" + companyID + "";
	}
	
	
	
	
}
