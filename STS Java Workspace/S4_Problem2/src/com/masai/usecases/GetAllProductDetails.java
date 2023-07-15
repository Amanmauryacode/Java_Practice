package com.masai.usecases;

import java.util.List;

import com.masai.dao.ProductDao;
import com.masai.dao.ProductDaoImp;
import com.masai.exception.ProductException;
import com.masai.model.Product;

public class GetAllProductDetails {

	public static void main(String[] args) {
		
		ProductDao dao = new ProductDaoImp();
		
		try {
			List<Product> products = dao.getAllProducts();
			
			products.forEach(System.out::println);
			
		} catch (ProductException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

}
