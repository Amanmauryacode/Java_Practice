package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.entity.ShoppingCart;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {

	@Query("select sc from ShoppingCart sc where sc.user.id = ?1")
	public ShoppingCart getCartByUserId(Integer uid);
}
