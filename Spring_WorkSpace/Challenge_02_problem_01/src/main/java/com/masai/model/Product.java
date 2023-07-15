package com.masai.model;

import java.util.Objects;

public class Product {
//	 id, name, description, price, and category.
	
	private int id;
	private String description;
	private int price;
	private String category;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int id, String description, int price, String category) {
		super();
		this.id = id;
		this.description = description;
		this.price = price;
		this.category = category;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", description=" + description + ", price=" + price + ", category=" + category
				+ "]";
	}
	
	
}
