package com.masai.model;

public class FullCarDetails {
	private String carId;
	private String modelName;
	private int price;
	private int totalSeats;
	private String companyName;
	private long turnover;
	
	public FullCarDetails() {
		
	}

	public FullCarDetails(String carId, String modelName, int price, int totalSeats, String companyName,
			long turnover) {
		super();
		this.carId = carId;
		this.modelName = modelName;
		this.price = price;
		this.totalSeats = totalSeats;
		this.companyName = companyName;
		this.turnover = turnover;
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

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public long getTurnover() {
		return turnover;
	}

	public void setTurnover(long turnover) {
		this.turnover = turnover;
	}

	@Override
	public String toString() {
		return String.format(
				"Car Id: %s, Model Name: %s, Price: %s, Total Seats: %s, Company Name: %s, Turnover: %s Crores", carId,
				modelName, price, totalSeats, companyName, turnover);
	}
	
	
}
