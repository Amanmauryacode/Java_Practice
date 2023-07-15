package com.masai.entity;

import javax.persistence.Entity;

@Entity
public class PartTimeStudent extends MasaiStudent{

	private double partTimeFee;
	//getters and setters

	@Override
	public double payFee() {
		
		return partTimeFee+super.getRegistrationFee();
	}

	public double getPartTimeFee() {
		return partTimeFee;
	}

	public void setPartTimeFee(double partTimeFee) {
		this.partTimeFee = partTimeFee;
	}
	

}
