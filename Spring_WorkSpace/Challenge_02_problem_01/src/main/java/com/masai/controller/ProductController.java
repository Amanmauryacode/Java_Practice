package com.masai.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.ProductException;
import com.masai.model.Product;
import com.masai.model.Product;
import com.masai.service.ProductService;

import jakarta.annotation.PostConstruct;

@RestController
@CrossOrigin("*")
public class ProductController {
	@Autowired
	private ProductService ProductService;

	@PostMapping("/products/{store}")
	public ResponseEntity<String> postProduct(@PathVariable String store, @RequestBody(required = false) Product p)
			throws ProductException {
		String msg = ProductService.addNewProductToStore(store, p);
		return new ResponseEntity<>(msg, HttpStatus.CREATED);
	}

	@PutMapping("/products/{store}")
	public ResponseEntity<String> putProduct(@PathVariable String store, @RequestBody(required = false) Product p)
			throws ProductException {

		String msg = ProductService.updateProductDetails(store, p);
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}

	@DeleteMapping("/products/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable Integer id) throws ProductException {

		String msg = ProductService.deleteProductByid(id);
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}

	@GetMapping("/products")
	public List<Product> getAllProduct() throws ProductException {

		return ProductService.getAllProduct();
	}

	@GetMapping("/products/{Id}")
	public Product getProduct(@PathVariable Integer Id) throws ProductException {

		return ProductService.getProductById(Id);
	}
}
