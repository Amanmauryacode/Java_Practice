package com.masai.Dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.masai.entity.Product;
import com.masai.entity.Seller;
import com.masai.exception.ProductException;
import com.masai.exception.SellerException;
import com.masai.utility.EMUtil;

public class SellerDaoImpl implements SellerDao {

	@Override
	public Seller addSeller(Seller s) throws SellerException {

		if (s == null)
			throw new SellerException("Null Obejct");

		EntityManager em = EMUtil.provideEntityManager();

		Seller sl = em.find(Seller.class, s.getId());
		if (sl != null)
			throw new SellerException("Seller already Present");

		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
		return s;
	}

	@Override
	public String addProductToSeller(Product prod, int id) throws SellerException {

		EntityManager em = EMUtil.provideEntityManager();

		Seller sl = em.find(Seller.class, id);
		if (sl == null)
			throw new SellerException("Seller NOt Found");

		em.getTransaction().begin();
		sl.getProdList().add(prod);
		em.getTransaction().commit();
		em.close();
		return "Sucessfully Added Product";
	}

	@Override
	public Seller getSeller(int id) throws SellerException {

		EntityManager em = EMUtil.provideEntityManager();

		Seller sl = em.find(Seller.class, id);
		if (sl == null)
			throw new SellerException("Seller NOt Found");

		return sl;
	}

	@Override
	public Product getProductByProductId(int id) throws ProductException {
		EntityManager em = EMUtil.provideEntityManager();

		Product p = em.find(Product.class, id);
		if (p == null)
			throw new ProductException("Product NOt Found");

		return p;
	}

	@Override
	public String AddListOfProduct(List<Product> prod,int id) throws SellerException {
		EntityManager em = EMUtil.provideEntityManager();

		Seller sl = em.find(Seller.class, id);
		if (sl == null)
			throw new SellerException("Seller NOt Found");

		em.getTransaction().begin();

		for(int i=0;i<prod.size();i++) {
			prod.get(i).setSeller(sl);
			sl.getProdList().add(prod.get(i));
		}

		em.getTransaction().commit();
		em.close();

		return "Sucessfully Attached";
	}

}
