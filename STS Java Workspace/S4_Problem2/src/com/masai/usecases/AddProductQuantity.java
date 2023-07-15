package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.ProductDao;
import com.masai.dao.ProductDaoImp;
import com.masai.exception.ProductException;

public class AddProductQuantity {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the Product Id to Change the Quantity : ");
		int id = sc.nextInt();
		
		System.out.println("Enter the new Product Quantity : ");
		int qty = sc.nextInt();
		
		sc.close();
		
		ProductDao dao = new ProductDaoImp();	
		try {
			String msg = dao.addProductQuantity(id, qty);
			System.out.println(msg);
		} catch (ProductException e) {
			
			System.out.println(e.getMessage());
		}
	}
}
