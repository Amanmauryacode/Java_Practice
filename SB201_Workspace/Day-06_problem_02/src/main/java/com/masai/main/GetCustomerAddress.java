
package com.masai.main;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.masai.entity.Customer;
import com.masai.utility.EMUtil;

public class GetCustomerAddress {

	public static void main(String[] args) {
		
		EntityManager em =  EMUtil.provideEntityManager();
		Query q = em.createQuery("select c from Customer c WHERE c.cid =:id");
		
		q.setParameter("id", 1);
		
		Customer c =  (Customer) q.getSingleResult();
		System.out.println(c.getAddresses());
	}
}
