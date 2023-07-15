package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entity.Product;
import com.masai.entity.ShoppingCart;
import com.masai.exception.CartException;
import com.masai.exception.ProductException;
import com.masai.exception.UserException;
import com.masai.repository.ProductRepository;
import com.masai.repository.ShoppingCartRepository;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

	@Autowired
	private ShoppingCartRepository cartRepo;
	
	@Autowired
	private ProductRepository prodRepo;

	@Override
	public ShoppingCart addItemToCart(Integer uid, Integer pid) throws UserException, ProductException {
		
		ShoppingCart sc = cartRepo.getCartByUserId(uid);
		
		Optional<Product> prodOpt = prodRepo.findById(pid);
		if(prodOpt.isEmpty())throw new ProductException("Product not found with id : "+pid);
		
		sc.getProducts().add(prodOpt.get());
		
		return cartRepo.save(sc);
	}

	@Override
	public ShoppingCart removeItemFromCart(Integer uid, Integer pid)
			throws UserException, ProductException, CartException {
		ShoppingCart sc = cartRepo.getCartByUserId(uid);
		if(sc.getProducts().isEmpty()) {
			throw new CartException("No product found in record");
		}
		List<Product> list = sc.getProducts();
		for(Product prod : list) {
			if(prod.getId() == pid) {
				list.remove(prod);
			}
		}
		sc.setProducts(list);
		return cartRepo.save(sc);
	}

	
}
