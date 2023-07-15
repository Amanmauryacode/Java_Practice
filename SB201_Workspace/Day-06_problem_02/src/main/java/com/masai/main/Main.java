
package com.masai.main;

import javax.persistence.EntityManager;

import com.masai.entity.Address;
import com.masai.entity.Customer;
import com.masai.utility.EMUtil;

public class Main {

	public static void main(String[] args) {
		Customer c1 = new Customer();

		c1.setName("Rahul");
		c1.setEmail("rahul@gmail.com");
		c1.setMobileNumber("123456789");
		c1.getAddresses().add(new Address("UK", "Dehradun", "248001", "Home"));
		c1.getAddresses().add(new Address("MH", "Nainital", "247002", "Office"));

		Customer c2 = new Customer();

		c2.setName("Rounak");
		c2.setEmail("rounak@gmail.com");
		c2.setMobileNumber("123456789");
		c2.getAddresses().add(new Address("RJ", "Jaipur", "302013", "Home"));
		c2.getAddresses().add(new Address("Ezypt", "Ezypt", "124578", "Office"));

		EntityManager em = EMUtil.provideEntityManager();

		em.getTransaction().begin();

		em.persist(c1);
		em.persist(c2);
		em.getTransaction().commit();
		em.close();
	}
}
