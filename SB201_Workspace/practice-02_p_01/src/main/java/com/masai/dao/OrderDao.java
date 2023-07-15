package com.masai.dao;

import java.sql.Date;
import java.util.List;

import com.masai.entity.Item;

public interface OrderDao {

	public void createItem(Item item, int orderId);

	public void createItems(List<Item> items, int orderId);

	public void getItem(int itemId);

	public void getOrder(int orderId);

	public void getItems(Date inputDate);
}
