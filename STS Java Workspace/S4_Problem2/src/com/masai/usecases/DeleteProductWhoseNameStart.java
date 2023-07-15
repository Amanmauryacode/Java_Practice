package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.ProductDao;
import com.masai.dao.ProductDaoImp;
import com.masai.exception.ProductException;

public class DeleteProductWhoseNameStart {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the Starting Character to Search the Product : ");
		String start = sc.next();
		
		sc.close();
		
		ProductDao dao = new ProductDaoImp();
		
		try {
			int x = dao.deleteProductWhoseNameStart(start);
			if(x > 0)System.out.println(x+" Product deleted From record ");
		} catch (ProductException e) {

			System.out.println(e.getMessage());
		}
	}
}
