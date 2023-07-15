package com.masai.entity;

import javax.persistence.Entity;

@Entity
public class Tea extends Beverage {

	private int teaId ;
	private int price;
	private String description;
	private String flavor;
	public int getTeaId() {
		return teaId;
	}
	public void setTeaId(int teaId) {
		this.teaId = teaId;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFlavor() {
		return flavor;
	}
	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}
	@Override
	public String toString() {
		return "Tea [teaId=" + teaId + ", price=" + price + ", description=" + description + ", flavor=" + flavor + "]";
	}
	
	
}
