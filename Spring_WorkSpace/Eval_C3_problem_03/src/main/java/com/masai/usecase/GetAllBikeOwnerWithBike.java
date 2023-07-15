package com.masai.usecase;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.masai.Dao.BikeOwnerDao;
import com.masai.Dao.BikeOwnerDaoImpl;
import com.masai.model.BikeOwner;
import com.masai.utility.EMUtil;


public class GetAllBikeOwnerWithBike {

	public static void main(String[] args) {
		
		BikeOwnerDao dao = new BikeOwnerDaoImpl();
		List<BikeOwner> list =  dao.getAllBikeOwnerWithBike();
		list.forEach(System.out::println);
	}
}
