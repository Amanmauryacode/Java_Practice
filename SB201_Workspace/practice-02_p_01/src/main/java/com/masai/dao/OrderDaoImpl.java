package com.masai.dao;

import java.sql.Date;
import java.time.ZoneId;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.masai.entity.Item;
import com.masai.entity.Orders;
import com.masai.exception.ItemNotFound;
import com.masai.exception.OrderNotFound;
import com.masai.utility.EMUtil;

public class OrderDaoImpl implements OrderDao {

	@Override
//	this method should create a item and associate with an order.
	public void createItem(Item item, int orderId) {

		EntityManager em = EMUtil.provideEntityManager();

		Orders order = em.find(Orders.class, orderId);
		if (order == null)
			throw new OrderNotFound("Order Not found !");
		em.getTransaction().begin();

		item.setOrder(order);
		order.getItemList().add(item);
		em.getTransaction().commit();
		em.close();
		System.out.println("Item Added Sucessfully...");

	}

	@Override
//	this method should create multiple item and associate with an order.
	public void createItems(List<Item> items, int orderId) {
		EntityManager em = EMUtil.provideEntityManager();

		Orders order = em.find(Orders.class, orderId);
		if (order == null)
			throw new OrderNotFound("Order Not found !");
		em.getTransaction().begin();
		for (int i = 0; i < items.size(); i++) {
			items.get(i).setOrder(order);
			order.getItemList().add(items.get(i));
			
		}

		em.getTransaction().commit();
		em.close();
		System.out.println("Item List Added Sucessfully...");
	}

	@Override
//	- This method should get item details along with the order details
//	- If the Item is not present then throw Item **Not Found Exception**
	public void getItem(int itemId) {
		// TODO Auto-generated method stub
		EntityManager em = EMUtil.provideEntityManager();

		Item item = em.find(Item.class, itemId);
		if (item == null)
			throw new ItemNotFound("Order Not found !");

		System.out.println(item);

	}

	@Override
//	- This method should get order details along with the details of all the items associated with that order
//	- If the Order is not present then throw Order **Not Found Exception**
	public void getOrder(int orderId) {
		// TODO Auto-generated method stub
		EntityManager em = EMUtil.provideEntityManager();

		Orders order = em.find(Orders.class, orderId);
		if (order == null)
			throw new OrderNotFound("Order Not found !");
		System.out.println(order);
		order.getItemList().forEach(System.out::println);

	}

	@Override
//	- This method should get all item details whose delivery date is greater than inputDate.
//	- If there are no Items Whose delivery date greater than inputDate then print “All Items are expected to be deliver on time”.
	public void getItems(Date inputDate) {
		// TODO Auto-generated method stub
		EntityManager em = EMUtil.provideEntityManager();
		
		Query q = em.createQuery("select i from Item i where i.estimatedDeliveryDate > :inpDate");
		q.setParameter("inpDate", inputDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
		
		List<Item> list = q.getResultList();
		
		if(list == null) {
			System.out.println("All Items are expected to be deliver on time");
		}
		else {
			list.forEach(System.out::println);
		}

	}

}
