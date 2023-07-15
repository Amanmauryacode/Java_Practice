package com.masai.usecase;

import java.sql.Date;

import com.masai.dao.OrderDao;
import com.masai.dao.OrderDaoImpl;

public class GetItems {

	public static void main(String[] args) {
		OrderDao dao = new OrderDaoImpl();
		try {
			dao.getItems(Date.valueOf("2023-04-04"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
