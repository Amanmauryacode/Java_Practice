package com.masai.service;

import java.util.List;

import com.masai.entity.Product;
import com.masai.exception.ProductException;

public interface ProductService {

	public Product addNewProduct(Product prod) throws ProductException;

	public Product updateProduct(Product prod) throws ProductException;

	public Product deleteProduct(Integer pId) throws ProductException;

	public Product getProductById(Integer pId) throws ProductException;

	public List<Product> getAllProduct() throws ProductException;

	public List<Product> getProductWithPageNoAndLimit(Integer pageNo, Integer limit) throws ProductException;

	public List<Product> sortProductInOrder(String name, String direction) throws ProductException;

}
