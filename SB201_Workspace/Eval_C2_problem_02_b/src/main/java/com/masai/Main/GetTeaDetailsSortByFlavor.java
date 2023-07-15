package com.masai.Main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.masai.entity.Tea;
import com.masai.utility.EMUtil;

public class GetTeaDetailsSortByFlavor {

	public static void main(String[] args) {
		EntityManager em =  EMUtil.provideEntityManager();
		
		Query q = em.createQuery("select t from Tea t Order By t.flavor asc");
		List<Tea> tea =  q.getResultList();
		
		tea.forEach(System.out::println);
	}
}
