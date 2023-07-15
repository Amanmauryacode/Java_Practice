package com.masai.usecases;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Demo {

	public static void main(String[] args) {
		System.out.println("Done...");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Unit");
		
		EntityManager em  = emf.createEntityManager();
		
		
	}
}
