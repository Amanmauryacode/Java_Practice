package com.masai.usecases;

import java.util.ArrayList;
import java.util.List;

import com.masai.Dao.SellerDao;
import com.masai.Dao.SellerDaoImpl;
import com.masai.entity.Product;
import com.masai.exception.ProductException;
import com.masai.exception.SellerException;

public class AddListOfProduct {

	public static void main(String[] args) {
		Product p1 = new Product();

		p1.setName("Pencil");
		p1.setCategory("OTHERS");
		p1.setPrice(50);
		p1.setQuantity(20);

		Product p2 = new Product();

		p2.setName("pen");
		p2.setCategory("OTHERS");
		p2.setPrice(50);
		p2.setQuantity(20);

		Product p3 = new Product();

		p3.setName("Eraser");
		p3.setCategory("OTHERS");
		p3.setPrice(50);
		p3.setQuantity(20);

		Product p4 = new Product();

		p4.setName("Keyboard");
		p4.setCategory("OTHERS");
		p4.setPrice(50);
		p4.setQuantity(20);

		List<Product> prod = new ArrayList<>();
		SellerDao dao = new SellerDaoImpl();
		try {
			String msg = dao.AddListOfProduct(prod, 1);
			System.out.println(msg);
		} catch (SellerException e) {
			System.out.println(e.getMessage());
		}

	}
}
