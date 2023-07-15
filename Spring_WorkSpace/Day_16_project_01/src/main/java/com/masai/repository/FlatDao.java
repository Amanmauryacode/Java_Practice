package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Flat;
@Repository
public interface FlatDao extends JpaRepository<Flat, Integer> {

	public List<Flat> findByPriceLessThan(int price);

	public List<Flat> findByPriceLessThanEqual(int price);

	public List<Flat> findByPriceGreaterThan(int price);

	public List<Flat> findByPriceBetween(int s_price,int e_price);
}
