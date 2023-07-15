package com.masai.entity;

import javax.persistence.Entity;

@Entity
public class FullTimeStudent extends MasaiStudent{
	private double fullTimeFee;

	@Override
	public double payFee() {
		
		return this.fullTimeFee+super.getRegistrationFee();
	}
	//gettes and setters

	public double getFullTimeFee() {
		return fullTimeFee;
	}

	public void setFullTimeFee(double fullTimeFee) {
		this.fullTimeFee = fullTimeFee;
	}
}

