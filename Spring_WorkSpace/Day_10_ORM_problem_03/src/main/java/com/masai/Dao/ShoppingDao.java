package com.masai.Dao;

import java.util.List;

import com.masai.entity.Buyer;
import com.masai.entity.Seller;
import com.masai.entity.Store;
import com.masai.exception.SellerException;
import com.masai.exception.StoreException;

public interface ShoppingDao {
	
	public void addStore(Store store);

	public void registerBuyer(Buyer buyer, int store_id) throws StoreException;

	public void registerSeller(Seller seller);

	public void assignSellerWithStore(int seller_id, int store_id) throws SellerException, StoreException;

	public List<Buyer> getAlltheBuyerByStoreName(String store_name) throws StoreException;
}
