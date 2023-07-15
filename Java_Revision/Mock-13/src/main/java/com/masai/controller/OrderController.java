package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entity.Orders;
import com.masai.exception.OrderException;
import com.masai.service.OrderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping("/create")
	public ResponseEntity<Orders> createOrder(@Valid @RequestBody Orders order) throws OrderException {

		Orders o = orderService.CreateOrders(order);
		return new ResponseEntity<>(o, HttpStatus.CREATED);
	}

	@GetMapping("/getAllOrder")
	public ResponseEntity<List<Orders>> getAllOrder() throws OrderException {

		List<Orders> o = orderService.getAllOrders();
		return new ResponseEntity<>(o, HttpStatus.CREATED);
	}

	@GetMapping("/getAllOrderByUserId/{uid}")
	public ResponseEntity<List<Orders>> getAllOrderByUserId(@PathVariable Integer uid) throws OrderException {

		List<Orders> o = orderService.getAllOrdersByUserId(uid);
		return new ResponseEntity<>(o, HttpStatus.CREATED);
	}

	@GetMapping("/getOrderByOrderId/{oid}")
	public ResponseEntity<Orders> getOrderByOrderId(@PathVariable Integer oid) throws OrderException {

		Orders o = orderService.getOrderById(oid);
		return new ResponseEntity<>(o, HttpStatus.CREATED);
	}

}
