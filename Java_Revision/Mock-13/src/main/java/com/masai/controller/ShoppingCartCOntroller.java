package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entity.ShoppingCart;
import com.masai.exception.CartException;
import com.masai.exception.ProductException;
import com.masai.exception.UserException;
import com.masai.service.ShoppingCartService;

@RestController
@RequestMapping("/cart")
public class ShoppingCartCOntroller {

	@Autowired
	private ShoppingCartService shoppingCartService;
	
	@PutMapping("/addProduct/{uid}/{pid}")
	public ResponseEntity<ShoppingCart> addItemToCart(@PathVariable("uid") Integer uid,@PathVariable("pid") Integer pid) throws UserException, ProductException{
		
		ShoppingCart sc = shoppingCartService.addItemToCart(uid, pid);
		return new ResponseEntity<ShoppingCart>(sc,HttpStatus.ACCEPTED);
	}
	@PutMapping("/removeProduct/{uid}/{pid}")
	public ResponseEntity<ShoppingCart> removeItemFromCart(@PathVariable("uid") Integer uid,@PathVariable("pid") Integer pid) throws UserException, ProductException, CartException{
		
		ShoppingCart sc = shoppingCartService.removeItemFromCart(uid, pid);
		return new ResponseEntity<ShoppingCart>(sc,HttpStatus.ACCEPTED);
	}
}
