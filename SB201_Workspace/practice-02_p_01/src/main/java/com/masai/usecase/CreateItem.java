package com.masai.usecase;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.EntityManager;

import com.masai.dao.OrderDao;
import com.masai.dao.OrderDaoImpl;
import com.masai.entity.Item;
import com.masai.entity.Orders;
import com.masai.utility.EMUtil;

public class CreateItem {

	public static void main(String[] args) {
		OrderDao dao = new OrderDaoImpl();
		
		Item item = new Item();
		item.setName("KeyBoard");
		item.setEstimatedDeliveryDate(LocalDate.parse("2023-04-05"));
		
		try {
			dao.createItem(item, 1);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("Done...");
	}
}
