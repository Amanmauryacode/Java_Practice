package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.ProductDao;
import com.masai.dao.ProductDaoImp;
import com.masai.exception.ProductException;
import com.masai.model.Product;

public class AddProducts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the Product Name : ");
		String name  = sc.next();
		
		System.out.print("Enter the Product Price : ");
		int price = sc.nextInt();
		
		System.out.print("Enter the Product Quantity : ");
		int quantity = sc.nextInt();
		
		sc.close();
		Product product  = new Product();
		
		product.setProductName(name);
		product.setPrice(price);
		product.setQuantity(quantity);
		
		ProductDao dao = new ProductDaoImp();
		
		try {
			String msg = dao.addProduct(product);
			System.out.println(msg);
		} catch (ProductException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}

}
