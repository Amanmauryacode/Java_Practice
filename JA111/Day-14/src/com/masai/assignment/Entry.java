package com.masai.assignment;
import java.time.LocalDate;

public class Entry {
	private String description;
	private double income;
	private LocalDate dateOfIncome;
	private char type;
	
	Entry(String description,double income,LocalDate dateOfIncome,char type){
		this.description = description;
		this.income = income;
		this.dateOfIncome = dateOfIncome;
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getIncome() {
		return income;
	}

	public void setIncome(double income) {
		this.income = income;
	}

	public LocalDate getDateOfIncome() {
		return dateOfIncome;
	}

	public void setDateOfIncome(LocalDate dateOfIncome) {
		this.dateOfIncome = dateOfIncome;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Entry [dateOfIncome=" + dateOfIncome + ", income=" + income + ", description=" + description + "]";
	}

	
	
	
}
