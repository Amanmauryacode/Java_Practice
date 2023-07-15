package com.masai.Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.masai.entity.Buyer;
import com.masai.entity.Seller;
import com.masai.entity.Store;
import com.masai.exception.SellerException;
import com.masai.exception.StoreException;
import com.masai.utility.EMUtil;

public class ShoppingDaoImpl implements ShoppingDao{

	@Override
	public void addStore(Store store) {
		
		EntityManager em = EMUtil.provideEntityManager();
		Store s = em.find(Store.class, store.getStore_id());
		if(s != null)return;
		em.getTransaction().begin();
		em.persist(store);
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public void registerBuyer(Buyer buyer, int store_id) throws StoreException {
		EntityManager em = EMUtil.provideEntityManager();
		Store s = em.find(Store.class, store_id);
		if(s == null)throw new StoreException("Store Not Found!");
		em.getTransaction().begin();
		s.getBuyerList().add(buyer);
		buyer.getStoreList().add(s);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void registerSeller(Seller seller) {
		EntityManager em = EMUtil.provideEntityManager();
		Seller seller1 = em.find(Seller.class, seller.getSeller_id());
		if(seller1 != null)return;
		em.getTransaction().begin();
		em.persist(seller);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void assignSellerWithStore(int seller_id, int store_id) throws SellerException, StoreException {
		EntityManager em = EMUtil.provideEntityManager();
		Store s = em.find(Store.class, store_id);
		Seller seller1 = em.find(Seller.class, seller_id);
		
		if(s == null)throw new StoreException("Store Not Found!");
		if(seller1 == null) throw new SellerException("Seller Not Found!");
		em.getTransaction().begin();
		seller1.getsList().add(s);
		s.setSeller(seller1);
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public List<Buyer> getAlltheBuyerByStoreName(String store_name) throws StoreException {
		EntityManager em = EMUtil.provideEntityManager();
		Query q = em.createQuery("select S from Store s WHERE S.store_name =:nm");
		q.setParameter("nm", store_name);
		List<Store> s = q.getResultList();
		
		List<Buyer> buy = new ArrayList<>();
		
		for(Store st : s ) {
			st.getBuyerList().forEach(buyer->buy.add(buyer));
		}
		return buy;
	}

	
}
