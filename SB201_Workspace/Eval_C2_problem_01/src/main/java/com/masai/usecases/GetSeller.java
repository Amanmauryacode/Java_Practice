package com.masai.usecases;

import com.masai.Dao.SellerDao;
import com.masai.Dao.SellerDaoImpl;
import com.masai.entity.Seller;
import com.masai.exception.SellerException;

public class GetSeller {

	public static void main(String[] args) {
		SellerDao dao = new SellerDaoImpl();
		
		try {
			Seller s =dao.getSeller(1);
			System.out.println(s);
		} catch (SellerException e) {
			System.out.println(e.getMessage());
		}
	}

}
