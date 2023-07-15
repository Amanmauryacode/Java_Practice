package com.masai.Main;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.masai.entity.Product;

public class Demo {

	public static void main(String[] args) {
		
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("product");
	
		EntityManager em= emf.createEntityManager();
		
		//write your logic here.
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter The Product ID to Search : ");
		int id = sc.nextInt();
		
		
		em.getTransaction().begin();
		
		Product product =  em.find(Product.class, id);
		
		if(product != null) {
			System.out.println(product);
		}
		
		em.getTransaction().commit();
		em.close();
	}
}
