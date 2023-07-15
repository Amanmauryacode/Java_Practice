package com.masai;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class ProductServiceImpl implements ProductService {
	@Autowired(required = false)
	private List<Product> products;

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		products.add(product);

	}

	@Override
	public void removeProduct(Product product) {
		products.remove(product);

	}

	@Override
	public double calculateTotalCost() {
		double totalCost = 0;
		
		for(Product p : products) {
			totalCost+=p.calculateTotalPrice();
		}
		
		return totalCost;
	}

}
