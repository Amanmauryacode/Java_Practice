package com.masai.usecase;

import java.util.List;
import java.util.Map;

import com.masai.Dao.BikeOwnerDao;
import com.masai.Dao.BikeOwnerDaoImpl;
import com.masai.model.Bike;
import com.masai.model.BikeOwner;

public class FindBikeOwnersByBikeColor {

	public static void main(String[] args) {
		
		BikeOwnerDao dao = new BikeOwnerDaoImpl();
		List<BikeOwner> list = dao.findBikeOwnersByBikeColor("black");
		
		list.forEach(System.out::println);
		
		Map<BikeOwner, Bike> map = dao.topBikesByModelName(4);
	}
}
