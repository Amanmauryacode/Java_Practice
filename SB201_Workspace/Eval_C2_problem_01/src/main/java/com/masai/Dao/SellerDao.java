package com.masai.Dao;

import java.util.List;

import com.masai.entity.Product;
import com.masai.entity.Seller;
import com.masai.exception.ProductException;
import com.masai.exception.SellerException;

public interface SellerDao {

	public Seller addSeller(Seller s) throws SellerException;

	public String addProductToSeller(Product prod,int id) throws SellerException;
	
	public Seller getSeller(int id) throws SellerException;
	
	public Product getProductByProductId(int id) throws ProductException;
	
	public String AddListOfProduct(List<Product> prod,int id)throws SellerException;
	
}
