package com.masai.Main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.masai.entity.Tea;
import com.masai.utility.EMUtil;

public class GetTeaByIdFilterWithRatingLessThanThree {

	public static void main(String[] args) {
		EntityManager em = EMUtil.provideEntityManager();

		Query q = em.createQuery("select t from Tea t Where t.teaId = :id AND t.rating < 3");

		q.setParameter("id", 1);
		List<Tea> tea = q.getResultList();
		if (tea.size() == 0) {
			System.out.println("Tea Not Found!");
		} else
			tea.forEach(System.out::println);
	}
}
