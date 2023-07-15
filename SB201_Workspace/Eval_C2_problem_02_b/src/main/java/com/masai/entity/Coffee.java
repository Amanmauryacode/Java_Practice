package com.masai.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "coffee.getCoffeeByIdOfRatingFour" , query = "select c from Coffee c WHERE c.coffeeId = :id AND c.rating >4")
@DiscriminatorValue("Coffee")
public class Coffee extends Beverage {

	private int coffeeId;
	private int price;
	private String description;
	private String origin;
	public int getCoffeeId() {
		return coffeeId;
	}
	public void setCoffeeId(int coffeeId) {
		this.coffeeId = coffeeId;
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
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	@Override
	public String toString() {
		return "Coffee [coffeeId=" + coffeeId + ", price=" + price + ", description=" + description + ", origin="
				+ origin + "]";
	}
	
	
}
