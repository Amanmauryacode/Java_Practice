package com.masai.Dao.Impl;
//import javax.persistence.Query;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.masai.Dao.StreamMasterDAO;
import com.masai.entity.Subscription;
import com.masai.exception.SubscriptionException;
import com.masai.utility.EMUtil;
import com.mysql.cj.Query;

public class StreamMasterDAOImpl implements StreamMasterDAO{

	public Subscription findSubscriptionById(int id) {
		EntityManager em = EMUtil.getEntityManager();
		Subscription sub =  em.find(Subscription.class, id);
		if(sub == null) throw new SubscriptionException("Subscription not found with id");
		em.close();
		return sub;
	}

	public List<Subscription> findSubscriptionsByName(String name) {
		EntityManager em = EMUtil.getEntityManager();
		
//		Query q = em.createQuery("from Subscription where name = :nm");
		
		
		
	   	return null;
		
	}

	public String saveSubscription(Subscription subscription) {
		
		EntityManager em = EMUtil.getEntityManager();
		
		Subscription s = em.find(Subscription.class, subscription.getId());
		if(s!= null) {
			em.getTransaction().begin();
			em.persist(subscription);
			em.getTransaction().commit();
		}else {
			throw new SubscriptionException("Already Present inside table");
		}
		
		em.close();
		return "Successfully Saved " ;
		
	}

	public String deleteSubscriptionById(int id) {
		EntityManager em = EMUtil.getEntityManager();
		Subscription sub =  em.find(Subscription.class, id);
		if(sub == null) throw new SubscriptionException("Subscription not found ");
		
		em.getTransaction().begin();
		em.remove(sub);
		em.getTransaction().commit();
		em.close();
		return "Sucessfully deleted";
	}

	public String updatePrice(int new_price, int id) {
		EntityManager em = EMUtil.getEntityManager();
		Subscription sub =  em.find(Subscription.class, id);
		if(sub == null) throw new SubscriptionException("Subscription not found ");
		
		em.getTransaction().begin();
		sub.setPrice(new_price);
		em.getTransaction().commit();
		em.close();
		return "Sucessfully Update Price";
	}

	public String extendSubscription(int extra_days, int id) {
		EntityManager em = EMUtil.getEntityManager();
		Subscription sub =  em.find(Subscription.class, id);
		if(sub == null) throw new SubscriptionException("Subscription not found ");
		
		em.getTransaction().begin();
		sub.setEnd_date(sub.getEnd_date().plusDays(extra_days));
		em.getTransaction().commit();
		em.close();
		return "Sucessfully Extends";
	}

	public String updatePlanName(String new_plan_name, int id) {
		EntityManager em = EMUtil.getEntityManager();
		Subscription sub =  em.find(Subscription.class, id);
		if(sub == null) throw new SubscriptionException("Subscription not found ");
		
		em.getTransaction().begin();
		sub.setPlan_name(new_plan_name);
		em.getTransaction().commit();
		em.close();
		return "Sucessfully Change Plan Name";
	}

	public List<Subscription> findSubscriptionsByPlan(String plan_name) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Subscription> findSubscriptionsByDateRange(Date start_date, Date end_date) {
		// TODO Auto-generated method stub
		return null;
	}

}