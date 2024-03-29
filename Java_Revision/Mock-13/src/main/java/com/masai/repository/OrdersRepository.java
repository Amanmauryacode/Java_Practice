package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.entity.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {

	@Query("select o from Orders o where o.user.id=?1")
	public List<Orders> getOrderByUserId(Integer uid);
}
