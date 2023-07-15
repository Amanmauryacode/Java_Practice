package com.masai.usecases;

import com.masai.Dao.SellerDao;
import com.masai.Dao.SellerDaoImpl;
import com.masai.entity.Product;
import com.masai.exception.SellerException;

public class AddProductToSellerById {

	public static void main(String[] args) {
		Product p1 = new Product();

		p1.setName("Pencil");
		p1.setCategory("OTHERS");
		p1.setPrice(50);
		p1.setQuantity(20);

		SellerDao dao = new SellerDaoImpl();
		try {
			String msg = dao.addProductToSeller(p1, 1);
			System.out.println(msg);
		} catch (SellerException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
