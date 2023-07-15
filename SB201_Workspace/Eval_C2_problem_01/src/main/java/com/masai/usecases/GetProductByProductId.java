package com.masai.usecases;

import com.masai.Dao.SellerDao;
import com.masai.Dao.SellerDaoImpl;
import com.masai.entity.Product;
import com.masai.exception.ProductException;

public class GetProductByProductId {

	public static void main(String[] args) {
		SellerDao dao = new SellerDaoImpl();

		Product p = null;
		try {
			p = dao.getProductByProductId(1);
		} catch (ProductException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(p);
	}
}
