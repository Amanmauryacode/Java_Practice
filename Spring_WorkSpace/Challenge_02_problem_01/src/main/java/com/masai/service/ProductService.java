package com.masai.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Service;

import com.masai.exception.ProductException;
import com.masai.model.Product;

import jakarta.annotation.PostConstruct;

@Service
public class ProductService {
	Map<String, List<Product>> empMap = new HashMap<>();

	@PostConstruct
	public void myInti() {
		List<Product> emp1 = new ArrayList<>();
		emp1.add(new Product(1, "pen", 100, "stationary"));
		List<Product> emp2 = new ArrayList<>();
		emp2.add(new Product(2, "pencil", 100, "stationary"));
		List<Product> emp3 = new ArrayList<>();
		emp3.add(new Product(3, "mouse", 100, "electronic"));
		empMap.put("s1", emp1);
		empMap.put("s2", emp2);
		empMap.put("s3", emp3);

	}

	public String addNewProductToStore(String store, Product p) throws ProductException {

		boolean flag = true;

		if (p == null) {
			throw new ProductException("Null Product Not Be Created");
		}

		for (Map.Entry<String, List<Product>> set : empMap.entrySet()) {
			if (set.getKey().equals(store)) {
				List<Product> list = set.getValue();
				list.add(p);
				empMap.put(store, list);
				flag = false;
			}
		}

		if (flag) {
			List<Product> list = new ArrayList<>();
			list.add(p);
			empMap.put(store, list);
		}

		return "Sucessfully Added";
	}

	public String updateProductDetails(String store, Product p) throws ProductException {
		boolean flag = true;

		if (p == null) {
			throw new ProductException("Null Product Not Be Created!");
		}

		for (Map.Entry<String, List<Product>> set : empMap.entrySet()) {
			if (set.getKey().equals(store)) {
				for (Product e : set.getValue()) {
					if (p.getId() == e.getId()) {
						List<Product> list = set.getValue();
						list.remove(e);
						list.add(p);
						empMap.put(store, list);
						flag = false;
						break;
					}
				}
				if (!flag)
					break;
			}
		}

		if (flag == true)
			throw new ProductException("Product And Store Not Found!");

		return "Sucessfully Update";

	}

	public String deleteProductByid(int id) throws ProductException {
		boolean flag = true;
		for (Map.Entry<String, List<Product>> set : empMap.entrySet()) {
			List<Product> list = set.getValue();
			for (Product e : list) {
				if (e.getId() == id) {
					list.remove(e);
					empMap.put(set.getKey(), list);
					flag = false;
					break;
				}
			}

		}

		if (flag)
			throw new ProductException("Product Not Found!");
		return "Sucessfully Deleted";
	}

	public Product getProductById(Integer id) throws ProductException {

		for (Map.Entry<String, List<Product>> set : empMap.entrySet()) {
			List<Product> list = set.getValue();
			for (Product e : list) {
				if (e.getId() == id) {
					return e;
				}
			}
		}
		
		throw new ProductException("Product Not Found!");
	}
	
	public List<Product> getAllProduct() throws ProductException{
		List<Product> prod = new ArrayList<>();

		empMap.values().forEach(e -> e.forEach(e1 -> prod.add(e1)));
		if(prod.isEmpty()) {
			throw new ProductException("Product Not Found!");
		}
		return prod;
	}
}
