package com.masai.usecases;

import java.util.List;
import java.util.Scanner;

import com.masai.dao.ProductDao;
import com.masai.dao.ProductDaoImp;
import com.masai.exception.ProductException;
import com.masai.model.Product;

public class GetAllProductQuantityLessThan {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the Quantity of Product : ");
		int qty = sc.nextInt();
		
		sc.close();
		
		ProductDao dao = new ProductDaoImp();
		
		try {
			List<Product> products = dao.getAllProductQuantityLessThan(qty);
			products.forEach(System.out::print);
		} catch (ProductException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

}
