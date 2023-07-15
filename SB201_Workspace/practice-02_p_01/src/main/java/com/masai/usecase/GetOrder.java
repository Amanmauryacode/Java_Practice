package com.masai.usecase;

import com.masai.dao.OrderDao;
import com.masai.dao.OrderDaoImpl;

public class GetOrder {
	public static void main(String[] args) {
		OrderDao dao = new OrderDaoImpl();
		try {
			dao.getOrder(1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
