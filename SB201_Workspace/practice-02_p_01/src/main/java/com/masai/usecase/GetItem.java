package com.masai.usecase;

import com.masai.dao.OrderDao;
import com.masai.dao.OrderDaoImpl;

public class GetItem {

	public static void main(String[] args) {
		OrderDao dao = new OrderDaoImpl();
		try {
			dao.getItem(0);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
