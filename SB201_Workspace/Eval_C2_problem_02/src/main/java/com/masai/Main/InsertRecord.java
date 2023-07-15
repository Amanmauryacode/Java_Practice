package com.masai.Main;

import javax.persistence.EntityManager;

import com.masai.entity.Coffee;
import com.masai.entity.Tea;
import com.masai.utility.EMUtil;

public class InsertRecord {

	public static void main(String[] args) {
		Coffee c1 = new Coffee();
		
		c1.setCoffeeId(1);
		c1.setDescription("Capichino");
		c1.setOrigin("xyz");
		c1.setPrice(150);
		c1.setRating(4);
		
		Coffee c2 = new Coffee();
		
		c2.setCoffeeId(2);
		c2.setDescription("abc");
		c2.setOrigin("yyy");
		c2.setPrice(250);
		c2.setRating(5);
		
		Coffee c3 = new Coffee();
		
		c3.setCoffeeId(3);
		c3.setDescription("asd");
		c3.setOrigin("aaaa");
		c3.setPrice(50);
		c3.setRating(4);
		
		Coffee c4 = new Coffee();
		
		c4.setCoffeeId(1);
		c4.setDescription("cdf");
		c4.setOrigin("fcd");
		c4.setPrice(450);
		c4.setRating(4);
		
		Tea t1 = new Tea();
		
		t1.setTeaId(1);
		t1.setDescription("ad");
		t1.setFlavor("Lemon");
		t1.setPrice(15);
		t1.setRating(3);
		
		Tea t2 = new Tea();
		
		t2.setTeaId(2);
		t2.setDescription("asas");
		t2.setFlavor("sdfsd");
		t2.setPrice(25);
		t2.setRating(4);
		
		Tea t3 = new Tea();
		
		t3.setTeaId(3);
		t3.setDescription("sdadda");
		t3.setFlavor("cvbcb");
		t3.setPrice(45);
		t3.setRating(5);
		
		Tea t4 = new Tea();
		
		t4.setTeaId(1);
		t4.setDescription("gjkhk");
		t4.setFlavor("fghf");
		t4.setPrice(35);
		t4.setRating(4);
		
		
		EntityManager em =  EMUtil.provideEntityManager();
		em.getTransaction().begin();
		em.persist(c1);
		em.persist(c2);
		em.persist(c3);
		em.persist(c4);
		em.persist(t1);
		em.persist(t2);
		em.persist(t3);
		em.persist(t4);
		em.getTransaction().commit();
		
	}
}
