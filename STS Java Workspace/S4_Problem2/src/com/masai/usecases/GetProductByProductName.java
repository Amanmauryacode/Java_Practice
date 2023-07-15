package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.ProductDao;
import com.masai.dao.ProductDaoImp;
import com.masai.exception.ProductException;
import com.masai.model.Product;

public class GetProductByProductName {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the Product name to get Product details : ");
		String name = sc.next();
		
		sc.close();
		
		ProductDao dao = new ProductDaoImp();
		
		try {
			Product p = dao.getProductByProductName(name);
			System.out.println(p);
		} catch (ProductException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
}
