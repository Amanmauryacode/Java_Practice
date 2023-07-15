
package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.ProductDao;
import com.masai.dao.ProductDaoImp;
import com.masai.exception.ProductException;

public class DeleteProductByProductName {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter The Product Name to Delete the Product : ");
		String name = sc.next();
		
		sc.close();
		
		ProductDao dao = new ProductDaoImp();	
		try {
			String msg = dao.deleteProductByProductName(name);
			System.out.println(msg);
		} catch (ProductException e) {

			System.out.println(e.getMessage());
		}
	}
	
}
