package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entity.Product;
import com.masai.exception.ProductException;
import com.masai.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService prodService;

	@PostMapping("/add")
	public ResponseEntity<Product> addNewProdcut(@Valid @RequestBody Product prod) throws ProductException {

		Product product = prodService.addNewProduct(prod);
		return new ResponseEntity<>(product, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<Product> updateProdcut(@Valid @RequestBody Product prod) throws ProductException {

		Product product = prodService.updateProduct(prod);
		return new ResponseEntity<>(product, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delete/{pid}")
	public ResponseEntity<Product> removeProdcut(@Valid @PathVariable Integer pid) throws ProductException {

		Product product = prodService.deleteProduct(pid);
		return new ResponseEntity<>(product, HttpStatus.ACCEPTED);
	}

	@GetMapping("/getById/{pid}")
	public ResponseEntity<Product> getProductById(@Valid @PathVariable Integer pid) throws ProductException {
		Product product = prodService.getProductById(pid);
		return new ResponseEntity<>(product, HttpStatus.ACCEPTED);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Product>> getAllProduct() throws ProductException {
		List<Product> products = prodService.getAllProduct();
		return new ResponseEntity<>(products, HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/getInSortedOrder")
	public ResponseEntity<List<Product>> getAllProductOrderBy(@RequestParam("orderBy") String name,@RequestParam("direction") String direction ) throws ProductException {
		List<Product> products = prodService.sortProductInOrder(name, direction);
		return new ResponseEntity<>(products, HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/getByPageNoAndLimit")
	public ResponseEntity<List<Product>> getProductByPageNoAndLimit(@RequestParam("pageNo") Integer pageNo,@RequestParam("limit") Integer limit ) throws ProductException {
		List<Product> products = prodService.getProductWithPageNoAndLimit(pageNo, limit);
		return new ResponseEntity<>(products, HttpStatus.ACCEPTED);
	}
	
	

}
