package com.masai;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ShoppingCart {

	public static void main(String[] args) {
		ApplicationContext clx = new AnnotationConfigApplicationContext(AppConfig.class);
		ProductServiceImpl psi = clx.getBean(ProductServiceImpl.class);
		System.out.println(psi.calculateTotalCost());
	}
}
