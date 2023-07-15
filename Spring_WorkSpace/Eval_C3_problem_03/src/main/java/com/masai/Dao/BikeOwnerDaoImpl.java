package com.masai.Dao;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.masai.model.Bike;
import com.masai.model.BikeOwner;
import com.masai.utility.EMUtil;

public class BikeOwnerDaoImpl implements BikeOwnerDao {

	@Override
	public void InsertData(List<BikeOwner> list) {
		// TODO Auto-generated method stub
		EntityManager em = EMUtil.provideEntityManager();
		em.getTransaction().begin();
		for (BikeOwner bo : list) {
			em.persist(bo);
		}
		em.getTransaction().commit();
		em.close();

		System.out.println("Done...");
	}

	@Override
	public List<BikeOwner> getAllBikeOwnerWithBike() {
		EntityManager em = EMUtil.provideEntityManager();

		Query q = em.createQuery("select bo from BikeOwner bo");

		List<BikeOwner> list = q.getResultList();
		return list;
	}

	@Override
	public List<BikeOwner> findBikeOwnersByBikeColor(String bikeColor) {
		EntityManager em = EMUtil.provideEntityManager();

		Query q = em.createQuery("select bo from BikeOwner bo where bo.Bike.bikeColor = :col");

		q.setParameter("col", bikeColor);
		List<BikeOwner> list = q.getResultList();
		
		return list;
	}

	@Override
	public Map<BikeOwner, Bike> topBikesByModelName(int n) {
		EntityManager em = EMUtil.provideEntityManager();

		Query q = em.createQuery("select bo from BikeOwner bo");

		List<BikeOwner> list = q.getResultList();
		
		list.sort((a,b)->{
			
			return a.getBike().getModelName().compareTo(b.getBike().getModelName());
		});
		Map<BikeOwner, Bike> map = new LinkedHashMap<>();
		int count=0;
		for(BikeOwner bo : list) {
			if(count == n)break;
			map.put(bo, bo.getBike());
			count++;
		}
		return map;
		
	}

}
