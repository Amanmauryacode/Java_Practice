package com.masai.lambda.prob_3;
import java.util.*;

class Product {
	private int productId;
	private String productName;
	private int quantity;
	private int price;
	
	public Product(int productId, String productName, int quantity, int price) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "productId=" + productId + ", productName=" + productName + ", quantity=" + quantity
				+ ", price=" + price + "\n";
	}
	
}


public class Demo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Product p1 = new Product(1,"Biscut",5,500);
		Product p2 = new Product(2,"Chips",10,850);
		Product p3 = new Product(3,"Soap",6,450);
		Product p4 = new Product(4,"Brush",5,350);
		Product p5 = new Product(5,"Salt",3,700);
		
		List<Product> list = new ArrayList<>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		list.add(p5);
		
		Collections.sort(list, (pr1,pr2)->pr2.getPrice() - pr1.getPrice());
		System.out.println(list);
	}

}
