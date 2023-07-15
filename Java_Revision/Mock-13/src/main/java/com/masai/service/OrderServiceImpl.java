package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entity.Orders;
import com.masai.exception.OrderException;
import com.masai.repository.OrdersRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrdersRepository ordersRepository;
	
	@Override
	public Orders CreateOrders(Orders order) throws OrderException {
		
		if(order == null )throw new OrderException("Order details not found");
		
		return ordersRepository.save(order);
	}

	@Override
	public List<Orders> getAllOrders() throws OrderException {
		List<Orders> orders  = ordersRepository.findAll();
		if(orders.isEmpty())throw new OrderException("No orders found in record");
		
		return orders;
	}

	@Override
	public List<Orders> getAllOrdersByUserId(Integer uid) throws OrderException {
		List<Orders> orders  = ordersRepository.getOrderByUserId(uid);
		if(orders.isEmpty())throw new OrderException("No orders found in record");
		
		return null;
	}

	@Override
	public Orders getOrderById(Integer oid) throws OrderException {
		Optional<Orders> opt = ordersRepository.findById(oid);
		if(opt.isEmpty())throw new OrderException("No orders found in record with id : "+oid);
		
		return opt.get();
	}

}
