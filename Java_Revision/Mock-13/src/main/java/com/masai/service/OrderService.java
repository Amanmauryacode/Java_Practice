package com.masai.service;

import java.util.List;

import com.masai.entity.Orders;
import com.masai.exception.OrderException;

public interface OrderService {

	public Orders CreateOrders(Orders order)throws OrderException;
	
	public List<Orders> getAllOrders()throws OrderException;
	
	public List<Orders> getAllOrdersByUserId(Integer uid) throws OrderException;
	
	public Orders getOrderById(Integer oid) throws OrderException;
	
}
