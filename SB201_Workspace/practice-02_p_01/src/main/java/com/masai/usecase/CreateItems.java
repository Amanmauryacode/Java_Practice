package com.masai.usecase;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.masai.dao.OrderDao;
import com.masai.dao.OrderDaoImpl;
import com.masai.entity.Item;

public class CreateItems {

	public static void main(String[] args) {
		
		OrderDao dao = new OrderDaoImpl();
		
		Item item = new Item();
		item.setName("Pen");
		item.setEstimatedDeliveryDate(LocalDate.parse("2023-04-05"));
		item.setCreatedAt(LocalDateTime.now());
		
		Item item1 = new Item();
		item1.setName("Pencil");
		item1.setEstimatedDeliveryDate(LocalDate.parse("2023-04-05"));
		item1.setCreatedAt(LocalDateTime.now());
		
		Item item2= new Item();
		item2.setName("Mouse");
		item2.setEstimatedDeliveryDate(LocalDate.parse("2023-04-05"));
		item2.setCreatedAt(LocalDateTime.now());
		
		Item item3 = new Item();
		item3.setName("Lamp");
		item3.setEstimatedDeliveryDate(LocalDate.parse("2023-04-05"));
		item3.setCreatedAt(LocalDateTime.now());
		
		List<Item> list = new ArrayList<>();
		
		list.add(item);
		list.add(item1);
		list.add(item2);
		list.add(item3);
		
		try {
			dao.createItems(list, 2);
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
