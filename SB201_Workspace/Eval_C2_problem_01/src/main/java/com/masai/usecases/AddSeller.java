package com.masai.usecases;

import com.masai.Dao.SellerDao;
import com.masai.Dao.SellerDaoImpl;
import com.masai.entity.Product;
import com.masai.entity.Seller;
import com.masai.exception.SellerException;

public class AddSeller {

	public static void main(String[] args) {
		
		Seller s = new Seller();
		s.setName("AMan");
		s.setEmail("aman@gmail.com");
		s.setPhonenumber("6306804122");
		
		Product p1 = new Product();
		
		p1.setName("Pencil");
		p1.setCategory("OTHERS");
		p1.setPrice(50);
		p1.setQuantity(20);
		
		s.getProdList().add(p1);
		
		SellerDao dao = new SellerDaoImpl();
		try {
			Seller sl = dao.addSeller(s);
			System.out.println(sl);
		} catch (SellerException e) {
			System.out.println(e.getMessage());
		}
				
	}
}
