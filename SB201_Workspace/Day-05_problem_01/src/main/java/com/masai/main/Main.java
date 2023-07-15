package com.masai.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.masai.entity.Address;
import com.masai.entity.Employee;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("employee");
		EntityManager em = emfactory.createEntityManager();

		Employee emp1 = new Employee();
		emp1.setName("Rone");
		emp1.setGender("Male");
		emp1.setSalary(51000);

		Address address1 = new Address();
		address1.setState("New Jercy");
		address1.setCity("New Jercy City");
		address1.setPincode("10001");
		address1.setType("Home");

		Address address2 = new Address();
		address2.setState("New Jercy");
		address2.setCity("California");
		address2.setPincode("12201");
		address2.setType("Work");

		emp1.getEmpAddress().add(address1);
		emp1.getEmpAddress().add(address2);

		Employee emp2 = new Employee();
		emp2.setName("Smith");
		emp2.setGender("Female");
		emp2.setSalary(60000);

		Address address3 = new Address();
		address3.setState("Canada");
		address3.setCity("Los Angeles");
		address3.setPincode("90001");
		address3.setType("Home");

		Address address4 = new Address();
		address4.setState("Canada");
		address4.setCity("San Francisco");
		address4.setPincode("94101");
		address4.setType("Work");

		emp2.getEmpAddress().add(address3);
		emp2.getEmpAddress().add(address4);

		em.getTransaction().begin();
		em.persist(emp1);
		em.persist(emp2);
		em.getTransaction().commit();

		em.close();
	}
}
