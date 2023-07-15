package com.masai.Main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.masai.entity.Coffee;
import com.masai.utility.EMUtil;

public class GetCoffeeByIdOfRatingFour {

	public static void main(String[] args) {
		EntityManager em = EMUtil.provideEntityManager();

		Query q = em.createNamedQuery("coffee.getCoffeeByIdOfRatingFour");

		q.setParameter("id", 1);

		List<Coffee> coffee = q.getResultList();
		if (coffee == null) {
			System.out.println("NO COffe Found!");
		} else
			coffee.forEach(System.out::println);
	}
}
