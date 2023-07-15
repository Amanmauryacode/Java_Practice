package com.masai.model;

public class FullCarDetails {

	private String carId;
	private String modelName;
	private int price;
	private int totalSeats;
	private String companyName;
	private long turnover_in_crores;
	
	public FullCarDetails() {
		// TODO Auto-generated constructor stub
	}

	public FullCarDetails(String carId, String modelName, int price, int totalSeats, String companyName,
			long turnover_in_crores) {
		super();
		this.carId = carId;
		this.modelName = modelName;
		this.price = price;
		this.totalSeats = totalSeats;
		this.companyName = companyName;
		this.turnover_in_crores = turnover_in_crores;
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

	public long getTurnover_in_crores() {
		return turnover_in_crores;
	}

	public void setTurnover_in_crores(long turnover_in_crores) {
		this.turnover_in_crores = turnover_in_crores;
	}

	@Override
	public String toString() {
		return "Car Id: " + carId + ", Model Name: " + modelName + ", Price: " + price + ", Total Seats: "
				+ totalSeats + ", Company Name: " + companyName + ", Turnover: " + turnover_in_crores + "\n";
	}
	
	
}
