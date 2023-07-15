package com.masai.service;

import java.util.List;

import com.masai.model.Flat;

public interface FlatService {
	public List<Flat> findFlatByPriceLessThan(int price);

	public List<Flat> findFlatByPriceLessThanEqualTo(int price);

	public List<Flat> findFlatByPriceGreaterThan(int price);

	public List<Flat> findFlatByPriceBetween(int s_price,int e_price);
	
	public Flat registerFlat(Flat flat);
}
