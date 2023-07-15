package com.masai.Main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.masai.entity.Tea;
import com.masai.utility.EMUtil;

public class GetTeaWhosePriceLessThenAndSpecificFlavor {

	public static void main(String[] args) {
		EntityManager em = EMUtil.provideEntityManager();

		Query q = em.createQuery("select t from Tea t Where t.price< :price AND t.flavor = :flv");

		q.setParameter("price", 20);
		q.setParameter("flv", "Lemon");
		List<Tea> tea = q.getResultList();
		if (tea.size() == 0) {
			System.out.println("Tea Not Found!");
		} else
			tea.forEach(System.out::println);
	}
}
