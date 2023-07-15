package com.masai.usecase;

import javax.persistence.EntityManager;

import com.masai.entity.FullTimeStudent;
import com.masai.entity.PartTimeStudent;
import com.masai.utility.EMUtil;

public class InsertStudent {

	public static void main(String[] args) {
		
		EntityManager em = EMUtil.provideEntityManager();
		
		FullTimeStudent std1 = new FullTimeStudent();
		std1.setName("Aman");
		std1.setAddress("Varanasi");
		std1.setRegistrationFee(10);
		std1.setFullTimeFee(101);
		
		FullTimeStudent std2 = new FullTimeStudent();
		std2.setName("Rahul");
		std2.setAddress("Dehradun");
		std2.setRegistrationFee(10);
		std2.setFullTimeFee(101);
		
		PartTimeStudent std3 = new PartTimeStudent();
		std3.setName("Rounak");
		std3.setAddress("Jaipur");
		std3.setRegistrationFee(10);
		std3.setPartTimeFee(41);
		
		PartTimeStudent std4 = new PartTimeStudent();
		std4.setName("Kusum");
		std4.setAddress("Chandighar");
		std4.setRegistrationFee(10);
		std4.setPartTimeFee(41);
		
		em.getTransaction().begin();
		
		em.persist(std1);
		em.persist(std2);
		em.persist(std3);
		em.persist(std4);
		
		em.getTransaction().commit();
		em.close();
		
		
		
	
		
	}
}
