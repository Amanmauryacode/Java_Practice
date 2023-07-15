package com.masai.service;


import com.masai.entity.ShoppingCart;
import com.masai.exception.CartException;
import com.masai.exception.ProductException;
import com.masai.exception.UserException;

public interface ShoppingCartService {

	public ShoppingCart addItemToCart(Integer uid, Integer pid) throws UserException, ProductException;

	public ShoppingCart removeItemFromCart(Integer uid, Integer pid) throws UserException, ProductException,CartException;

}
