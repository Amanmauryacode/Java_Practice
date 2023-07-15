package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.Flat;
import com.masai.repository.FlatDao;
@Service
public class FlatServiceImpl  implements FlatService{

	@Autowired
	private FlatDao flatDao;
	
	
	@Override
	public List<Flat> findFlatByPriceLessThan(int price) {
		
		return flatDao.findByPriceLessThan(price);
	}

	@Override
	public List<Flat> findFlatByPriceLessThanEqualTo(int price) {
		
		return flatDao.findByPriceLessThanEqual(price);
	}

	@Override
	public List<Flat> findFlatByPriceGreaterThan(int price) {
		
		return flatDao.findByPriceGreaterThan(price);
	}

	@Override
	public List<Flat> findFlatByPriceBetween(int s_price, int e_price) {
		
		return flatDao.findByPriceBetween(s_price, e_price);
	}

	@Override
	public Flat registerFlat(Flat flat) {
		
		return flatDao.save(flat);
	}

}
