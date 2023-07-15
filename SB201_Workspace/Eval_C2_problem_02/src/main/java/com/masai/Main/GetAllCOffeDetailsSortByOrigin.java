package com.masai.Main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.masai.entity.Coffee;
import com.masai.utility.EMUtil;

public class GetAllCOffeDetailsSortByOrigin {

	public static void main(String[] args) {
		EntityManager em =  EMUtil.provideEntityManager();
		
		Query q = em.createQuery("select c from Coffee c order By c.beverageId asc");
		List<Coffee> c = q.getResultList();
		
		c.forEach(s->{
			System.out.println(s.getBeverageId()+" "+s);
		});
	}
}
