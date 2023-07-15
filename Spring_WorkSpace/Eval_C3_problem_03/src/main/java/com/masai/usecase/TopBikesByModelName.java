package com.masai.usecase;

import java.util.Map;

import com.masai.Dao.BikeOwnerDao;
import com.masai.Dao.BikeOwnerDaoImpl;
import com.masai.model.Bike;
import com.masai.model.BikeOwner;

public class TopBikesByModelName {
	public static void main(String[] args) {
		BikeOwnerDao dao = new BikeOwnerDaoImpl();
		
		Map<BikeOwner, Bike> map = dao.topBikesByModelName(4);
		
		for(Map.Entry<BikeOwner, Bike> set : map.entrySet()) {
			System.out.println(set.getKey());
			System.out.println("-------------------------------------------------------------");
			System.out.println(set.getValue());
			
		}
	}
}
