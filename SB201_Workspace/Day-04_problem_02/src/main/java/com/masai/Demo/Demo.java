package com.masai.Demo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.masai.entity.Customer;

public class Demo {
	public static void main(String[] args) {

		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("customer");
		EntityManager entitymanager = emfactory.createEntityManager();

		// write your logic here

		// 1. Write a NamedQuery to find “customer by id” by creating NamedQuery which
		// will return customer details.

		Query query = entitymanager.createNamedQuery("customer by id");

		query.setParameter("id", 1);

		Customer customer = (Customer) query.getSingleResult();
		System.out.println(customer);

		// 2.Write NativeQuery to get a “List of All the customers” by creating
		// NamedQuery which will return all customer details.
		
		
		Query query1 = entitymanager.createNamedQuery("List of All the customers");

		List<Customer> list = query1.getResultList();
		
		for(Customer c : list) {
			System.out.println(c);
		}
		

	}
}
